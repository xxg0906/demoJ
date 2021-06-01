package top.xxgo.service;
//MyUserDetailsService.java
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import top.xxgo.pojo.SysUser;
import top.xxgo.pojo.SysUser2;

import java.util.List;
/**
 * @author zhanghui
 * @date 2019/4/24
 */
@Service("myUserDetailsServiceImpl")
public class MyUserDetailsServiceImpl implements UserDetailsService {
    /**
     * 根据用户的角色判断权限
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //模拟数据库

        // authorities 是 roles 集合
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
        //上面是根据用户名查出用户信息，下面才会比较传来的password是否正确
        return new SysUser2("abc",BCrypt.hashpw("123", BCrypt.gensalt()),authorities);

    }
}
