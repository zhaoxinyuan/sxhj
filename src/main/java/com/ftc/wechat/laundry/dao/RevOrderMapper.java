package com.ftc.wechat.laundry.dao;

import com.ftc.wechat.laundry.bean.RevOrder;

public interface RevOrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(RevOrder record);

    int insertSelective(RevOrder record);

    RevOrder selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(RevOrder record);

    int updateByPrimaryKey(RevOrder record);
}