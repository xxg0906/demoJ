package top.xxgo.common.core.web.domain;

import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private String remarks;
    @Version
    private Long  version;
    private Integer deleted;
}
