package top.xxgo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.xxgo.mapper.auto.UserMapper;
import top.xxgo.model.auto.User;
import top.xxgo.service.IUserService;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author xxgo
 * @since 2021-06-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
