package com.example.moduleschool.mapper;

import com.example.moduleschool.pojo.Grade;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author zxc
* @description 针对表【tb_grade】的数据库操作Mapper
* @createDate 2023-02-28 23:34:11
* @Entity com.example.moduleschool.pojo.Grade
*/
@Mapper
public interface GradeMapper extends BaseMapper<Grade> {

}




