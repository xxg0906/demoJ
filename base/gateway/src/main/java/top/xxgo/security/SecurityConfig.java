package top.xxgo.security;


import cn.hutool.core.convert.Convert;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


/**
 * @author xxg
 *
 */
@ConfigurationProperties(prefix = "security")
@AllArgsConstructor
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {


    private final SecurityAuthorizationManager securityAuthorizationManager;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//        http.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter())
//                .publicKey(rsaPublicKey()) // 本地获取公钥
        //.jwkSetUri() // 远程获取公钥
        ;
//        http.oauth2ResourceServer().authenticationEntryPoint(authenticationEntryPoint());
//        http.authorizeExchange()
//                .pathMatchers(Convert.toStrArray(ignoreUrls)).permitAll()
//                .anyExchange().access(resourceServerManager)
//                .and()
//                .exceptionHandling()
//                .accessDeniedHandler(accessDeniedHandler()) // 处理未授权
//                .authenticationEntryPoint(authenticationEntryPoint()) //处理未认证
//                .and().csrf().disable();
//
//        return http.build();
         http.authorizeExchange().pathMatchers("/service-a/test").permitAll()
                .anyExchange().access(securityAuthorizationManager)
         .and().csrf().disable();


         return  http.build();
    }




}
