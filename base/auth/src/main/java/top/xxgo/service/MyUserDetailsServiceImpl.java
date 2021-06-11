package top.xxgo.service;
//MyUserDetailsService.java

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import top.xxgo.pojo.LoginUser;
import top.xxgo.pojo.LoginUserDto;


import java.util.List;

/**
 * @author zhanghui
 * @date 2019/4/24
 */
@Service("myUserDetailsServiceImpl")
@AllArgsConstructor

public class MyUserDetailsServiceImpl implements UserDetailsService {

    private final IUserService userService;



    /**
     * 根据用户的角色判断权限
     */
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        //模拟数据库

        LambdaQueryWrapper<LoginUser> objectQueryWrapper = new LambdaQueryWrapper<>();
        objectQueryWrapper.eq(LoginUser::getUsername,username);
        LoginUser one = userService.getOne(objectQueryWrapper);
        // authorities 是 roles 集合
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
        //上面是根据用户名查出用户信息，下面才会比较传来的password是否正确
        return   new User(one.getUsername(),one.getPassword(),authorities);
    }



    public static void main(String[] args) {
        String encode =
                new BCryptPasswordEncoder().encode("123456");
        System.out.println(encode);

    }
}
