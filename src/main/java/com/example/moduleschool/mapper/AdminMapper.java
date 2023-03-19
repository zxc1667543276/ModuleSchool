package com.example.moduleschool.mapper;

import com.example.moduleschool.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
* @author zxc
* @description 针对表【tb_admin】的数据库操作Mapper
* @createDate 2023-02-28 23:30:34
* @Entity com.example.moduleschool.pojo.school.Admin
*/
@Mapper
@Component
public interface AdminMapper extends BaseMapper<Admin> {

}




