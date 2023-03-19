package com.example.moduleschool.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.moduleschool.pojo.Admin;
import com.example.moduleschool.pojo.LoginForm;
import com.example.moduleschool.pojo.Student;
import com.example.moduleschool.pojo.Teacher;
import com.example.moduleschool.service.AdminService;
import com.example.moduleschool.service.GradeService;
import com.example.moduleschool.service.StudentService;
import com.example.moduleschool.service.TeacherService;
import com.example.moduleschool.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/sms/system")
public class MyController {

    @Autowired
    AdminService adminService;
    @Autowired
    StudentService studentService;
    @Resource
    GradeService gradeService;
    @Autowired
    TeacherService teacherService;
    @GetMapping("/getVerifiCodeImage")
    public void getVerifiCodeImagegetVerifiCodeImage(
            HttpSession session,
            HttpServletResponse response
    ) throws IOException {
        BufferedImage image= CreateVerifiCodeImage.getVerifiCodeImage();
        String code=new String(CreateVerifiCodeImage.getVerifiCode());
        session.setAttribute("code",code);
            ImageIO.write(image,"JPG",response.getOutputStream());
    }
    @PostMapping("/login")
    public Result<Object> login(@RequestBody  LoginForm loginForm,HttpSession session){
        String code = (String) session.getAttribute("code");
            if(!code.equalsIgnoreCase(loginForm.getVerifiCode())||loginForm.getVerifiCode().equals("")){
                log.info(code+ loginForm.getVerifiCode());
                return  Result.fail().message("验证码错误");

            }
            session.removeAttribute("code");
            Integer tf= loginForm.getUserType();
            String passwd= MD5.encrypt(loginForm.getPassword());
            String username=loginForm.getUsername();
            Map<String,Object> map=new HashMap<>();
            if(tf==1){
               Admin admin= adminService.selectPwdAndName(username,passwd);
               if(admin!=null){
                   String token = JwtHelper.createToken(admin.getId().longValue(), tf);
                   map.put("token",token);
                   map.put("usertype",tf);
                   return  Result.ok(map);
               }
               return  Result.fail("用户名或密码错误");
            }else if(tf==2){
                Student student = studentService.selectPwdAndName(username, passwd);
                if(student!=null) {
                    String token = JwtHelper.createToken(student.getId().longValue(), tf);
                    map.put("token", token);
                    map.put("usertype", tf);
                    return Result.ok(map);
                }
                return  Result.fail("用户名或密码错误");
            }else if(tf==3){
                Teacher teacher = teacherService.selectPwdAndName(username, passwd);
                if(teacher!=null){
                    String token = JwtHelper.createToken(teacher.getId().longValue(), tf);
                    map.put("token",token);
                    map.put("usertype",tf);
                    return  Result.ok(map);
                }
                return  Result.fail("用户名或密码错误");
            }
        return  Result.fail("用户名或密码错误");

    }

    @GetMapping("/getInfo")
    public Result<Object> getInfo(@RequestHeader("token") String token){
            if(JwtHelper.isExpiration(token)){
                return Result.build(null, ResultCodeEnum.TOKEN_ERROR);
            }
            Long userid=JwtHelper.getUserId(token);
            Integer usertype= JwtHelper.getUserType(token);
            Map<String,Object> map=new HashMap<>();
            map.put("userType",usertype);
            if(usertype==1){
                Admin admin = adminService.selectById(userid);
                map.put("user",admin);
            }else if(usertype==2){
                Student student = studentService.selectById(userid);

            }else{
                Teacher teacher = teacherService.selectById(userid);
            }
            return Result.ok(map);
    }



    @GetMapping("/getInfo1")
    public Result<Object> getInfo1(@RequestHeader("token") String token){
        if(JwtHelper.isExpiration(token)){
            return Result.build(null, ResultCodeEnum.TOKEN_ERROR);
        }
        Long userid=JwtHelper.getUserId(token);
        Integer usertype= JwtHelper.getUserType(token);
        Map<String,Object> map=new HashMap<>();
        //gradeService.page(new Page<>(1,2),new LambdaQueryWrapper<>().like())
        return Result.ok(map);
    }
}
