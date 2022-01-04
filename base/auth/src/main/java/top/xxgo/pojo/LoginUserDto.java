package top.xxgo.pojo;

import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author xxgo
 * @since 2021-06-02
 */
@EqualsAndHashCode(callSuper = true)
public class LoginUserDto extends User implements Serializable {


    private Long id;


    private String username;

    private String password;

    private String mobile;

    private String nickName;


    private String accountType;

    private String personid;

    private Boolean enabled;
    private Boolean accountNonExpired;
    private Boolean credentialsNonExpired;
    private Boolean accountNonLocked;


    public LoginUserDto(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, true, true, true, true, authorities);
    }

//    public LoginUserDto(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Long id, String password1, String mobile, String nickName, String accountType, String personid) {
//        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
//        this.id = id;
//        this.username = username;
//        this.password = password1;
//        this.mobile = mobile;
//        this.nickName = nickName;
//        this.accountType = accountType;
//        this.personid = personid;
//    }
//
//    public LoginUserDto(LoginUser loginUser , Collection<? extends GrantedAuthority> authorities) {
//        super(loginUser.getUsername(),null,
//                loginUser.getEnabled(),
//                loginUser.getAccountNonExpired(),
//                loginUser.getCredentialsNonExpired(),
//                loginUser.getAccountNonLocked(), authorities);
//        this.id = loginUser.getId();
//    }

}
