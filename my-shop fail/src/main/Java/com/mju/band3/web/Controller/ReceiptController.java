package com.mju.band3.web.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mju.band3.entity.*;
import com.mju.band3.service.Customer_ReceiptService;
import com.mju.band3.service.Driver_ReceiptService;
import com.mju.band3.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReceiptController {
    private static final String COOKIE_NAME_USER_INFO="userInfo";
    @Autowired
    private Driver_ReceiptService driver_receiptService;
    @Autowired
    private Customer_ReceiptService customer_receiptService;

    //司机回执
    //司机回执删除
    @RequestMapping(value = "/driver_receipt_delete",method = RequestMethod.POST)
    public String driver_receipt_delete(Integer  driverReceiptId, RedirectAttributes model)  {

        driver_receiptService.deleteDriver_Receipt(driverReceiptId);

        model.addFlashAttribute("baseResult",BaseResult.success("删除回执成功"));
        return "redirect:driver_receipt_select";

    }
    //司机回执修改
    @RequestMapping(value = "/to_driver_receipt_edit",method = RequestMethod.GET)
    public String driver_receipt_edit(@RequestParam(value = "driverReceiptId")Integer driverReceiptId,Model model){
        Driver_Receipt driver_receipt=driver_receiptService.selectByPrimaryKey(driverReceiptId);
        model.addAttribute("driver_receipt",driver_receipt);
        return "driver_receipt_edit";
    }
    @RequestMapping(value = "/driver_receipt_edit",method = RequestMethod.POST)
    public String driver_receipt_edit(Driver_Receipt driver_receipt,Model model){
        driver_receiptService.update_driver_receipt_edit(driver_receipt);
        model.addAttribute("baseResult",BaseResult.success("修改成功"));
        return "forward:driver_receipt_select";

    }
    //司机回执增加
    @RequestMapping(value = "/driver_receipt_add",method = RequestMethod.GET)
    public String driver_receipt_add(){
        return "driver_receipt_add";
    }

    @RequestMapping(value = "/driver_receipt_save")
    public String driver_receipt_save(Driver_Receipt driver_receipt,RedirectAttributes redirectAttributes,Model model){
        String regex = "(r){1}[2][0-9]{3}[0-9]{8}";
        redirectAttributes.addFlashAttribute("driver_receipt",driver_receipt);
        if (!driver_receipt.getContractId().matches(regex)){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("格式不正确，请以r+时间+分发量为格式标准"));
            return "redirect:driver_receipt_add";
        }
        if (StringUtils.isEmpty(driver_receipt.getContractId())){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("请输入运输合同编号"));
            return "redirect:driver_receipt_add";
        }
        if (StringUtils.isEmpty(driver_receipt.getDriverReceiptName())){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("请输入司机名称"));
            return "redirect:driver_receipt_add";
        }
        if (StringUtils.isEmpty(driver_receipt.getDriverReceiptCheck())){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("请输入验收人"));
            return "redirect:driver_receipt_add";
        }
        if (StringUtils.isEmpty(driver_receipt.getDriverReceiptRecord())){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("请输入验收记录"));
            return "redirect:driver_receipt_add";
        }
       String exitContractId=driver_receiptService.selectContractId(driver_receipt.getContractId());
        System.out.println(exitContractId);
        if (exitContractId!=null){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("当前运输合同的回执已存在"));
            return "redirect:driver_receipt_add";
        }
        //String selectContractIdNull=driver_receiptService.selectContractIdNull(driver_receipt.getContractId());
        //System.out.println(selectContractIdNull);
        //if (selectContractIdNull==null){
        //    redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("当前运输合同编号不存在"));
        //    return "redirect:driver_receipt_add";
        //}

        driver_receiptService.insertDriver_Receipt(driver_receipt);
        model.addAttribute("baseResult",BaseResult.success("添加司机回执成功"));
        return "forward:driver_receipt_select?pageNum="+Integer.MAX_VALUE;
    }
    //司机回执列表
    @RequestMapping(value = "/driver_receipt_select")
    public String driver_receipt_select(@RequestParam(value = "pn",required = false,defaultValue = "1") Integer pn,Model model,HttpServletRequest request){

        Integer pageNum=null;
        if (request.getParameter("pageNum")!=null){
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }
        PageHelper.startPage(pageNum==null?pn:pageNum,10);
        List<Driver_Receipt> receipts = driver_receiptService.SelectDriver_ReceiptServiceAll();
        PageInfo pageInfo=new PageInfo(receipts,5);
        model.addAttribute("pageInfo",pageInfo);
        return "driver_receipt_select";
    }
    //司机回执查询
    @RequestMapping(value = "/driver_receipt_search")
    public String driver_receipt_search(@RequestParam(value = "contractId",required = false)String contractId
            ,@RequestParam(value = "driverReceiptName",required = false)String driverReceiptName,
                              @RequestParam(value = "pn",required = false,defaultValue = "1") Integer pn,
                              Model model,String timeRange){
        model.addAttribute("timeRange",timeRange);
        Driver_Receipt driver_receipt=new Driver_Receipt();
        driver_receipt.setContractId(contractId);
        driver_receipt.setDriverReceiptName(driverReceiptName);
        PageHelper.startPage(pn,10);
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
        map.put("contractId",contractId);
        map.put("driverReceiptName",driverReceiptName);

        map.put("timeRange1",timeRange1);
        map.put("timeRange2",timeRange2);
        List<Driver_Receipt> driver_receipts = driver_receiptService.Driver_Receipt_search(map);
        PageInfo pageInfo=new PageInfo(driver_receipts,5);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("contractId",contractId);
        model.addAttribute("driverName",driverReceiptName);

        return "driver_receipt_select_list";

     }


    //顾客回执
    //顾客回执增加
    @RequestMapping(value = "/customer_receipt_add",method = RequestMethod.GET)
    public String customer_receipt_add(){
        return "customer_receipt_add";
    }

    @RequestMapping(value = "/customer_receipt_save")
    public String customer_receipt_save(Customer_Receipt customer_receipt,RedirectAttributes redirectAttributes,Model model){
        String regex = "(c){1}[2][0-9]{3}[0-9]{8}";
        redirectAttributes.addFlashAttribute("customer_receipt",customer_receipt);
        if (!customer_receipt.getWaybillId().matches(regex)){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("格式不正确，请以c+时间+分发量为格式标准"));
            return "redirect:customer_receipt_add";
        }
        if (StringUtils.isEmpty(customer_receipt.getWaybillId())){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("请输入货运单编号"));
            return "redirect:customer_receipt_add";
        }
        if (StringUtils.isEmpty(customer_receipt.getCustomerReceiptName())){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("请输入司机名称"));
            return "redirect:customer_receipt_add";
        }
        if (StringUtils.isEmpty(customer_receipt.getCustomerReceiptCheck())){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("请输入验收人"));
            return "redirect:customer_receipt_add";
        }
        if (StringUtils.isEmpty(customer_receipt.getCustomerReceiptRecord())){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("请输入验收记录"));
            return "redirect:customer_receipt_add";
        }
        String exitwayBillId=customer_receiptService.selectwaybillId(customer_receipt.getWaybillId());
        System.out.println(exitwayBillId);
        if (exitwayBillId!=null){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("当前货运单的回执已存在"));
            return "redirect:customer_receipt_add";
        }
        //String exitWaybillIdNull=customer_receiptService.selectwaybillIdNull(customer_receipt.getWaybillId());
        //System.out.println(exitWaybillIdNull);
        //if (exitWaybillIdNull==null){
        //    redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("该货运单不存在"));
        //    return "redirect:customer_receipt_add";
        //}
        customer_receiptService.insert(customer_receipt);
        model.addAttribute("baseResult",BaseResult.success("添加客户回执成功"));
        return "forward:customer_receipt_select?pageNum="+Integer.MAX_VALUE;
    }
    //顾客回执列表
    @RequestMapping(value = "/customer_receipt_select")
    public String customer_receipt_select(@RequestParam(value = "pn",required = false,defaultValue = "1") Integer pn,Model model,HttpServletRequest request){

        Integer pageNum=null;
        if (request.getParameter("pageNum")!=null){
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }
        PageHelper.startPage(pageNum==null?pn:pageNum,10);
        List<Customer_Receipt> receipts = customer_receiptService.selectAll();
        PageInfo pageInfo=new PageInfo(receipts,5);
        model.addAttribute("pageInfo",pageInfo);
        return "customer_receipt_select";
    }
    //顾客回执查询
    @RequestMapping(value = "/customer_receipt_search")
    public String customer_receipt_search(@RequestParam(value = "waybillId",required = false)String waybillId
            ,@RequestParam(value = "customerReceiptName",required = false)String customerReceiptName,
                                        @RequestParam(value = "pn",required = false,defaultValue = "1") Integer pn,
                                        Model model,String timeRange){
        model.addAttribute("timeRange",timeRange);
        Customer_Receipt customer_receipt=new Customer_Receipt();
        customer_receipt.setWaybillId(waybillId);
        customer_receipt.setCustomerReceiptName(customerReceiptName);
        PageHelper.startPage(pn,10);


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
        map.put("customerReceiptName",customerReceiptName);

        map.put("timeRange1",timeRange1);
        map.put("timeRange2",timeRange2);
        List<Customer_Receipt> customer_receipts = customer_receiptService.CustomerReceiptSearch(map);
        PageInfo pageInfo=new PageInfo(customer_receipts,5);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("waybillId",waybillId);
        model.addAttribute("customerReceiptName",customerReceiptName);

        return "customer_receipt_select_list";

    }
    //顾客回执删除
    @RequestMapping(value = "/customer_receipt_delete",method = RequestMethod.POST)
    public String customer_receipt_delete(Integer  customerReceiptId, RedirectAttributes model)  {

        customer_receiptService.DeleteCustomerReceipt(customerReceiptId);

        model.addFlashAttribute("baseResult",BaseResult.success("删除回执成功"));
        return "redirect:customer_receipt_select";

    }
    //顾客回执修改
    @RequestMapping(value = "/to_customer_receipt_edit",method = RequestMethod.GET)
    public String customer_receipt_edit(@RequestParam(value = "customerReceiptId")Integer customerReceiptId,Model model){
        Customer_Receipt customer_receipt=customer_receiptService.selectByPrimaryKey(customerReceiptId);
        model.addAttribute("customer_receipt",customer_receipt);
        return "customer_receipt_edit";
    }
    @RequestMapping(value = "/customer_receipt_edit",method = RequestMethod.POST)
    public String customer_receipt_edit(Customer_Receipt customer_receipt,Model model){
        customer_receiptService.updateCustomerReceiptEdit(customer_receipt);
        model.addAttribute("baseResult",BaseResult.success("修改成功"));
        return "forward:customer_receipt_select";

    }



}
