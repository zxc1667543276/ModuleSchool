
package com.example.moduleschool.mapper;

import com.example.moduleschool.pojo.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author zxc
* @description 针对表【tb_teacher】的数据库操作Mapper
* @createDate 2023-02-28 23:34:21
* @Entity com.example.moduleschool.pojo.Teacher
*/
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

}




