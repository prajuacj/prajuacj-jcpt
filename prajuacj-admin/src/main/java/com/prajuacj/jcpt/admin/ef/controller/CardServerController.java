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
import com.prajuacj.jcpt.modules.ef.entity.CardServerEntity;
import com.prajuacj.jcpt.modules.ef.service.ICardServerService;

/**
 * 
 *
 * @author prajuacj
 * @email prajuacj@163.com
 * @date 2019-04-03 16:55:49
 */
@RestController
@RequestMapping("ef/cardserver")
public class CardServerController {
	@Autowired
	private ICardServerService cardServerService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("ef:cardserver:list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = cardServerService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("ef:cardserver:info")
	public R info(@PathVariable("id") Integer id) {
		CardServerEntity cardServer = cardServerService.getById(id);

		return R.ok().put("cardServer", cardServer);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("ef:cardserver:save")
	public R save(@RequestBody CardServerEntity cardServer) {
		cardServerService.save(cardServer);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("ef:cardserver:update")
	public R update(@RequestBody CardServerEntity cardServer) {
		ValidatorUtils.validateEntity(cardServer);
		cardServerService.updateById(cardServer);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("ef:cardserver:delete")
	public R delete(@RequestBody Integer[] ids) {
		cardServerService.removeByIds(Arrays.asList(ids));

		return R.ok();
	}

}
