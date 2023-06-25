package jiao.zi.hao.jiaozihao.service;

import jiao.zi.hao.jiaozihao.entity.TUser;

import java.util.List;

public interface ITUserService {
    List<TUser> userInquire();

    void userAdd(TUser tUser);

    TUser login(TUser tUser);

    TUser getUserByName(Integer id);
}
