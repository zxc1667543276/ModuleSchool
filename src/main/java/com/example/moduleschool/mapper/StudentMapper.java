package com.example.moduleschool.mapper;

import com.example.moduleschool.pojo.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author zxc
* @description 针对表【tb_student】的数据库操作Mapper
* @createDate 2023-02-28 23:34:16
* @Entity com.example.moduleschool.pojo.Student
*/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}




