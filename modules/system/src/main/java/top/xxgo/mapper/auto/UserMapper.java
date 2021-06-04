package top.xxgo.mapper.auto;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.xxgo.model.auto.User;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author xxgo
 * @since 2021-06-02
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
