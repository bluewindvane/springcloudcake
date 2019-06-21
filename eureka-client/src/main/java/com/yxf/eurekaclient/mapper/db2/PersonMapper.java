package com.yxf.eurekaclient.mapper.db2;

import com.yxf.eurekaclient.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yxf
 * @since 2019-06-21
 */
@Repository
@Mapper
public interface PersonMapper  {

    @Select(" select * from person ")
    List<Person> getAll();

}
