package top.xxgo.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.logging.log4j.util.Strings;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.misc.BASE64Decoder;
import top.xxgo.common.core.constant.AuthConstant;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class RequestUtils {


    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

    }

    public static JSONObject getJwtPayload() {
        String jwtPayload = getRequest().getHeader(AuthConstant.JWT_PAYLOAD_KEY);
        return JSONUtil.parseObj(jwtPayload);

    }

    public static Long getUserId() {
        return getJwtPayload().getLong(AuthConstant.USER_ID_KEY);

    }


    public static String getUsername() {
        return getJwtPayload().getStr(AuthConstant.USER_NAME_KEY);
    }

    /**
     * 获取JWT的载体中的clientId
     *
     * @return
     */
    public static String getClientId() {
        return getJwtPayload().getStr(AuthConstant.CLIENT_ID_KEY);

    }

    /**
     * 获取登录认证的客户端ID
     * <p>
     * 兼容两种方式获取Oauth2客户端信息（client_id、client_secret）
     * 方式一：client_id、client_secret放在请求路径中
     * 方式二：放在请求头（Request Headers）中的Authorization字段，且经过加密，例如 Basic Y2xpZW50OnNlY3JldA== 明文等于 client:secret
     *
     * @return
     */
    @SneakyThrows
    public static String getAuthClientId() {
        String clientId;

        HttpServletRequest request = getRequest();

        // 从请求路径中获取
        clientId = request.getParameter(AuthConstant.CLIENT_ID_KEY);
        if (StrUtil.isNotBlank(clientId)) {
            return clientId;
        }

        // 从请求头获取
        String basic = request.getHeader(AuthConstant.AUTHORIZATION_KEY);
        basic = request.getHeader(AuthConstant.AUTHORIZATION_KEY);
        if (StrUtil.isNotBlank(basic) && basic.startsWith(AuthConstant.BASIC_PREFIX)) {
            basic = basic.replace(AuthConstant.BASIC_PREFIX, Strings.EMPTY);
            String basicPlainText = new String(new BASE64Decoder().decodeBuffer(basic), "UTF-8");
            clientId = basicPlainText.split(":")[0]; //client:secret
        }
        return clientId;
    }


    public static List<Long> getRoleIds() {
        List<String> list = getJwtPayload().get(AuthConstant.JWT_AUTHORITIES_KEY, List.class);
        return  list.stream().map(Long::valueOf).collect(Collectors.toList());

    }

    public static void main(String[] args) {

        try {
            throw new MyBatisSystemException(new TooManyResultsException("sss"));
        }catch (Exception e){
            System.out.println("-------------------");
            e.printStackTrace();
        }

    }
}
