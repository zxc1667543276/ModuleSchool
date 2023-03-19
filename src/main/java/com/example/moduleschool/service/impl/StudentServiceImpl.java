package com.example.moduleschool.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.moduleschool.pojo.Student;
import com.example.moduleschool.service.StudentService;
import com.example.moduleschool.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author zxc
* @description 针对表【tb_student】的数据库操作Service实现
* @createDate 2023-02-28 23:34:16
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{
    @Resource
    private  StudentMapper studentMapper;
    @Override
    public Student selectPwdAndName(String username, String passwd) {
        return studentMapper.selectOne(new LambdaQueryWrapper<Student>().eq(Student::getName,username)
                .eq(Student::getPassword,passwd));
    }

    @Override
    public Student selectById(Long userid) {
        return studentMapper.selectOne(new LambdaQueryWrapper<Student>().eq(Student::getId,userid));
    }
}




