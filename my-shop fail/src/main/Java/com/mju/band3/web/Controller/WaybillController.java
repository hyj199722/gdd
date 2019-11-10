package com.mju.band3.web.Controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.mju.band3.entity.User;
import com.mju.band3.entity.Waybill;
import com.mju.band3.service.UserService;
import com.mju.band3.service.WaybillService;
import com.mju.band3.utils.BaseResult;
import com.mju.band3.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
public class WaybillController {
    private static final String COOKIE_NAME_USER_INFO = "userInfo";
    @Autowired
    private UserService userService;
    @Autowired
    private WaybillService waybillService;

    //货物单
    @RequestMapping(value = "/waybill_add", method = RequestMethod.GET)
    public String waybill_add(Model model) {
        String newId = waybillService.latestRecord();
        model.addAttribute("waybillId", newId);
        model.addAttribute("staff", waybillService.getStaff());
        return "waybill_add";

    }

    @RequestMapping(value = "/waybill_edit", method = RequestMethod.GET)
    public String waybill_edit(HttpServletRequest request,RedirectAttributes redirectAttributes, Model model, @RequestParam(value = "waybillId") String waybillId) {
        String waybillId1 = null;
        if (waybillId.isEmpty()) {
            waybillId1 = request.getAttribute("waybillEditId").toString();
        } else {
            waybillId1 = waybillId;
        }
        Waybill waybill = waybillService.getWaybill(waybillId1);
        if (waybill.getWaybillStatus()!=1){
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("货运单已发货，不可编辑"));
        }
        model.addAttribute("staff", waybillService.getStaff());
        model.addAttribute("waybill", waybill);
        return "waybill_edit";

    }

    @RequestMapping(value = "/waybill_save", method = RequestMethod.POST)
    public String waybill_save(Waybill waybill, RedirectAttributes redirectAttributes, HttpServletRequest request, Model model) {
        System.out.println("waybillsave");
        redirectAttributes.addFlashAttribute("waybill", waybill);
        String waybillDateS = request.getParameter("waybillDate");
        String waybillFillDateS = request.getParameter("waybillFillDate");
/*        System.out.println(waybillDateS);
        System.out.println(waybillFillDateS);*/
        String waybillId = request.getParameter("waybillId");
        if (StringUtils.isEmpty(waybill.getWaybillId())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写货运单编号"));
            if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
                return "redirect:waybill_add";
            }else{
                Waybill waybill1 = waybillService.getWaybill(waybill.getWaybillId());
                model.addAttribute("staff", waybillService.getStaff());
                model.addAttribute("waybill", waybill1);
                return "waybill_edit";
            }

        }
        if ("无可填写货运单".equals(waybill.getWaybillId())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("无可填写货运单,请工作人员领票后再添加"));
            if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
                return "redirect:waybill_add";
            }else{
                Waybill waybill1 = waybillService.getWaybill(waybill.getWaybillId());
                model.addAttribute("staff", waybillService.getStaff());
                model.addAttribute("waybill", waybill1);
                return "waybill_edit";
            }
        }
        if (StringUtils.isEmpty(waybill.getWaybillDate())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写托运日期"));
            return "redirect:waybill_add";
        } else {
            if (!this.isRqFormat(waybillDateS)) {
                redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("托运日期格式错误!范例:2019-02-14"));
                return "redirect:waybill_add";
            }
        }
        if (StringUtils.isEmpty(waybill.getWaybillBegin())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写起始站"));
            if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
                return "redirect:waybill_add";
            }else{
                Waybill waybill1 = waybillService.getWaybill(waybill.getWaybillId());
                model.addAttribute("staff", waybillService.getStaff());
                model.addAttribute("waybill", waybill1);
                return "waybill_edit";
            }
        }
        if (StringUtils.isEmpty(waybill.getWaybillEnd())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写到达站"));
            if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
                return "redirect:waybill_add";
            }else{
                Waybill waybill1 = waybillService.getWaybill(waybill.getWaybillId());
                model.addAttribute("staff", waybillService.getStaff());
                model.addAttribute("waybill", waybill1);
                return "waybill_edit";
            }
        }
        if (StringUtils.isEmpty(waybill.getWaybillRecive())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写收货客户"));
            if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
                return "redirect:waybill_add";
            }else{
                Waybill waybill1 = waybillService.getWaybill(waybill.getWaybillId());
                model.addAttribute("staff", waybillService.getStaff());
                model.addAttribute("waybill", waybill1);
                return "waybill_edit";
            }
        }
        if (StringUtils.isEmpty(waybill.getWaybillReciveAddress())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写收货客户电话"));
            if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
                return "redirect:waybill_add";
            }else{
                Waybill waybill1 = waybillService.getWaybill(waybill.getWaybillId());
                model.addAttribute("staff", waybillService.getStaff());
                model.addAttribute("waybill", waybill1);
                return "waybill_edit";
            }
        }
        if (StringUtils.isEmpty(waybill.getWaybillReciveAddress())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写收货客户地址"));
            if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
                return "redirect:waybill_add";
            }else{
                Waybill waybill1 = waybillService.getWaybill(waybill.getWaybillId());
                model.addAttribute("staff", waybillService.getStaff());
                model.addAttribute("waybill", waybill1);
                return "waybill_edit";
            }
        }
        if (StringUtils.isEmpty(waybill.getWaybillSend())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写发货客户"));
            if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
                return "redirect:waybill_add";
            }else{
                Waybill waybill1 = waybillService.getWaybill(waybill.getWaybillId());
                model.addAttribute("staff", waybillService.getStaff());
                model.addAttribute("waybill", waybill1);
                return "waybill_edit";
            }
        }
        if (StringUtils.isEmpty(waybill.getWaybillSendAddress())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写发货客户地址"));
            if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
                return "redirect:waybill_add";
            }else{
                Waybill waybill1 = waybillService.getWaybill(waybill.getWaybillId());
                model.addAttribute("staff", waybillService.getStaff());
                model.addAttribute("waybill", waybill1);
                return "waybill_edit";
            }
        }
        if (StringUtils.isEmpty(waybill.getWaybillSendPhone())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写发货客户电话"));
            if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
                return "redirect:waybill_add";
            }else{
                Waybill waybill1 = waybillService.getWaybill(waybill.getWaybillId());
                model.addAttribute("staff", waybillService.getStaff());
                model.addAttribute("waybill", waybill1);
                return "waybill_edit";
            }
        }
        if (StringUtils.isEmpty(waybill.getWaybillLoan())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写贷款"));
            if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
                return "redirect:waybill_add";
            }else{
                Waybill waybill1 = waybillService.getWaybill(waybill.getWaybillId());
                model.addAttribute("staff", waybillService.getStaff());
                model.addAttribute("waybill", waybill1);
                return "waybill_edit";
            }
        }
        if (StringUtils.isEmpty(waybill.getWaybillCommission())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写佣金率"));
            if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
                return "redirect:waybill_add";
            }else{
                Waybill waybill1 = waybillService.getWaybill(waybill.getWaybillId());
                model.addAttribute("staff", waybillService.getStaff());
                model.addAttribute("waybill", waybill1);
                return "waybill_edit";
            }
        }
        if ("请选择".equals(waybill.getWaybillSalesman())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请选择业务员"));
            if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
                return "redirect:waybill_add";
            }else{
                Waybill waybill1 = waybillService.getWaybill(waybill.getWaybillId());
                model.addAttribute("staff", waybillService.getStaff());
                model.addAttribute("waybill", waybill1);
                return "waybill_edit";
            }
        }
        if (StringUtils.isEmpty(waybill.getWaybillFreight())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写运费金额"));
            if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
                return "redirect:waybill_add";
            }else{
                Waybill waybill1 = waybillService.getWaybill(waybill.getWaybillId());
                model.addAttribute("staff", waybillService.getStaff());
                model.addAttribute("waybill", waybill1);
                return "waybill_edit";
            }
        }
        if (StringUtils.isEmpty(waybill.getWaybillInsurance())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写保险金额"));
            if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
                return "redirect:waybill_add";
            }else{
                Waybill waybill1 = waybillService.getWaybill(waybill.getWaybillId());
                model.addAttribute("staff", waybillService.getStaff());
                model.addAttribute("waybill", waybill1);
                return "waybill_edit";
            }
        }
        if (0 == waybill.getWaybillPayType()) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请选择付款方式"));
            if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
                return "redirect:waybill_add";
            }else{
                Waybill waybill1 = waybillService.getWaybill(waybill.getWaybillId());
                model.addAttribute("staff", waybillService.getStaff());
                model.addAttribute("waybill", waybill1);
                return "waybill_edit";
            }
        }
        if (0 == waybill.getWaybillReciveType()) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请选择取货方式"));
            if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
                return "redirect:waybill_add";
            }else{
                Waybill waybill1 = waybillService.getWaybill(waybill.getWaybillId());
                model.addAttribute("staff", waybillService.getStaff());
                model.addAttribute("waybill", waybill1);
                return "waybill_edit";
            }
        }
        if (StringUtils.isEmpty(waybill.getWaybillFill())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写填票人"));
            if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
                return "redirect:waybill_add";
            }else{
                Waybill waybill1 = waybillService.getWaybill(waybill.getWaybillId());
                model.addAttribute("staff", waybillService.getStaff());
                model.addAttribute("waybill", waybill1);
                return "waybill_edit";
            }
        }
        if (StringUtils.isEmpty(waybill.getWaybillFillDate())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写填票日期"));
            if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
                return "redirect:waybill_add";
            }else{
                Waybill waybill1 = waybillService.getWaybill(waybill.getWaybillId());
                model.addAttribute("staff", waybillService.getStaff());
                model.addAttribute("waybill", waybill1);
                return "waybill_edit";
            }
        } else {
            if (!this.isRqFormat(waybillFillDateS)) {
                redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("填票日期格式错误!范例:2019-02-14"));
                if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
                    return "redirect:waybill_add";
                }else{
                    Waybill waybill1 = waybillService.getWaybill(waybill.getWaybillId());
                    model.addAttribute("staff", waybillService.getStaff());
                    model.addAttribute("waybill", waybill1);
                    return "waybill_edit";
                }
            }
        }

        DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date waybillDateD = null;
        Date waybillFillDateD = null;
        try {
            waybillDateD = f.parse(waybillDateS);
            waybillFillDateD = f.parse(waybillFillDateS);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        waybill.setWaybillDate(waybillDateD);
        waybill.setWaybillFillDate(waybillFillDateD);
        System.out.println(waybill.getWaybillDate());
        System.out.println(waybill.getWaybillFillDate());
        waybill.setWaybillStatus(1);
        if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
            waybillService.insert(waybill);
        }else{
            waybillService.update(waybill);
        }
        request.setAttribute("waybillEditId", waybill.getWaybillId());
        if (waybillService.getWaybill(waybill.getWaybillId()) == null) {
            return "/waybill_edit";
        }else{
            return "redirect:waybill_select";
        }

    }

    @RequestMapping(value = "/waybill_select", method = RequestMethod.GET)
    public String waybill_select(Model model, HttpServletRequest request, @RequestParam(value = "pn",required = false,defaultValue = "1") Integer pn) {
        if (request.getAttribute("waybills") != null) {
            List<Waybill> waybills = (List<Waybill>) request.getAttribute("waybills");
            model.addAttribute("waybills", waybills);
        } else {
            List<Waybill> waybills = waybillService.getWaybills();
            model.addAttribute("waybills", waybills);
        }
        Integer pageNum=null;
        if (request.getParameter("pageNum")!=null){
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }
        PageHelper.startPage(pageNum==null?pn:pageNum,10);
        List<Waybill> waybills = waybillService.getWaybills();
        PageInfo pageInfo=new PageInfo(waybills,5);
        model.addAttribute("pageInfo",pageInfo);
        return "waybill_select";
    }
    @RequestMapping(value = "/waybill_search", method = RequestMethod.GET)
    public String waybill_search(@RequestParam(value = "timeRange", required = false) String timeRange,
                                 @RequestParam(value = "pn",required = false,defaultValue = "1") Integer pn,
                                 @RequestParam(value = "waybillId",required = false)String waybillId,
                                 @RequestParam(value = "waybillSend" ,required = false)String waybillSend,
                                 @RequestParam(value = "waybillBegin", required = false)String waybillBegin,
                                 @RequestParam(value = "waybillEnd" ,required=false) String waybillEnd,
                                 @RequestParam(value = "waybillStatus",required = false)String waybillStatus,
                                 @RequestParam(value = "waybillRecive",required = false)String waybillRecive,
                                 Model model,
                                 HttpServletRequest request) {
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
                return "redirect:waybill_add";
//            e.printStackTrace();
            }
        }
            Map<String, Object> map = new HashMap<>();
            map.put("waybillId", waybillId);
            map.put("waybillSend", waybillSend);
            map.put("waybillRecive", waybillRecive);
            map.put("waybillBegin", waybillBegin);
            map.put("waybillEnd", waybillEnd);
            map.put("waybillStatus",waybillStatus);
            map.put("timeRange1", timeRange1);
            map.put("timeRange2", timeRange2);
            List<Waybill> waybills = waybillService.waybillSearch(map);
            PageInfo pageInfo=new PageInfo(waybills,5);
            model.addAttribute("pageInfo",pageInfo);
        Integer pageNum=null;
        if (request.getParameter("pageNum")!=null){
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }
        PageHelper.startPage(pageNum==null?pn:pageNum,10);
        model.addAttribute("waybillId", waybillId);
        model.addAttribute("waybillSend", waybillSend);
        model.addAttribute("waybillRecive", waybillRecive);
        model.addAttribute("waybillBegin", waybillBegin);
        model.addAttribute("waybillEnd", waybillEnd);
        model.addAttribute("waybillStatus",waybillStatus);
        model.addAttribute("timeRange", timeRange);
        return "waybill_select";
    }

    @RequestMapping(value = "/waybill_delete", method = RequestMethod.POST)
    public String waybill_delete(Waybill waybill) {
        waybillService.deleteWaybill(waybill.getWaybillId());
        return "redirect:waybill_select";
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
