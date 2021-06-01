package top.xxgo.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.authentication.TokenExtractor;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 *
 * token 提取器
 * @author xxg
 */
public class JwtTokenExtractor  implements TokenExtractor {
    @Override
    public Authentication extract(HttpServletRequest request) {
        String token = request.getHeader("access_token");
        if (token != null) {
            return new PreAuthenticatedAuthenticationToken(token, "");
        } else {
            token = request.getParameter(OAuth2AccessToken.ACCESS_TOKEN);
            if (token != null) {
                return new PreAuthenticatedAuthenticationToken(token, "");
            }
        }
        return null;

    }
}
