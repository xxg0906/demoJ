package top.xxgo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

public class MD5BCryptPasswordEncoder  extends BCryptPasswordEncoder {

   static String salt ="md5s";
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        String encode = DigestUtils.md5DigestAsHex((rawPassword+salt+rawPassword).getBytes());
        return super.matches(encode, encodedPassword);
    }

    public static void main(String[] args) {
        String encode = new BCryptPasswordEncoder().encode("123456");

        System.out.println(encode);
    }
}
