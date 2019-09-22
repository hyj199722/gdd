package com.mju.band3.web.Controller;


import com.mju.band3.entity.User;
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
public class ReceiptController {
    private static final String COOKIE_NAME_USER_INFO="userInfo";
    @Autowired
    private UserService userService;


    //司机回执
    @RequestMapping(value = "/driver_receipt_add",method = RequestMethod.GET)
    public String driver_receipt_add(){

        return "driver_receipt_add";

    }
    @RequestMapping(value = "/driver_receipt_edit",method = RequestMethod.GET)
    public String driver_receipt_edit(){

        return "driver_receipt_edit";

    }
    @RequestMapping(value = "/driver_receipt_save",method = RequestMethod.GET)
    public String driver_receipt_save(User user, RedirectAttributes redirectAttributes,Model model){
        BaseResult baseResult = userService.save(user);
        if (baseResult.getStatus()==baseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:driver_receipt_select";
        }else{
            model.addAttribute("baseResult",baseResult);
            return "driver_receipt_save";
        }

    }
    @RequestMapping(value = "/driver_receipt_select",method = RequestMethod.GET)
    public String driver_receipt_select(Model model){
        List<User> users = userService.selectAll();
        model.addAttribute("users",users);
        return "driver_receipt_select";

    }
    //顾客回执
    @RequestMapping(value = "/customer_receipt_add",method = RequestMethod.GET)
    public String customer_receipt_add(){

        return "customer_receipt_add";

    }
    @RequestMapping(value = "/customer_receipt_edit",method = RequestMethod.GET)
    public String customer_receipt_edit(){

        return "customer_receipt_edit";

    }
    @RequestMapping(value = "/customer_receipt_save",method = RequestMethod.GET)
    public String customer_receipt_save(User user, RedirectAttributes redirectAttributes,Model model){
        BaseResult baseResult = userService.save(user);
        if (baseResult.getStatus()==baseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:customer_receipt_select";
        }else{
            model.addAttribute("baseResult",baseResult);
            return "customer_receipt_add";
        }

    }
    @RequestMapping(value = "/customer_receipt_select",method = RequestMethod.GET)
    public String customer_receipt_select(Model model){
        List<User> users = userService.selectAll();
        model.addAttribute("users",users);
        return "customer_receipt_select";

    }


}
