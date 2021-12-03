package com.tangv.cloud.dao;

import com.tangv.cloud.model.TUser;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * author:   tangwei
 * Date:     2021/12/3 20:45
 * Description:
 */
@Mapper
public interface TUserMapper extends BaseMapper<TUser> {
}