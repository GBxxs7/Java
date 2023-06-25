package jiao.zi.hao.jiaozihao.service.impl;

import jiao.zi.hao.jiaozihao.entity.TUser;
import jiao.zi.hao.jiaozihao.exception.ServiceException;
import jiao.zi.hao.jiaozihao.mapper.TUserMapper;
import jiao.zi.hao.jiaozihao.service.ITUserService;
import jiao.zi.hao.jiaozihao.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Objects;

@Service
public class TUserService implements ITUserService {

    private final static String MD5_SLUT = "XMCU";

    @Autowired
    TUserMapper tUserMapper;

    @Override
    public List<TUser> userInquire() {
        List<TUser> tUsers = tUserMapper.userInquire();
        return tUsers;
    }

    @Override
    public void userAdd(TUser tUser) {
        if (tUser.getName() == null || tUser.getPassword() == null) {
            throw new ServiceException("用户信息异常");
        }
        String password = tUser.getPassword();
        System.out.println(password);
        String newpass = md5(password);
        System.out.println(newpass);
        tUser.setPassword(newpass);
        tUserMapper.userAdd(tUser);
    }

    @Override
    public TUser login(TUser tUser) {
        String md5Pass = md5(tUser.getPassword());
        tUser.setPassword(md5Pass);
        TUser tUser1 = tUserMapper.login(tUser);
        if (tUser1 == null) {
            throw new ServiceException("用户名错误");
        } else {
            if (!Objects.equals(tUser1.getPassword(), md5Pass)) {
                System.out.println(md5Pass);
                System.out.println(tUser1.getPassword());
                throw new ServiceException("密码错误");
            } else {
                // 生成 token
                String token = TokenUtils.genToken(String.valueOf(tUser1.getUser_id()), tUser1.getPassword());
                tUser1.setToken(token);
                return tUser1;
            }
        }

        // 生成 token
    }

    @Override
    public TUser getUserByName(Integer id) {

        return tUserMapper.getUserByName(id);
    }

    public static String md5(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 加盐处理，需要将对应的盐记录，用于验证密码
//            int randomNum = new SecureRandom().nextInt(1000);

            byte[] md5 = md.digest((data + MD5_SLUT).getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (byte b : md5) {
                //sb.append(Integer.toHexString(b & 0xff));
                // 字符串格式转成 16 进制
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
