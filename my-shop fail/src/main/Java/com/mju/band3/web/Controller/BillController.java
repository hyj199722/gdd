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
public class BillController {
    private static final String COOKIE_NAME_USER_INFO="userInfo";
    @Autowired
    private UserService userService;


    //票据
    @RequestMapping(value = "/bill_add",method = RequestMethod.GET)
    public String bill_add(){

        return "bill_add";

    }

    @RequestMapping(value = "/bill_edit",method = RequestMethod.GET)
    public String bill_edit(){

        return "/bill_edit";

    }
    @RequestMapping(value = "/bill_save",method = RequestMethod.GET)
    public String bill_save(User user, RedirectAttributes redirectAttributes,Model model){
        BaseResult baseResult = userService.save(user);
        if (baseResult.getStatus()==baseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:bill_select";
        }else{
            model.addAttribute("baseResult",baseResult);
            return "bill_add";
        }

    }
    @RequestMapping(value = "/bill_select",method = RequestMethod.GET)
    public String bill_select(Model model){
        List<User> users = userService.selectAll();
        model.addAttribute("users",users);
        return "bill_select";

    }
    @RequestMapping(value = "/bill_state",method = RequestMethod.GET)
    public String bill_state(Model model){
        List<User> users = userService.selectAll();
        model.addAttribute("users",users);
        return "bill_state";

    }
    @RequestMapping(value = "/bill_destroy",method = RequestMethod.GET)
    public String bill_destroy(Model model){

        return "bill_destroy";

    }


}
