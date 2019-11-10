package com.mju.band3.web.Controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mju.band3.entity.Contract;
import com.mju.band3.entity.Driver;
import com.mju.band3.entity.User;
import com.mju.band3.entity.Waybill;
import com.mju.band3.service.ContractService;
import com.mju.band3.service.UserService;
import com.mju.band3.utils.BaseResult;
import com.mju.band3.utils.CookieUtils;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class ContractController {
    private static final String COOKIE_NAME_USER_INFO="userInfo";
    @Autowired
    private ContractService contractService;



    //运输合同
    @RequestMapping(value = "/contract_add",method = RequestMethod.GET)
    public String contract_add(Model model){
        System.out.println("到了这里了3！");
        model.addAttribute("contractId",contractService.latestRecord());
        model.addAttribute("drivers",contractService.getDrivers());
        return "contract_add";

    }
    @RequestMapping(value = "/contract_edit",method = RequestMethod.GET)
    public String contract_edit(Model model,@RequestParam(value = "contractId") String contractId){
        Contract contract=contractService.getContract(contractId);
        model.addAttribute("drivers",contractService.getDrivers());
        model.addAttribute("contract",contract);
        return "contract_edit";

    }
    @RequestMapping(value = "/contract_save",method = RequestMethod.POST)
    public String contract_save(Contract contract,RedirectAttributes redirectAttributes,HttpServletRequest request,Model model){
        System.out.println("到了这里了！");
        redirectAttributes.addFlashAttribute("contract", contract);
        if (StringUtils.isEmpty(contract.getContractId())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写运输单编号"));
            return "redirect:contract_add";
        }
        if (StringUtils.isEmpty(contract.getContractDriver())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写承运人"));
            return "redirect:contract_add";
        }
        if (StringUtils.isEmpty(contract.getContractCarnum())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写车牌号"));
            return "redirect:contract_add";
        }
        if (StringUtils.isEmpty(contract.getContractOperationLicense())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写营运证"));
            return "redirect:contract_add";
        }
        if (StringUtils.isEmpty(contract.getContractDriverLicense())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写驾驶证"));
            return "redirect:contract_add";
        }
        if (StringUtils.isEmpty(contract.getContractDrivingLicense())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写行驶证"));
            return "redirect:contract_add";
        }
        if (StringUtils.isEmpty(contract.getContractBegin())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写发货地"));
            return "redirect:contract_add";
        }
        if (StringUtils.isEmpty(contract.getContractBeginDate())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写起运时间"));
            return "redirect:contract_add";
        }
        if (StringUtils.isEmpty(contract.getContractEnd())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写交货地"));
            return "redirect:contract_add";
        }
        if (StringUtils.isEmpty(contract.getContractEndDate())){
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写到达时间"));
            return "redirect:contract_add";
        }
        if (StringUtils.isEmpty(contract.getContractRecive())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写收货联系人"));
            return "redirect:contract_add";
        }
        if (StringUtils.isEmpty(contract.getContractRecivePhone())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写联系人手机"));
            return "redirect:contract_add";
        }
        if (StringUtils.isEmpty(contract.getContractReciveAddress())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写收货详细地址"));
            return "redirect:contract_add";
        }
        if (StringUtils.isEmpty(contract.getContractBond())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写承运人订装货物保证金"));
            return "redirect:contract_add";
        }
        if (StringUtils.isEmpty(contract.getContractService())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写配车服务费"));
            return "redirect:contract_add";
        }
        if (0==contract.getContractPayType()) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请选择运费结算方式"));
            return "redirect:contract_add";
        }
        if (StringUtils.isEmpty(contract.getContractDeposit())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写送货单回执押金"));
            return "redirect:contract_add";
        }
        if (0==contract.getContractMoneyType()) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写运费计价方式"));
            return "redirect:contract_add";
        }
        if (StringUtils.isEmpty(contract.getContractMoney())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写运费"));
            return "redirect:contract_add";
        }
        if (StringUtils.isEmpty(contract.getContractPrepay())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写预付费用"));
            return "redirect:contract_add";
        }
        if (StringUtils.isEmpty(contract.getContractDate())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写签订时间"));
            return "redirect:contract_add";
        }
        contract.setContractStatus(1);
        Driver driver=contractService.getDriver(Integer.valueOf(contract.getContractDriver()));
        contract.setContractDriver(driver.getDriverName());
        contractService.saveContract(contract);
        contract=contractService.getContract(contract.getContractId());
        model.addAttribute("drivers",contractService.getDrivers());
        model.addAttribute("contract",contract);
        return "contract_edit";
    }
    @RequestMapping(value = "/contract_select",method = RequestMethod.GET)
    public String contract_select(Model model,
                                  @RequestParam(value = "timeRange", required = false) String timeRange,
                                  @RequestParam(value = "pn",required = false,defaultValue = "1") Integer pn,
                                  @RequestParam(value = "contractId",required = false) String contractId,
                                  @RequestParam(value = "contractDriver",required = false) String contractDriver,
                                  @RequestParam(value = "contractStatus",required = false) Integer contractStatus,
                                  HttpServletRequest request){
        DateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Date timeRange1 = null;
        Date timeRange2 = null;
        if (!StringUtils.isEmpty(timeRange)) {
            String[] split = timeRange.split(" - ");
            String be = split[0].replace("/", "-");
            String af = split[1].replace("/", "-");
            try {
                timeRange1 = simpleDateFormat.parse(be);
                timeRange2 = simpleDateFormat.parse(af);
                System.out.println(timeRange1);
                System.out.println(timeRange2);
            } catch (ParseException e) {
                return "redirect:contract_add";
//            e.printStackTrace();
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("contractId", contractId);
        map.put("contractDriver", contractDriver);
        map.put("contractStatus", contractStatus);
        map.put("timeRange1", timeRange1);
        map.put("timeRange2", timeRange2);
        List<Contract> contracts = contractService.contractSearch(map);
        model.addAttribute("contractId", contractId);
        model.addAttribute("contractDriver", contractDriver);
        model.addAttribute("contractStatus", contractStatus);
        model.addAttribute("timeRange", timeRange);
        Integer pageNum=null;
        if (request.getParameter("pageNum")!=null){
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }
        PageHelper.startPage(pageNum==null?pn:pageNum,10);
        PageInfo pageInfo=new PageInfo(contracts,5);
        model.addAttribute("pageInfo",pageInfo);
        return "contract_select";

    }

    @RequestMapping(value = "/contract_update",method = RequestMethod.POST)
    public String contract_update(Model model,Contract contract,RedirectAttributes redirectAttributes){
        System.out.println(contract.toString());
        if (StringUtils.isEmpty(contract.getContractId())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写运输单编号"));
            return "redirect:contract_select";
        }
        if ("0".equals(contract.getContractDriver())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写承运人"));
            return "redirect:contract_select";
        }
        if (StringUtils.isEmpty(contract.getContractCarnum())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写车牌号"));
            return "redirect:contract_select";
        }
        if (StringUtils.isEmpty(contract.getContractOperationLicense())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写营运证"));
            return "redirect:contract_select";
        }
        if (StringUtils.isEmpty(contract.getContractDriverLicense())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写驾驶证"));
            return "redirect:contract_select";
        }
        if (StringUtils.isEmpty(contract.getContractDrivingLicense())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写行驶证"));
            return "redirect:contract_select";
        }
        if (StringUtils.isEmpty(contract.getContractBegin())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写发货地"));
            return "redirect:contract_select";
        }
        if (StringUtils.isEmpty(contract.getContractBeginDate())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写起运时间"));
            return "redirect:contract_select";
        }else {
            if (!this.isRqFormat(contract.getContractBeginDate().toString())) {
                redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("起运时间格式错误!范例:2019-02-14"));
                return "redirect:contract_select";
            }
        }
        if (StringUtils.isEmpty(contract.getContractEnd())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写交货地"));
            return "redirect:contract_select";
        }
        if (StringUtils.isEmpty(contract.getContractEndDate())){
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写到达时间"));
            return "redirect:contract_select";
        }else {
            if (!this.isRqFormat(contract.getContractEndDate().toString())) {
                redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("到达时间格式错误!范例:2019-02-14"));
                return "redirect:contract_select";
            }
        }
        if (StringUtils.isEmpty(contract.getContractRecive())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写收货联系人"));
            return "redirect:contract_select";
        }
        if (StringUtils.isEmpty(contract.getContractRecivePhone())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写联系人手机"));
            return "redirect:contract_select";
        }
        if (StringUtils.isEmpty(contract.getContractReciveAddress())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写收货详细地址"));
            return "redirect:contract_select";
        }
        if (StringUtils.isEmpty(contract.getContractBond())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写承运人订装货物保证金"));
            return "redirect:contract_select";
        }
        if (StringUtils.isEmpty(contract.getContractService())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写配车服务费"));
            return "redirect:contract_select";
        }
        if (0==contract.getContractPayType()) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请选择运费结算方式"));
            return "redirect:contract_select";
        }
        if (StringUtils.isEmpty(contract.getContractDeposit())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写送货单回执押金"));
            return "redirect:contract_select";
        }
        if (0==contract.getContractMoneyType()) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写运费计价方式"));
            return "redirect:contract_select";
        }
        if (StringUtils.isEmpty(contract.getContractMoney())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写运费"));
            return "redirect:contract_select";
        }
        if (StringUtils.isEmpty(contract.getContractPrepay())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写预付费用"));
            return "redirect:contract_select";
        }
        if (StringUtils.isEmpty(contract.getContractDate())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写签订时间"));
            return "redirect:contract_select";
        }else {
            if (!this.isRqFormat(contract.getContractDate().toString())) {
                redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("签订时间格式错误!范例:2019-02-14"));
                return "redirect:waybill_add";
            }
        }
        contract.setContractStatus(1);
        Driver driver=contractService.getDriver(Integer.valueOf(contract.getContractDriver()));
        System.out.println("司机名称"+driver.getDriverName());
        contract.setContractDriver(driver.getDriverName());
        contractService.updateContract(contract);
        return "redirect:contract_select";

    }

    @ResponseBody
    @RequestMapping(value = "/driver_change",method = RequestMethod.POST)
    public String driver_change(Integer contractDriver){
        if (contractDriver==0){
            Map<String,String> map=new HashMap<>();
            map.put("driverCarnum","");
            map.put("driverLicense","");
            map.put("drivingLicense","");
            Gson gson=new Gson();
            String s = gson.toJson(map);
            return s;
        }
        Driver driver=contractService.getDriver(contractDriver);
        Map<String,String> map=new HashMap<>();
        map.put("driverCarnum",driver.getDriverCarnum());
        map.put("driverLicense",driver.getDriverLicense());
        map.put("drivingLicense",driver.getDrivingLicense());
        Gson gson=new Gson();
        String s = gson.toJson(map);
        return s;
    }
    public boolean isRqFormat(String mes) {
        String format = "([0-9]{4})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])";
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(mes);
        if (matcher.matches()) {
            pattern = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})");
            matcher = pattern.matcher(mes);
            if (matcher.matches()) {
                int y = Integer.valueOf(matcher.group(1));
                int m = Integer.valueOf(matcher.group(2));
                int d = Integer.valueOf(matcher.group(3));
                if (d > 28) {
                    Calendar c = Calendar.getInstance();
                    c.set(y, m - 1, 1);
                    //每个月的最大天数
                    int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                    return (lastDay >= d);
                }
            }
            return true;
        }
        return false;

    }

}
