package top.xxgo.pojo;

//SysUser.java

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author zhanghui
 * @date 2019/4/24
 */
@EqualsAndHashCode(callSuper = true)
public class SysUser2 extends User {


    private String countType="ssss";

    public String getCountType() {
        return countType;
    }

    public void setCountType(String countType) {
        this.countType = countType;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    private  String roles;
    public SysUser2(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }



}
