package top.xxgo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author xxgo
 * @since 2021-06-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class LoginUser implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("user_name")
    private String username;

    private String password;

    private String mobile;

    @TableField("nick_name")
    private String nickName;

    @TableField("account_type")
    private String accountType;

    private String personid;

    private Boolean enabled;
    private Boolean accountNonExpired;
    private Boolean credentialsNonExpired;
    private Boolean accountNonLocked;

}
