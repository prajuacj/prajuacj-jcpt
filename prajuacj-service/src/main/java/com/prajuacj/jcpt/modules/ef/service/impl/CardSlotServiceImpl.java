package com.prajuacj.jcpt.modules.ef.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prajuacj.jcpt.common.mybatisplus.Query;
import com.prajuacj.jcpt.common.utils.PageUtils;
import com.prajuacj.jcpt.modules.ef.dao.CardSlotDao;
import com.prajuacj.jcpt.modules.ef.entity.CardSlotEntity;
import com.prajuacj.jcpt.modules.ef.service.ICardSlotService;

@Service("cardSlotService")
public class CardSlotServiceImpl extends ServiceImpl<CardSlotDao, CardSlotEntity> implements ICardSlotService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		IPage<CardSlotEntity> page = this.page(new Query<CardSlotEntity>().getPage(params),
				new QueryWrapper<CardSlotEntity>());

		return new PageUtils(page);
	}

}
