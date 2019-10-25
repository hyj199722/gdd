package com.mju.band3.web.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mju.band3.entity.Complaint;
import com.mju.band3.entity.Driver_Receipt;
import com.mju.band3.entity.User;
import com.mju.band3.service.ComplaintService;
import com.mju.band3.service.UserService;
import com.mju.band3.utils.BaseResult;
import com.mju.band3.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ComplaintController {
    private static final String COOKIE_NAME_USER_INFO="userInfo";
    @Autowired
    private UserService userService;
    @Autowired
    private ComplaintService complaintService;


    //投诉增加
    @RequestMapping(value = "/complaint_add",method = RequestMethod.GET)
    public String complaint_add(){

        return "complaint_add";

    }
    @RequestMapping(value = "/complaint_save")
    public String complaint_save(Complaint complaint, RedirectAttributes redirectAttributes,Model model){
        String regex = "(c){1}[2][0-9]{3}[0-9]{8}";
        redirectAttributes.addFlashAttribute("complaint",complaint);
        if (!complaint.getWaybillId().matches(regex)){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("格式不正确，请以c+时间+分发量为格式标准"));
            return "redirect:complaint_add";
        }
        if (StringUtils.isEmpty(complaint.getWaybillId())){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("请输入运输合同编号"));
            return "redirect:complaint_add";
        }

        if (StringUtils.isEmpty(complaint.getComplaintPerson())){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("请输入投诉人名称"));
            return "redirect:complaint_add";
        }
        if (StringUtils.isEmpty(complaint.getComplaintDetail())){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("请输入投诉详情"));
            return "redirect:complaint_add";
        }
        String exitWaybillId=complaintService.selectWaybillIdId(complaint.getWaybillId());
        System.out.println(exitWaybillId);
        if (exitWaybillId!=null){
            redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("该货运单已被投诉"));
            return "redirect:complaint_add";
        }
        //String exitWaybillIdNull=complaintService.selectWaybillIdIdNull(complaint.getWaybillId());
        //System.out.println(exitWaybillIdNull);
        //if (exitWaybillIdNull==null){
        //    redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("该货运单不存在"));
        //    return "redirect:complaint_add";
        //}
        complaintService.insert(complaint);
        model.addAttribute("baseResult",BaseResult.success("添加投诉成功"));
        return "forward:complaint_manager?pageNum="+Integer.MAX_VALUE;

    }
    //投诉修改
    @RequestMapping(value = "/to_complaint_edit")
    public String to_complaint_edit(@RequestParam(value = "complaintId")Integer complaintId,Model model){
        Complaint complaint=complaintService.selectByPrimaryKey(complaintId);

        model.addAttribute("complaint",complaint);
        return "complaint_edit";
    }
    @RequestMapping(value = "/complaint_edit")
    public String complaint_edit(Complaint complaint,Model model){

        complaintService.updateComplaintEdit(complaint);
        model.addAttribute("baseResult",BaseResult.success("修改成功"));
        return "forward:complaint_manager";

    }

    //投诉历史
    @RequestMapping(value = "/complaint_select")
    public String complaint_select(@RequestParam(value = "pn",required = false,defaultValue = "1") Integer pn,Model model,HttpServletRequest request){

        Integer pageNum=null;
        if (request.getParameter("pageNum")!=null){
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }
        PageHelper.startPage(pageNum==null?pn:pageNum,10);
        List<Complaint> receipts = complaintService.selectAll();
        PageInfo pageInfo=new PageInfo(receipts,5);
        model.addAttribute("pageInfo",pageInfo);
        return "complaint_select";
    }
    //投诉查询
    @RequestMapping(value = "/complaint_select_search")
    public String complaint_select_search(@RequestParam(value = "waybillId",required = false)String waybillId
            ,@RequestParam(value = "complaintPerson",required = false)String complaintPerson,
                                        @RequestParam(value = "pn",required = false,defaultValue = "1") Integer pn,
                                        Model model){

        Complaint complaint=new Complaint();
        complaint.setWaybillId(waybillId);
        complaint.setComplaintPerson(complaintPerson);
        PageHelper.startPage(pn,10);
        List<Complaint> complaints = complaintService.complaintSearch(complaint);
        PageInfo pageInfo=new PageInfo(complaints,5);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("waybillId",waybillId);
        model.addAttribute("complaintPerson",complaintPerson);

        return "complaint_select_search";

    }
    //投诉处理
    @RequestMapping(value = "/complaint_manager")
    public String complaint_manager(@RequestParam(value = "pn",required = false,defaultValue = "1") Integer pn,Model model,HttpServletRequest request){

        Integer pageNum=null;
        if (request.getParameter("pageNum")!=null){
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }

        PageHelper.startPage(pageNum==null?pn:pageNum,10);
        List<Complaint> receipts = complaintService.selectAllNull();
        PageInfo pageInfo=new PageInfo(receipts,5);
        model.addAttribute("pageInfo",pageInfo);
        return "complaint_manager";
    }


}
