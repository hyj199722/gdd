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
public class ItemController {
    private static final String COOKIE_NAME_USER_INFO="userInfo";
    @Autowired
    private UserService userService;


    //货物单

    @RequestMapping(value = "/item_add",method = RequestMethod.GET)
    public String item_add(Model model){
        List<User> users = userService.selectAll();
        model.addAttribute("users",users);
        return "item_add";

    }
    @RequestMapping(value = "/item_edit",method = RequestMethod.GET)
    public String item_edit(Model model){
        List<User> users = userService.selectAll();
        model.addAttribute("users",users);
        return "item_edit";

    }
    @RequestMapping(value = "/item_save",method = RequestMethod.GET)
    public String item_save(User user, RedirectAttributes redirectAttributes,Model model){
        BaseResult baseResult = userService.save(user);
        if (baseResult.getStatus()==baseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:item_select";
        }else{
            model.addAttribute("baseResult",baseResult);
            return "item_add";
        }

    }
    @RequestMapping(value = "/item_select",method = RequestMethod.GET)
    public String item_select(Model model){
        List<User> users = userService.selectAll();
        model.addAttribute("users",users);
        return "item_select";

    }
    @RequestMapping(value = "/itembill_select",method = RequestMethod.GET)
    public String itembill_select(Model model){
        List<User> users = userService.selectAll();
        model.addAttribute("users",users);
        return "itembill_select";

    }
    @RequestMapping(value = "/itemdrive_select",method = RequestMethod.GET)
    public String itemdrive_select(Model model){
        List<User> users = userService.selectAll();
        model.addAttribute("users",users);
        return "itemdrive_select";

    }
    @RequestMapping(value = "/itemdriver_selectd",method = RequestMethod.GET)
    public String itemdriver_selectd(Model model){
        List<User> users = userService.selectAll();
        model.addAttribute("users",users);
        return "itemdriver_selectd";

    }
}
