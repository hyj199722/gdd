package com.mju.band3.web.Controller;


import com.mju.band3.entity.Item;
import com.mju.band3.entity.User;
import com.mju.band3.service.ItemService;
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
    private ItemService itemService;


    //货物单

    @RequestMapping(value = "/item_add",method = RequestMethod.GET)
    public String item_add(Model model,@RequestParam String waybillId){
        List<Item> items = itemService.getItemByWaybillId(waybillId);
        model.addAttribute("waybillId",waybillId);
        model.addAttribute("items",items);
        return "item_add";

    }
    @RequestMapping(value = "/item_edit",method = RequestMethod.GET)
    public String item_edit(@RequestParam Integer itemId,Model model){
        Item item=itemService.getItem(itemId);
        List<Item> items = itemService.getItems();
        model.addAttribute("items",items);
        model.addAttribute("item",item);
        return "item_edit";

    }
    @RequestMapping(value = "/item_save",method = RequestMethod.POST)
    public String item_save(Item item,RedirectAttributes redirectAttributes){
        if (StringUtils.isEmpty(item.getWaybillId())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写货运单编号"));
            return "redirect:item_add";
        }
        if (StringUtils.isEmpty(item.getItemName())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写货运货物名称"));
            return "redirect:item_add";
        }
        if (StringUtils.isEmpty(item.getItemId())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写货物编号"));
            return "redirect:item_add";
        }
        if (StringUtils.isEmpty(item.getItemNum())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写货物件数量"));
            return "redirect:item_add";
        }
        itemService.insertItem(item);
        return "redirect:item_add";

    }
    @RequestMapping(value = "/item_select",method = RequestMethod.GET)
    public String item_select(Model model){

        return "item_select";

    }
    @RequestMapping(value = "/item_alter",method = RequestMethod.POST)
    public String item_alter(Item item,Model model){
        itemService.updateItem(item);
        model.addAttribute("waybillId",item.getWaybillId());
        return "redirect:item_add";

    }
    @RequestMapping(value = "/itembill_select",method = RequestMethod.GET)
    public String itembill_select(Model model){

        return "itembill_select";

    }
    @RequestMapping(value = "/itemdrive_select",method = RequestMethod.GET)
    public String itemdrive_select(Model model){

        return "itemdrive_select";

    }
    @RequestMapping(value = "/itemdriver_selectd",method = RequestMethod.GET)
    public String itemdriver_selectd(Model model){

        return "itemdriver_selectd";

    }
}
