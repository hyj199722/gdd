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
public class ContractController {
    private static final String COOKIE_NAME_USER_INFO="userInfo";
    @Autowired
    private UserService userService;



    //运输合同
    @RequestMapping(value = "/contract_add",method = RequestMethod.GET)
    public String contract_add(){

        return "contract_add";

    }
    @RequestMapping(value = "/contract_edit",method = RequestMethod.GET)
    public String contract_edit(){

        return "contract_edit";

    }
    @RequestMapping(value = "/contract_save",method = RequestMethod.GET)
    public String contract_save(User user, RedirectAttributes redirectAttributes,Model model){
        BaseResult baseResult = userService.save(user);
        if (baseResult.getStatus()==baseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:contract_select";
        }else{
            model.addAttribute("baseResult",baseResult);
            return "contract_add";
        }

    }
    @RequestMapping(value = "/contract_select",method = RequestMethod.GET)
    public String contract_select(Model model){
        List<User> users = userService.selectAll();
        model.addAttribute("users",users);
        return "contract_select";

    }


}
