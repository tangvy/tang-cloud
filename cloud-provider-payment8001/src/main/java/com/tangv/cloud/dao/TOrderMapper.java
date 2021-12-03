package com.tangv.cloud.dao;

import com.tangv.cloud.model.TOrder;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * author:   tangwei
 * Date:     2021/12/2 23:36
 * Description:
 */
@Mapper
public interface TOrderMapper extends BaseMapper<TOrder> {
}