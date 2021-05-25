package top.xxgo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;


/**
 * 授权服务器
 * @author xxg
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
@Configuration
@EnableAuthorizationServer

public class OAuth2AuthorizationServer  extends AuthorizationServerConfigurerAdapter {


    private static final String DEMO_RESOURCE_ID = "order";

    @Autowired
    protected AuthenticationManager authenticationManager;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;


    /**
     *  客户端详情信息在这里进行初始化，
     *  把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息
     *
     * @param clients  clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //配置两个客户端,一个用于password认证一个用于client认证
        clients.inMemory().withClient("client_1")
                .resourceIds(DEMO_RESOURCE_ID)
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("select")
                .authorities("client")
                .secret(new BCryptPasswordEncoder().encode("123456"))
                .and().withClient("client_2")
                .resourceIds(DEMO_RESOURCE_ID)
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("select")
                .authorities("client")
                .secret(new BCryptPasswordEncoder().encode("123456"));
    }

    /**
     *用来配置授权（authorization）
     *以及令牌（token）的访问端点和令牌服务(token services)。
     *
     * @param securityConfigurer  security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer securityConfigurer) throws Exception {
        //允许表单认证
        securityConfigurer.allowFormAuthenticationForClients();
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
        endpoints
                .tokenStore(new RedisTokenStore(redisConnectionFactory))
        .authenticationManager(authenticationManager);
    }
}
