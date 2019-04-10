package com.prajuacj.jcpt.admin.ef.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prajuacj.jcpt.common.base.R;
import com.prajuacj.jcpt.common.utils.PageUtils;
import com.prajuacj.jcpt.common.validator.ValidatorUtils;
import com.prajuacj.jcpt.modules.ef.entity.CardInfoEntity;
import com.prajuacj.jcpt.modules.ef.service.ICardInfoService;



/**
 * 
 *
 * @author prajuacj
 * @email prajuacj@163.com
 * @date 2019-04-03 16:55:50
 */
@RestController
@RequestMapping("ef/cardinfo")
public class CardInfoController {
    @Autowired
    private ICardInfoService cardInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ef:cardinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cardInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("ef:cardinfo:info")
    public R info(@PathVariable("id") Integer id){
        CardInfoEntity cardInfo = cardInfoService.getById(id);

        return R.ok().put("cardInfo", cardInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ef:cardinfo:save")
    public R save(@RequestBody CardInfoEntity cardInfo){
        cardInfoService.save(cardInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ef:cardinfo:update")
    public R update(@RequestBody CardInfoEntity cardInfo){
        ValidatorUtils.validateEntity(cardInfo);
        cardInfoService.updateById(cardInfo);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ef:cardinfo:delete")
    public R delete(@RequestBody Integer[] ids){
        cardInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
