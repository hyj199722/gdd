package com.mju.band3.web.Controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {
    private static final String COOKIE_NAME_USER_INFO="userInfo";
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request){
        String userInfo = CookieUtils.getCookieValue(request, COOKIE_NAME_USER_INFO);
        User user = (User) request.getSession().getAttribute("user");
        if (!StringUtils.isEmpty(userInfo)) {
            String[] split = userInfo.split(":");
            String email = split[0];
            String password = split[1];
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            request.setAttribute("isRemember", true);
        }
        if (!StringUtils.isEmpty(user)){
            return "redirect:main";
        }
        return "forward:login.jsp";
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true)String password, String isRemember, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Boolean isRe=(isRemember==null?false:true);
        if (!isRe){
            CookieUtils.deleteCookie(request,response,COOKIE_NAME_USER_INFO);
        }

        if (StringUtils.isEmpty(email)){
            request.setAttribute("message","邮箱不能为空");
//                request.getRequestDispatcher("/login.jsp").forward(request,response);
            return "forward:login.jsp";
        }
        if (StringUtils.isEmpty(password)){
            request.setAttribute("message","密码不能为空");
//                request.getRequestDispatcher("/login.jsp").forward(request,response);
            return "forward:login.jsp";
        }

        User user = userService.login(email, password);
        System.out.println(user);
        if (user==null){
            request.setAttribute("message","用户名或者密码错误");
//                request.getRequestDispatcher("/login.jsp").forward(request,response);
            return "forward:login.jsp";
        }
        if (user!=null){
            if (isRe) {
                CookieUtils.
                        setCookie
                                (request,response,COOKIE_NAME_USER_INFO,String.format("%s:%s",email,password),7*24*60*60);
            }
            }

        request.getSession().setAttribute("user",user);

     return "redirect:main";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:login";


    }
    @RequestMapping(value = "/user_list",method = RequestMethod.GET)
    public String user_LIST(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,Model model){
        PageHelper.startPage(pn,5);
        List<User> users = userService.selectAll();
        PageInfo pageInfo=new PageInfo(users,5);
        model.addAttribute("pageInfo",pageInfo);
        return "user_list";

    }




    @RequestMapping(value = "/user_from",method = RequestMethod.GET)
    public String user_From(){

        return "user_from";

    }

    @RequestMapping(value = "/user_save",method = RequestMethod.POST)
    public String user_Save(User user, RedirectAttributes redirectAttributes,Model model){
        BaseResult baseResult = userService.save(user);
        if (baseResult.getStatus()==baseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:user_list";
        }else{
            model.addAttribute("baseResult",baseResult);
            model.addAttribute("ReUser",user);
            return "user_from";
        }


    }
    @RequestMapping(value = "/user_search",method = RequestMethod.POST)
    public String search(Model model,String username){
        PageHelper.startPage(1,5);
        List<User> users = userService.search(username);
        PageInfo pageInfo=new PageInfo(users,5);
        model.addAttribute("pageInfo",pageInfo);
        return "user_list";

    }

    @RequestMapping(value = "/to_edit",method = RequestMethod.GET)
    public String to_edit(Model model,Integer id){
                    User byId = userService.findById(id);
                    model.addAttribute("editUser",byId);
                    return "user_edit";

    }


    @RequestMapping(value = "/user_edit",method = RequestMethod.POST)
    public String user_edit(User user,RedirectAttributes redirectAttributes,Model model){
        BaseResult baseResult = userService.save(user);
        if (baseResult.getStatus()==baseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:user_list";
        }else{
            model.addAttribute("baseResult",baseResult);
            model.addAttribute("ReUser",user);
            return "user_from";
        }


    }

//    @ResponseBody
//    @RequestMapping(value = "/user_delete",method = RequestMethod.POST)
//    public BaseResult user_delete(String ids){
//        Integer id=Integer.parseInt(ids);
//        userService.deleteById(id);
//        return BaseResult.success("删除成功");
//    }


    @ResponseBody
    @RequestMapping(value = "/users_delete",method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        if (!StringUtils.isEmpty(ids)) {
            String[] split = ids.split(",");
            userService.deleteUsers(split);
            baseResult = BaseResult.success("删除成功");
            return baseResult;
        } else {
            baseResult = BaseResult.fail("删除失败");
            return baseResult;
        }
    }


}
