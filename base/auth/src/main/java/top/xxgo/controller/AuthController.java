package top.xxgo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.security.Principal;
import java.util.Map;

/**
 * @author xxg
 */
@Api(tags = "认证中心")
@RestController
@RequestMapping("/oauth")
@AllArgsConstructor
@Slf4j
public class AuthController {

//    private final TokenEndpoint tokenEndpoint;
//
//
//    @ApiOperation(value = "OAuth2认证", notes = "login")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "grant_type", defaultValue = "password", value = "授权模式", required = true),
//            @ApiImplicitParam(name = "client_id", defaultValue = "client", value = "Oauth2客户端ID", required = true),
//            @ApiImplicitParam(name = "client_secret", defaultValue = "123456", value = "Oauth2客户端秘钥", required = true),
//            @ApiImplicitParam(name = "refresh_token", value = "刷新token"),
//            @ApiImplicitParam(name = "username", defaultValue = "admin", value = "登录用户名"),
//            @ApiImplicitParam(name = "password", defaultValue = "123456", value = "登录密码"),
//    })
//    @PostMapping("/token")
//    public OAuth2AccessToken postAccessToken(
//            @ApiIgnore Principal principal,
//            @ApiIgnore @RequestParam Map<String, String> parameters
//    ) throws HttpRequestMethodNotSupportedException {
//        return tokenEndpoint.postAccessToken(principal, parameters).getBody();
//    }


}
