package top.xxgo.controller;


import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xxgo.common.core.web.domain.RestApiResult;


@Api(tags = "注销")
@RestController
@RequestMapping("/oauth")
@AllArgsConstructor
@Slf4j
public class LogoutController {



    @DeleteMapping("/logout")
    public RestApiResult<Void> logout() {
//        JSONObject jsonObject = RequestUtils.getJwtPayload();
//        String jti = jsonObject.getStr(AuthConstant.JWT_JTI); // JWT唯一标识
//        long exp = jsonObject.getLong(AuthConstant.JWT_EXP); // JWT过期时间戳
//
//        long currentTimeSeconds = System.currentTimeMillis() / 1000;
//
//        if (exp < currentTimeSeconds) { // token已过期，无需加入黑名单
//            return RestApiResult.ok();
//        }
//        redisTemplate.opsForValue().set(AuthConstant.TOKEN_BLACKLIST_PREFIX + jti, null, (exp - currentTimeSeconds), TimeUnit.SECONDS);
//
        return RestApiResult.ok();
    }

}
