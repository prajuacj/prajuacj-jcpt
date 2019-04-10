package com.prajuacj.jcpt.modules.ef.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prajuacj.jcpt.common.mybatisplus.Query;
import com.prajuacj.jcpt.common.utils.PageUtils;
import com.prajuacj.jcpt.modules.ef.dao.CardServerDao;
import com.prajuacj.jcpt.modules.ef.entity.CardServerEntity;
import com.prajuacj.jcpt.modules.ef.service.ICardServerService;

@Service("cardServerService")
public class CardServerServiceImpl extends ServiceImpl<CardServerDao, CardServerEntity> implements ICardServerService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		IPage<CardServerEntity> page = this.page(new Query<CardServerEntity>().getPage(params),
				new QueryWrapper<CardServerEntity>());

		return new PageUtils(page);
	}

}
