package com.example.moduleschool.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.moduleschool.pojo.Teacher;
import com.example.moduleschool.service.TeacherService;
import com.example.moduleschool.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author zxc
* @description 针对表【tb_teacher】的数据库操作Service实现
* @createDate 2023-02-28 23:34:21
*/
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
    implements TeacherService{
    @Resource
    private TeacherMapper teacherMapper;
    @Override
    public Teacher selectPwdAndName(String username, String passwd) {
        return teacherMapper.selectOne(new LambdaQueryWrapper<Teacher>().eq(Teacher::getName,username)
                .eq(Teacher::getPassword,passwd));
    }

    @Override
    public Teacher selectById(Long userid) {
        return teacherMapper.selectOne(new LambdaQueryWrapper<Teacher>().eq(Teacher::getId,userid));
    }
}




