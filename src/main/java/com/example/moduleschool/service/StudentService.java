package com.example.moduleschool.service;

import com.example.moduleschool.pojo.Student;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author zxc
* @description 针对表【tb_student】的数据库操作Service
* @createDate 2023-02-28 23:34:16
*/
public interface StudentService extends IService<Student> {

    Student selectPwdAndName(String username, String passwd);

    Student selectById(Long userid);
}
