package com.mju.band3.web.Controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mju.band3.entity.Item;
import com.mju.band3.entity.User;
import com.mju.band3.entity.Waybill;
import com.mju.band3.service.ContractService;
import com.mju.band3.service.ItemService;
import com.mju.band3.service.UserService;
import com.mju.band3.service.WaybillService;
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
import java.util.*;

@Controller
public class ItemController {
    private static final String COOKIE_NAME_USER_INFO = "userInfo";
    @Autowired
    private ItemService itemService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private WaybillService waybillService;

    //货物单

    @RequestMapping(value = "/item_add", method = RequestMethod.GET)
    public String item_add(Model model, @RequestParam(value = "waybillId") String waybillId,
                           @RequestParam(value = "pn", required = false, defaultValue = "1") Integer pn,
                           HttpServletRequest request) {
        Integer pageNum = null;
        if (request.getParameter("pageNum") != null) {
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }
        PageHelper.startPage(pageNum == null ? pn : pageNum, 10);
        List<Item> items = itemService.getItemByWaybillId(waybillId);
        PageInfo pageInfo = new PageInfo(items, 5);
        model.addAttribute("pageInfo", pageInfo);

        model.addAttribute("waybillId", waybillId);
        model.addAttribute("status",waybillService.getWaybill(waybillId).getWaybillStatus());
        return "item_add";

    }

    @RequestMapping(value = "/item_add_done", method = RequestMethod.GET)
    public String item_add_done(Model model, String waybillId) {
        List<Item> items = itemService.getItemByWaybillId(waybillId);
        model.addAttribute("waybillId", waybillId);
        model.addAttribute("items", items);
        return "item_add";

    }

    @RequestMapping(value = "/item_edit", method = RequestMethod.GET)
    public String item_edit(@RequestParam(value = "itemId") Integer itemId, @RequestParam(value = "waybillId") String waybillId, Model model,
                            @RequestParam(value = "pn", required = false, defaultValue = "1") Integer pn,
                            HttpServletRequest request) {
        Item item = itemService.getItem(itemId, waybillId);
        Integer pageNum = null;
        if (request.getParameter("pageNum") != null) {
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }
        PageHelper.startPage(pageNum == null ? pn : pageNum, 10);
        List<Item> items = itemService.getItemByWaybillId(waybillId);
        PageInfo pageInfo = new PageInfo(items, 5);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("items", items);
        model.addAttribute("item", item);
        return "item_edit";

    }

    @RequestMapping(value = "/item_save", method = RequestMethod.POST)
    public String item_save(Item item, RedirectAttributes redirectAttributes, Model model) {
        System.out.println("itemsave" + item.getWaybillId());
        redirectAttributes.addFlashAttribute("waybillId", item.getWaybillId());
        model.addAttribute("waybillId", item.getWaybillId());
        PageHelper.startPage(1, 10);
        List<Item> items = itemService.getItemByWaybillId(item.getWaybillId());
        PageInfo pageInfo = new PageInfo(items, 5);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("waybillId", item.getWaybillId());
        model.addAttribute("items", items);
        if (StringUtils.isEmpty(item.getWaybillId())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写货运单编号"));
            return "item_add";
        }
        if (StringUtils.isEmpty(item.getItemName())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写货运货物名称"));
            return "item_add";
        }
        if (StringUtils.isEmpty(item.getItemId())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写货物编号"));
            return "item_add";
        } else {
            if (itemService.getItem(item.getItemId(), item.getWaybillId()) != null) {
                redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("货物编号已存在"));
                return "item_add";
            }
        }
        if (StringUtils.isEmpty(item.getItemNum())) {
            redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("请填写货物件数量"));
            return "item_add";
        }
        itemService.insertItem(item);
        return "item_add";

    }

    @RequestMapping(value = "/item_select", method = RequestMethod.GET)
    public String item_select(Model model, @RequestParam(value = "pn", required = false, defaultValue = "1") Integer pn) {

        return "item_select";

    }

    @RequestMapping(value = "/item_alter", method = RequestMethod.POST)
    public String item_alter(Item item, Model model, RedirectAttributes redirectAttributes) {
        itemService.updateItem(item);
        PageHelper.startPage(1, 10);
        List<Item> items = itemService.getItemByWaybillId(item.getWaybillId());
        PageInfo pageInfo = new PageInfo(items, 5);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("waybillId", item.getWaybillId());
        return "item_add";

    }

    @RequestMapping(value = "/itembill_select", method = RequestMethod.GET)
    public String itembill_select(Model model) {

        return "itembill_select";

    }

    @RequestMapping(value = "/itemdrive_select", method = RequestMethod.GET)
    public String itemdrive_select(Model model, @RequestParam(value = "pn", required = false, defaultValue = "1") Integer pn,
                                   HttpServletRequest request,
                                   @RequestParam(value = "contractId") String contractId,
                                   @RequestParam(value = "waybillBegin", required = false) String waybillBegin,
                                   @RequestParam(value = "waybillEnd", required = false) String waybillEnd,
                                   @RequestParam(value = "checkbox", required = false) String checkbox,
                                   @RequestParam(value = "unload", required = false) String unload) {
        int j = 0;
        if (!StringUtils.isEmpty(checkbox)) {
            String[] split = checkbox.split(",");
            for (String s : split) {
                contractService.upload(s, contractId);
            }
            for (String s : split) {
                String[] split2 = s.split(";");
                String waybillId = split2[1];
                contractService.uploadStatus(waybillId);
            }
            contractService.changeStatus(contractId, 2);
        }
        if (!StringUtils.isEmpty(unload)) {
            String[] split = unload.split(",");
            for (String s : split) {
                contractService.unload(s);
            }
            contractService.changeStatus(contractId, 3);
        }
        model.addAttribute("contractId", contractId);
        model.addAttribute("waybillBegin", waybillBegin);
        model.addAttribute("waybillEnd", waybillEnd);
        List<Item> contractItems = itemService.selectByContractId(contractId);
        model.addAttribute("items", contractItems);
        Integer pageNum = null;
        if (request.getParameter("pageNum") != null) {
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }
        PageHelper.startPage(pageNum == null ? pn : pageNum, 10);
        Map<String, String> map = new HashMap<>();
        map.put("begin", waybillBegin);
        map.put("end", waybillEnd);
        List<Item> items = itemService.selectByLocation(map);
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                String a = o1.getWaybillId().substring(1);
                String b = o2.getWaybillId().substring(1);
                Long i = Long.valueOf(a);
                Long j = Long.valueOf(b);
                if (i > j) {
                    return 1;
                } else {
                    if (i == j) {
                        if (o1.getItemId() > o2.getItemId()) {
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                    return -1;
                }

            }
        });
        PageInfo pageInfo = new PageInfo(items, 5);
        model.addAttribute("pageInfo", pageInfo);
        return "itemdrive_select";

    }

    @RequestMapping(value = "/itemdriver_selectd", method = RequestMethod.GET)
    public String itemdriver_selectd(Model model) {

        return "itemdriver_selectd";

    }

    @RequestMapping(value = "/item_delete", method = RequestMethod.POST)
    public String item_delete(Model model, Item item) {
        System.out.println("测试！" + item.getItemId() + item.getWaybillId());
        itemService.deleteItemWaybill(item.getWaybillId(), item.getItemId());
        List<Item> items = itemService.getItemByWaybillId(item.getWaybillId());
        model.addAttribute("waybillId", item.getWaybillId());
        model.addAttribute("items", items);
        return "item_add";
    }

    @RequestMapping(value = "/item_delete_all", method = RequestMethod.POST)
    public String item_delete_all(Model model, Item item) {
        System.out.println("item_delete_all" + item.getWaybillId());
        itemService.deleteByWaybillId(item.getWaybillId());
        List<Item> items = itemService.getItemByWaybillId(item.getWaybillId());
        model.addAttribute("waybillId", item.getWaybillId());
        model.addAttribute("items", items);
        return "item_add";
    }
}
