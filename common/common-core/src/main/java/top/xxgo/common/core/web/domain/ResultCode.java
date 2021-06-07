package top.xxgo.common.core.web.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author haoxr
 * @date 2020-06-23
 **/
@AllArgsConstructor
@NoArgsConstructor
public enum ResultCode implements Serializable {
    /**
     * 一切ok
     */

    SUCCESS("200", "操作成功"),
    /**
     * 用户端错误
     */


    USER_ERROR("0001", "用户端错误"),
    /**
     * 用户登录异常
     */
    USER_LOGIN_ERROR("0200", "用户登录异常"),
    /**
     * 用户不存在
     */


    USER_NOT_EXIST("0201", "用户不存在"),
    /**
     * 用户账户被冻结
     */

    USER_ACCOUNT_LOCKED("0202", "用户账户被冻结"),
    /**
     * 用户账户已作废
     */
    USER_ACCOUNT_INVALID("0203", "用户账户已作废"),
    /**
     * 用户名或密码错误
     */


    USERNAME_OR_PASSWORD_ERROR("0210", "用户名或密码错误"),
    /**
     * 用户输入密码次数超限
     */

    INPUT_PASSWORD_EXCEED_LIMIT("0211", "用户输入密码次数超限"),
    /**
     * 客户端认证失败
     */

    CLIENT_AUTHENTICATION_FAILED("0212", "客户端认证失败"),
    /**
     * token无效或已过期
     */

    TOKEN_INVALID_OR_EXPIRED("0230", "token无效或已过期"),
    /**
     * token已被禁止访问
     */
    TOKEN_ACCESS_FORBIDDEN("0231", "token已被禁止访问"),
    /**
     * 访问权限异常
     */


    AUTHORIZED_ERROR("0300", "访问权限异常"),
    /**
     * 访问未授权
     */

    ACCESS_UNAUTHORIZED("0301", "访问未授权"),
    /**
     * 演示环境禁止修改
     */
    FORBIDDEN_OPERATION("0302", "演示环境禁止修改、删除重要数据，请本地部署后测试"),

    /**
     * 用户请求参数错误
     */


    PARAM_ERROR("0400", "用户请求参数错误"),
    /**
     * 请求必填参数为空
     */

    PARAM_IS_NULL("0410", "请求必填参数为空"),
    /**
     * 查询模式为空
     */
    QUERY_MODE_IS_NULL("0411", "查询模式为空"),
    /**
     * 用户上传文件异常
     */


    USER_UPLOAD_FILE_ERROR("0700", "用户上传文件异常"),
    /**
     * 用户上传文件类型不匹配
     */

    USER_UPLOAD_FILE_TYPE_NOT_MATCH("0701", "用户上传文件类型不匹配"),
    /**
     * 用户上传文件太大
     */


    USER_UPLOAD_FILE_SIZE_EXCEEDS("0702", "用户上传文件太大"),
    /**
     * 用户上传图片太大
     */
    USER_UPLOAD_IMAGE_SIZE_EXCEEDS("0703", "用户上传图片太大"),
    /**
     * 系统执行出错
     */


    SYSTEM_EXECUTION_ERROR("1001", "系统执行出错"),
    /**
     * 系统执行超时
     */

    SYSTEM_EXECUTION_TIMEOUT("1100", "系统执行超时"),
    /**
     * 系统订单处理超时
     */
    SYSTEM_ORDER_PROCESSING_TIMEOUT("1100", "系统订单处理超时"),
    /**
     * 系统容灾功能被出发
     */


    SYSTEM_DISASTER_RECOVERY_TRIGGER("1200", "系统容灾功能被出发"),
    /**
     * 系统限流
     */

    FLOW_LIMITING("1210", "系统限流"),
    /**
     * 系统功能降级
     */
    DEGRADATION("1220", "系统功能降级"),
    /**
     * 系统资源异常
     */


    SYSTEM_RESOURCE_ERROR("1300", "系统资源异常"),
    /**
     * 系统资源耗尽
     */

    SYSTEM_RESOURCE_EXHAUSTION("1310", "系统资源耗尽"),
    /**
     * 系统资源访问异常
     */

    SYSTEM_RESOURCE_ACCESS_ERROR("1320", "系统资源访问异常"),
    /**
     * 系统读取磁盘文件失败
     */
    SYSTEM_READ_DISK_FILE_ERROR("1321", "系统读取磁盘文件失败"),
    /**
     * 调用第三方服务出错
     */


    CALL_THIRD_PARTY_SERVICE_ERROR("2001", "调用第三方服务出错"),
    /**
     * 中间件服务出错
     */

    MIDDLEWARE_SERVICE_ERROR("2100", "中间件服务出错"),
    /**
     * 接口不存在
     */
    INTERFACE_NOT_EXIST("2113", "接口不存在"),
    /**
     * 消息服务出错
     */


    MESSAGE_SERVICE_ERROR("2120", "消息服务出错"),
    /**
     * 消息投递出错
     */

    MESSAGE_DELIVERY_ERROR("2121", "消息投递出错"),
    /**
     * 消息消费出错
     */

    MESSAGE_CONSUMPTION_ERROR("2122", "消息消费出错"),
    /**
     * 消息订阅出错
     */

    MESSAGE_SUBSCRIPTION_ERROR("2123", "消息订阅出错"),
    /**
     * 消息分组未查到
     */
    MESSAGE_GROUP_NOT_FOUND("2124", "消息分组未查到"),
    /**
     * 数据库服务出错
     */

    DATABASE_ERROR("2300", "数据库服务出错"),

    /**
     * 表不存在
     */

    DATABASE_TABLE_NOT_EXIST("2311", "表不存在"),
    /**
     * 列不存在
     */

    DATABASE_COLUMN_NOT_EXIST("2312", "列不存在"),
    /**
     * 多表关联中存在多个相同名称的列
     */

    DATABASE_DUPLICATE_COLUMN_NAME("2321", "多表关联中存在多个相同名称的列"),
    /**
     * 数据库死锁
     */

    DATABASE_DEADLOCK("2331", "数据库死锁"),
    /**
     * 主键冲突
     */
    DATABASE_PRIMARY_KEY_CONFLICT("2341", "主键冲突");

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private String code;

    private String msg;

    @Override
    public String toString() {
        return "{" +
                "\"code\":\"" + code + '\"' +
                ", \"msg\":\"" + msg + '\"' +
                '}';
    }


    public static ResultCode getValue(String code) {
        for (ResultCode value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return SYSTEM_EXECUTION_ERROR; // 默认分页查询
    }
}
