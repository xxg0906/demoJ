package top.xxgo.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


/**
 * @author xxg
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class SecurityAuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {



    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        //token 校验
        System.out.println("-----------check");

        return Mono.just(new AuthorizationDecision(true));

    }
}
