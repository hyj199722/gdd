package com.mju.band3.web.Controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.mju.band3.entity.Bill;
import com.mju.band3.entity.Bill_Status;
import com.mju.band3.entity.Staff;
import com.mju.band3.service.BillService;
import com.mju.band3.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
public class BillController {

    @Autowired
    private BillService billService;


    @RequestMapping(value = "/bill_list")
    public String bill_select(@RequestParam(value = "pn",required = false,defaultValue = "1") Integer pn,Model model,HttpServletRequest request){

        Integer pageNum=null;
        if (request.getParameter("pageNum")!=null){
             pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }
        PageHelper.startPage(pageNum==null?pn:pageNum,10);
        List<Bill> bills = billService.SelectBillAll();
        PageInfo pageInfo=new PageInfo(bills,5);
        model.addAttribute("pageInfo",pageInfo);
        return "bill_list";
    }


    @RequestMapping(value = "/bill_search")
    public String bill_search(@RequestParam(value = "billType",required = false)String billType
            ,@RequestParam(value = "billTaker",required = false)String billTaker,
             @RequestParam(value = "pn",required = false,defaultValue = "1") Integer pn,
             Model model){
//        if (StringUtils.isEmpty(bill.getBillType())&StringUtils.isEmpty(bill.getBillTaker())){
//            return "forward:bill_list";
//        }
        Bill bill=new Bill();
        bill.setBillType(billType);
        bill.setBillTaker(billTaker);
        PageHelper.startPage(pn,10);
        List<Bill> bills = billService.billTaker(bill);
        PageInfo pageInfo=new PageInfo(bills,5);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("billType",billType);
        model.addAttribute("billTaker",billTaker);

        return "bill_search_list";

    }





    @RequestMapping(value = "/to_bill_edit",method = RequestMethod.GET)
    public String bill_edit(@RequestParam(value = "billId")Integer billId,Integer pageNum,Model model){
        Bill bill = billService.selectByPrimaryKey(billId);
        List<Staff> allStaff = billService.getAllStaff();
        model.addAttribute("staff",allStaff);
        model.addAttribute("bill",bill);
        model.addAttribute("pageNum",pageNum);

        return "/bill_edit";

    }

    @RequestMapping(value = "/to_bill_state",method = RequestMethod.GET)
    public String bill_state(){

        return "forward:bill_destroy_search";

    }


    @RequestMapping(value = "/bill_edit",method = RequestMethod.POST)
    public String bill_edit(Bill bill,Model model,Integer pageNum){
        billService.updateBillEdit(bill);
        model.addAttribute("baseResult",BaseResult.success("修改成功"));
        model.addAttribute("pageNum",pageNum);
        return "forward:bill_list";

    }


    @RequestMapping(value = "/bill_delete",method = RequestMethod.POST)
    public String bill_delete(Integer  billId, RedirectAttributes model)  {
        billService.deleteByPrimaryKeyWithoutWay(billId);
        billService.deleteBill(billId);
        model.addFlashAttribute("baseResult",BaseResult.success("删除票据成功"));
        return "redirect:bill_list";

    }

    @RequestMapping(value = "/to_bill_add",method = RequestMethod.GET)
    public String bill_add(Model model,HttpServletRequest request){
        List<Staff> allStaff = billService.getAllStaff();
        model.addAttribute("staff",allStaff);
        //取bill_save方法里面addFlashAttribute的值。
//        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
//        if (inputFlashMap!=null){
//            System.out.println(inputFlashMap.get("baseResult").toString());
//        }
        return "bill_add";
    }

    @RequestMapping(value = "/bill_save",method = RequestMethod.POST)
    public String bill_save(Bill bill, RedirectAttributes redirectAttributes,Model model){
        String regex = "(c|r){1}[2][0-9]{3}[0-9]{8}";
        bill.setBillEnd(bill.getBillEnd().toLowerCase());
        redirectAttributes.addFlashAttribute("bill",bill);

        if ("请选择".equals(bill.getBillTaker())){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("请选择领票人"));
            return "redirect:to_bill_add";
        }
        if ("请选择".equals(bill.getBillGiver())){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("请选择分发人"));
            return "redirect:to_bill_add";
        }
        if (StringUtils.isEmpty(bill.getBillLocation())){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("请输入接货点"));
            return "redirect:to_bill_add";
        }
        if (StringUtils.isEmpty(bill.getBillEnd())){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("单据结束号不能为空"));
            return "redirect:to_bill_add";
        }
        String cr = ("1".equals(bill.getBillType()) ? "c" : "r");
        if (!bill.getBillEnd().startsWith(cr)){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("友情提示：货运单以C开头，运输合同以R开头"));
            return "redirect:to_bill_add";
        }

        if (!bill.getBillEnd().matches(regex)){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("结束号格式不正确，请以c或r+时间+分发量为格式标准"));
            return "redirect:to_bill_add";
        }
        String timebegin = bill.getBillBegin().substring(1, 9);
        String timeend = bill.getBillEnd().substring(1, 9);
        if (!timebegin.equals(timeend)){
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("时间模块不正确，请参考当前时间"+simpleDateFormat.format(new Date())));
            return "redirect:to_bill_add";
        }
        String countbegin = bill.getBillBegin().substring(9, 13);
        String countend = bill.getBillEnd().substring(9, 13);
        int intBegin = Integer.parseInt(countbegin);
        int intEnd = Integer.parseInt(countend);
        if (intEnd<intBegin){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("结束分发票据量不能小于开始量"));
            return "redirect:to_bill_add";
        }
        Integer existBegin=billService.selectBillId(bill.getBillBegin());
        System.out.println(existBegin);
        if (existBegin!=null){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("当前票据号已经存在"));
            return "redirect:to_bill_add";
        }

        redirectAttributes.addFlashAttribute("lastInfo",bill.getBillEnd());
        Date writeDate=bill.getBillDate();
        List<Bill_Status > StatusList=new ArrayList<>();
        billService.insertBill(bill);
        int newBillId = billService.selectBillId(bill.getBillBegin());
        int begin=Integer.parseInt(bill.getBillBegin().substring(9,13));
        int end=Integer.parseInt(bill.getBillEnd().substring(9,13));
        int mul=end-begin;
        String substring = bill.getBillBegin().substring(0, 1);
        String substring2 = bill.getBillBegin().substring(1, 13);
        long l = Long.parseLong(substring2);
        for (int i=0;i<=mul;i++){
            String s = substring + (l + i);
            StatusList.add(new Bill_Status(newBillId,s,0,writeDate));
        }
        billService.BathInsertBill_Status(StatusList);

        model.addAttribute("baseResult",BaseResult.success("票据分发成功"));
        return "forward:bill_list?pageNum="+Integer.MAX_VALUE;

    }


    @ResponseBody
    @RequestMapping(value = "/sexy_generate",method = RequestMethod.POST)
    public String sexy_generate(String billType,String billDate)  {
        String s = ("1".equals(billType) ? "c" : "r");
        String replace = billDate.replace("-", "");
        String bill=s+replace.trim();
        List<Bill_Status> bill_statuses = billService.sexyGenerator(bill);
        String biger=s+"197001010001";
        if (bill_statuses.isEmpty()){
            return (s+replace+"0001").replace(" ","");
        }else{
            for (Bill_Status bill_status : bill_statuses) {
                if (bill_status.getWaybillId().compareTo(biger)>=1){

                    biger=bill_status.getWaybillId();
                }
            }
            String head = biger.substring(0, 1);
            String body = biger.substring(1, 13);
            long l = Long.parseLong(body);
            long addInt=l+1;
            String end=head+addInt;
            return end;
        }



    }

    @RequestMapping(value = "/bill_destroy_search")
    public String bill_destroy_search(@RequestParam(value = "pn",required = false,defaultValue = "1")Integer pn,String waybillId,String billType,String billStatus,String timeRange,Model model){

        model.addAttribute("waybillId",waybillId);
        model.addAttribute("billType",billType);
        model.addAttribute("billStatus",billStatus);
        model.addAttribute("timeRange",timeRange);
        System.out.println(waybillId+billType+billStatus+timeRange);
        PageHelper.startPage(pn,10);
        String regex = "(c|r){1}[2][0-9]{3}[0-9]{8}";
        String EnbillType =null;
        if (!StringUtil.isEmpty(billType)){
            EnbillType= ("1".equals(billType) ? "c" : "r");
        }

        if (!StringUtils.isEmpty(waybillId)){
            if (!waybillId.matches(regex)){
                model.addAttribute("baseResult",BaseResult.fail("票据编号不正确，请以c或r+时间+具体记录数为格式标准"));
                return "bill_state";
            }
        }

            if (!StringUtils.isEmpty(waybillId)){
                if (!StringUtils.isEmpty(billType))
                if (!waybillId.startsWith(EnbillType)){
                    model.addAttribute("baseResult",BaseResult.fail("单据编号与单据类型不符合"));
                }
            }


        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM-dd-yyyy");
        Date timeRange1 =null;
        Date timeRange2 =null;


        if (!StringUtils.isEmpty(timeRange)){
            String[] split = timeRange.split(" - ");
             String be=split[0].replace("/","-");
             String af=split[1].replace("/","-");


            try {
                timeRange1 = simpleDateFormat.parse(be);
                timeRange2 = simpleDateFormat.parse(af);


            } catch (ParseException e) {
                model.addAttribute("baseResult",BaseResult.fail("因为一点小原因，导致系统开了一次小差，请重试"));
                return "bill_state";
//            e.printStackTrace();
            }
        }

        Map<String,Object> map=new HashMap<>();

        map.put("waybillId",waybillId);
        map.put("billType",EnbillType);
        map.put("billStatus",billStatus);
        map.put("timeRange1",timeRange1);
        map.put("timeRange2",timeRange2);
        List<Bill_Status> bill_statuses = billService.bill_destroy_search(map);
        PageInfo pageInfo=new PageInfo(bill_statuses,5);
        model.addAttribute("pageInfo",pageInfo);
        return "bill_state";
    }


    @RequestMapping(value = "/bill_destroy")
    public String bill_destroy(Model model,String waybillId){
        String regex = "(c|r){1}[2][0-9]{3}[0-9]{8}";
        model.addAttribute("waybillId",waybillId);
        if (StringUtils.isEmpty(waybillId)){
            model.addAttribute("baseResult",BaseResult.fail("单据编号不能为空"));
            return "bill_destroy";
        }
        if (!waybillId.matches(regex)){
            model.addAttribute("baseResult",BaseResult.fail("单据编号格式不正确，请以c或r+时间+分发量为格式标准"));
            return "bill_destroy";
        }
        Bill_Status bill_status = billService.selectSingleWayBillId(waybillId);


        if (bill_status==null){
            model.addAttribute("baseResult",BaseResult.fail("单据编号不存在或单据编号错误，请查询后在重试"));
            return "bill_destroy";
        } if (bill_status.getBillStatus()==2){
            model.addAttribute("baseResult",BaseResult.fail("当前票据号已是作废状态"));
            return "bill_destroy";
        }else{
            billService.updateSingleStatusDestroy(waybillId);
            model.addAttribute("baseResult",BaseResult.success("作废成功"));
            return "forward:bill_destroy_search";
        }



    }



    @RequestMapping(value = "/to_bill_destroy",method = RequestMethod.GET)
    public String bill_destroy(){

        return "bill_destroy";

    }







}
