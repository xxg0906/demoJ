package top.xxgo.common.core.web.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xxg
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    private String createBy;
    private String updateBy;
    private Date createTime;
    private Date updateTime;
}
