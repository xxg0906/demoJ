package top.xxgo.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.security.oauth2.provider.authentication.TokenExtractor;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * token 提取器
 * @author xxg
 */
public class JwtTokenExtractor  implements TokenExtractor {
    @Override
    public Authentication extract(HttpServletRequest request) {
        BearerTokenExtractor bearerTokenExtractor = new BearerTokenExtractor();
        return bearerTokenExtractor.extract(request);
    }
}
