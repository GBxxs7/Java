package jiao.zi.hao.jiaozihao.mapper;

import jiao.zi.hao.jiaozihao.entity.TUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TUserMapper {
    List<TUser> userInquire();

    void userAdd(TUser tUser);

    TUser login(TUser tUser);

    TUser getUserByName(Integer id);
}
