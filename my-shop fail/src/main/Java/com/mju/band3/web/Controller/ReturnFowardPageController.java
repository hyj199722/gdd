package com.mju.band3.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ReturnFowardPageController {

    @RequestMapping(value = "/returnBe")
    public void ReturnFor(RedirectAttributes redirectAttributes, Model model){

    }
}
