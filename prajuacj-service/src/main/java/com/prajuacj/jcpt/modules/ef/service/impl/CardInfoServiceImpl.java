package com.prajuacj.jcpt.modules.ef.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prajuacj.jcpt.common.mybatisplus.Query;
import com.prajuacj.jcpt.common.utils.PageUtils;
import com.prajuacj.jcpt.modules.ef.dao.CardInfoDao;
import com.prajuacj.jcpt.modules.ef.entity.CardInfoEntity;
import com.prajuacj.jcpt.modules.ef.service.ICardInfoService;

@Service("cardInfoService")
public class CardInfoServiceImpl extends ServiceImpl<CardInfoDao, CardInfoEntity> implements ICardInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		IPage<CardInfoEntity> page = this.page(new Query<CardInfoEntity>().getPage(params),
				new QueryWrapper<CardInfoEntity>());

		return new PageUtils(page);
	}

}
