package com.tangv.cloud.mapper;

import com.tangv.cloud.model.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * author:   tangwei
 * Date:     2021/7/18 17:23
 * Description:
 */
@Mapper
public interface OrderMapper extends tk.mybatis.mapper.common.Mapper<Orders> {
}