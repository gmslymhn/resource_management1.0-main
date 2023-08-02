package com.lc.demo.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.Goods;
import com.lc.demo.bean.MyError;
import com.lc.demo.service.GoodsService;
import com.lc.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gmslymhn
 * @date 2023-08-02 11:52
 * @description:测试
 */
@Controller
public class Admin {

    @Autowired
    private UserService userService;

    @Autowired
    private GoodsService goodsService;

//物品首页
    @GetMapping(value = "/adm/toallgoods/{pn}")
    public String tostudmin(@PathVariable("pn") Integer pn, Model model)
    {
        PageHelper.startPage(pn, 6);
        List<Goods> goods=goodsService.getAllGoods();
        PageInfo<Goods> page = new PageInfo<Goods>(goods, 5);
        model.addAttribute("classes",goods);
        model.addAttribute("pageInfo",page);
        return "forward:/goodsadmin.html";
    }
//物品添加
    @GetMapping(value = "/adm/goodsadd")
    public String goodstoaddpage(Model model)
    {
        return "adm/addgoods";
    }
    @PostMapping(value = "/adm/goodsAdd")
    public String goodsAdd(@Valid Goods goods, BindingResult bindingResult, Model model)
    {
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        List<MyError> errmsg = new ArrayList<>();
        if(allErrors.size()==0)
        {
                goodsService.addGoods(goods);
                return "redirect:/adm/toallgoods/1";
        }
        else {
            for (ObjectError error:allErrors)
            {
                errmsg.add(new MyError(error.getDefaultMessage()));
            }
            model.addAttribute("errors",errmsg);
            model.addAttribute("goods",goods);
            return "adm/addgoods";
        }
    }

    //删除物品
    @DeleteMapping(value = "/adm/goods/{goodsId}")
    public String delestu(@PathVariable("goodsId") String goodsId)
    {
        goodsService.deleteGoods(Integer.parseInt(goodsId));
        return "redirect:/adm/toallgoods/1";
    }
    //返回物品修改页面
    @GetMapping(value = "/adm/goods/{goodsId}")
    public String updateStuPage(@PathVariable("goodsId") String goodsId,Model model)
    {
        Goods goods=goodsService.selectGoodsById(Integer.parseInt(goodsId));
        model.addAttribute("goods",goods);
        return "adm/updategoods";
    }

    //更新物品信息
    @PutMapping(value = "/adm/goods")
    public String updateStu(@Valid Goods goods,BindingResult bindingResult,Model model)
    {


        List<ObjectError> allErrors = bindingResult.getAllErrors();
        List<MyError> errmsg = new ArrayList<>();
        if(allErrors.size()==0)
        {
            System.out.println(goods);
            goodsService.deleteGoods(goods.getGoodsId());
            goodsService.addGoods(goods);
            return "redirect:/adm/toallgoods/1";
        }
        else
        {
            for (ObjectError error:allErrors)
            {
                errmsg.add(new MyError(error.getDefaultMessage()));
            }
            model.addAttribute("errors",errmsg);
            model.addAttribute("goods",goods);
            return "adm/updatestu";
        }
    }
    @GetMapping(value = "/adm/selectById")
    public String selectById(@Param("goodsId") String goodsId, Model model)
    {
        Goods goods = goodsService.selectGoodsById(Integer.parseInt(goodsId));
        model.addAttribute("goods",goods);
        return "adm/goodsbyid";
    }

    //根据名称查询物品
    @GetMapping(value = "/adm/selectByName/{pn}")
    public String selectStuByClass(@PathVariable("pn") Integer pn,@Param("goodsName") String goodsName,Model model)
    {
        PageHelper.startPage(pn, 6);
        List<Goods> goods = goodsService.selectGoodsByGoodsName(goodsName);
        PageInfo<Goods> page = new PageInfo<Goods>(goods, 5);
        model.addAttribute("pageInfo",page);
        model.addAttribute("goodsName",goodsName);
        return "adm/goodsbyname";
    }

}
