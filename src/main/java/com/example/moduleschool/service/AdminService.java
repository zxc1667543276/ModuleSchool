package com.example.moduleschool.service;

import com.example.moduleschool.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author zxc
* @description 针对表【tb_admin】的数据库操作Service
* @createDate 2023-02-28 23:30:34
*/
public interface AdminService extends IService<Admin> {

    Admin selectPwdAndName(String username, String passwd);

    Admin selectById(Long userid);
}
