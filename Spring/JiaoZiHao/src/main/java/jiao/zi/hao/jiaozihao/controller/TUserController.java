package jiao.zi.hao.jiaozihao.controller;

import jiao.zi.hao.jiaozihao.common.Result;
import jiao.zi.hao.jiaozihao.entity.TUser;
import jiao.zi.hao.jiaozihao.service.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tuser")
public class TUserController {

    @Autowired
    ITUserService itUserService;

    // User 查询全部用户接口
    @GetMapping("/userInquire")
    public Result userInquire() {
        List<TUser> tUsers = itUserService.userInquire();
        return Result.success(tUsers, "查询成功");
    }

    // User 查询单个用户信息接口 by name
    @GetMapping("/getUserByName/{id}")
    public Result getUserByName(@PathVariable Integer id) {

        TUser tUser = itUserService.getUserByName(id);

        return Result.success(tUser);
    }

    // User 添加用户接口
    @PostMapping("/userAdd")
    public Result userAdd(@RequestBody TUser tUser) {
        itUserService.userAdd(tUser);
        return Result.success("添加成功");
    }


    // User 账号登陆接口
    @PostMapping("/userLogin")
    public Result login(@RequestBody TUser tUser) {

        TUser tUser1 = itUserService.login(tUser);

        return Result.success(tUser1);
    }

}
