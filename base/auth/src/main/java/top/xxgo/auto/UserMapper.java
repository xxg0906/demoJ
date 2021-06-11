package top.xxgo.auto;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.xxgo.pojo.LoginUser;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author xxgo
 * @since 2021-06-02
 */
@Mapper
public interface UserMapper extends BaseMapper<LoginUser> {

}
