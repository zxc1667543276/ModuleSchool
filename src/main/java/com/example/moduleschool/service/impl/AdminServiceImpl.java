package com.example.moduleschool.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.moduleschool.pojo.Admin;
import com.example.moduleschool.service.AdminService;
import com.example.moduleschool.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author zxc
* @description 针对表【tb_admin】的数据库操作Service实现
* @createDate 2023-02-28 23:30:34
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin selectPwdAndName(String username, String passwd) {
        return adminMapper.selectOne(new LambdaQueryWrapper<Admin>().eq(Admin::getName,username).
                eq(Admin::getPassword,passwd));
    }

    @Override
    public Admin selectById(Long userid) {
        return adminMapper.selectOne(new LambdaQueryWrapper<Admin>().eq(Admin::getId,userid));
    }
}




