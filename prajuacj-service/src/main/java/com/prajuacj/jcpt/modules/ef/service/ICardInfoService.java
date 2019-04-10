package com.prajuacj.jcpt.modules.ef.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.prajuacj.jcpt.common.utils.PageUtils;
import com.prajuacj.jcpt.modules.ef.entity.CardInfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author prajuacj
 * @email prajuacj@163.com
 * @date 2019-04-03 16:55:50
 */
public interface ICardInfoService extends IService<CardInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

