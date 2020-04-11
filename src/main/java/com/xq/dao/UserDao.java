package com.xq.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Mechrevo
 * @version v1.0
 * 2020/3/13 21:33
 */
@Mapper
public interface UserDao {

    @Select("select * from sys_user where id= #{id}")
    public Map getUser(Serializable id);

}
