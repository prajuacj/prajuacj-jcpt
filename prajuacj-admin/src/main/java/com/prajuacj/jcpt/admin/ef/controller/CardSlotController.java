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
import com.prajuacj.jcpt.modules.ef.entity.CardSlotEntity;
import com.prajuacj.jcpt.modules.ef.service.ICardSlotService;

/**
 * 
 *
 * @author prajuacj
 * @email prajuacj@163.com
 * @date 2019-04-03 16:55:50
 */
@RestController
@RequestMapping("ef/cardslot")
public class CardSlotController {
	@Autowired
	private ICardSlotService cardSlotService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("ef:cardslot:list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = cardSlotService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("ef:cardslot:info")
	public R info(@PathVariable("id") Integer id) {
		CardSlotEntity cardSlot = cardSlotService.getById(id);

		return R.ok().put("cardSlot", cardSlot);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("ef:cardslot:save")
	public R save(@RequestBody CardSlotEntity cardSlot) {
		cardSlotService.save(cardSlot);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("ef:cardslot:update")
	public R update(@RequestBody CardSlotEntity cardSlot) {
		ValidatorUtils.validateEntity(cardSlot);
		cardSlotService.updateById(cardSlot);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("ef:cardslot:delete")
	public R delete(@RequestBody Integer[] ids) {
		cardSlotService.removeByIds(Arrays.asList(ids));

		return R.ok();
	}

}
