package com.yxf.eurekaclient.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yxf.eurekaclient.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    @Select(" SELECT id,name,remark,age,sex from user ORDER BY id LIMIT #{min},#{max} ")
    List<User> getUserListWithPage(@Param("min") Integer min, @Param("max") Integer max);

}
