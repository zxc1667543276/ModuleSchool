package com.example.moduleschool.service;

import com.example.moduleschool.pojo.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author zxc
* @description 针对表【tb_teacher】的数据库操作Service
* @createDate 2023-02-28 23:34:21
*/
public interface TeacherService extends IService<Teacher> {

    Teacher selectPwdAndName(String username, String passwd);

    Teacher selectById(Long userid);
}
