package top.xxgo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;


/**
 * 授权服务器
 * @author xxg
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer  extends AuthorizationServerConfigurerAdapter {

    /**
     *  客户端详情信息在这里进行初始化，
     *  把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息
     *
     * @param clients  clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory() // <1>
                // <2> begin ...
                .withClient("clientapp").secret("112233") // Client 账号、密码。
                .redirectUris("http://localhost:8085/callback") // 配置回调地址，选填。
                .authorizedGrantTypes("authorization_code") // 授权码模式
                .scopes("read_userinfo", "read_contacts") // 可授权的 Scope
        // <2> end ...
//                .and().withClient() // 可以继续配置新的 Client // <3>
        ;
    }

    /**
     *用来配置授权（authorization）
     *以及令牌（token）的访问端点和令牌服务(token services)。
     *
     * @param security  security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
    }

    /**
     *
     * 用来配置授权（authorization）
     * 以及令牌（token）的访问端点和令牌服务(token services)
     * 还有token的存储方式(tokenStore)；
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        super.configure(endpoints);
    }
}
