package top.xxgo.common.core.constant;

/**
 * @author xxg
 */
public final class AuthConstant {


    public static final String PERMISSION_ROLES_REDIS_KEY="auth:permission:roles";


    /**
     * JWT存储权限前缀
     */
    public static final   String AUTHORITY_PREFIX = "ROLE_";

    /**
     * JWT存储权限属性
     */
    public static final   String JWT_AUTHORITIES_KEY = "authorities";


    /**
     * 认证请求头key
     */
    public static final    String AUTHORIZATION_KEY = "Authorization";

    /**
     * JWT令牌前缀
     */
    public static final   String AUTHORIZATION_PREFIX = "bearer ";


    /**
     * Basic认证前缀
     */
    public static final  String BASIC_PREFIX = "Basic ";



    /**
     * JWT载体key
     */
    public static final String JWT_PAYLOAD_KEY = "payload";

    /**
     * JWT ID 唯一标识
     */
    public static final String JWT_JTI = "jti";

    /**
     * JWT ID 唯一标识
     */
    public static final String JWT_EXP = "exp";

    /**
     * 黑名单token前缀
     */
    public static final   String TOKEN_BLACKLIST_PREFIX = "auth:token:blacklist:";



    /**
     * 密码加密方式
     */
    public static final  String BCRYPT = "{bcrypt}";

    public static final   String USER_ID_KEY = "user_id";

    public static final   String USER_NAME_KEY = "username";

    public static final  String CLIENT_ID_KEY = "client_id";
}
