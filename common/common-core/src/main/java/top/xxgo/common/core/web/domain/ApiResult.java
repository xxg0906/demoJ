package top.xxgo.common.core.web.domain;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Objects;

/**
 * 操作消息提醒
 *
 * @author xxgo
 */
public class ApiResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    public static final String CODE_TAG = "code";

    /**
     * 返回内容
     */
    public static final String MSG_TAG = "msg";

    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";

    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public ApiResult() {
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     */
    public ApiResult(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     * @param data 数据对象
     */
    public ApiResult(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (!Objects.isNull(data)) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 方便链式调用
     *
     * @param key   其他key
     * @param value 其他
     * @return 其他
     */
    @Override
    public ApiResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static ApiResult success() {
        return ApiResult.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static ApiResult success(Object data) {
        return ApiResult.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static ApiResult success(String msg) {
        return ApiResult.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static ApiResult success(String msg, Object data) {
        return new ApiResult(HttpStatus.OK.value(), msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return 操作失败
     */
    public static ApiResult error() {
        return ApiResult.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static ApiResult error(String msg) {
        return ApiResult.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static ApiResult error(String msg, Object data) {
        return new ApiResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, data);
    }

    /**
     * 系统内部错误
     *
     * @return 警告消息
     */
    public static ApiResult systemError() {
        return new ApiResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), "系统内部错误", null);
    }


    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg  返回内容
     * @return 警告消息
     */
    public static ApiResult error(int code, String msg) {
        return new ApiResult(code, msg, null);
    }
}
