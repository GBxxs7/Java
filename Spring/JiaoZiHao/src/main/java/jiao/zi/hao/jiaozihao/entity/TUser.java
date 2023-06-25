package jiao.zi.hao.jiaozihao.entity;

import lombok.Data;

@Data
public class TUser {
    private Integer user_id;
    private String name;
    private String password;
    private String token;
}
