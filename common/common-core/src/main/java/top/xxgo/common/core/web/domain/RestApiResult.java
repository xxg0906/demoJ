package top.xxgo.common.core.web.domain;



import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @author xxg
 */
public class RestApiResult<T> implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 成功 */
    public static final String SUCCESS = HttpStatus.OK.value()+ Strings.EMPTY;

    /** 失败 */
    public static final String FAIL = HttpStatus.INTERNAL_SERVER_ERROR.value()+ Strings.EMPTY;

    private String code;

    private String msg;

    private T data;

    public static <T> RestApiResult<T> ok()
    {
        return restResult(null, SUCCESS, null);
    }

    public static <T> RestApiResult<T> ok(T data)
    {
        return restResult(data, SUCCESS, null);
    }

    public static <T> RestApiResult<T> ok(T data, String msg)
    {
        return restResult(data, SUCCESS, msg);
    }

    public static <T> RestApiResult<T> fail()
    {
        return restResult(null, FAIL, null);
    }

    public static <T> RestApiResult<T> fail(String msg)
    {
        return restResult(null, FAIL, msg);
    }

    public static <T> RestApiResult<T> fail(T data)
    {
        return restResult(data, FAIL, null);
    }
    public static <T> RestApiResult<T> fail(ResultCode resultCode)
    {
        return restResult(null, resultCode.getCode(), resultCode.getMsg());
    }


    public static <T> RestApiResult<T> fail(T data, String msg)
    {
        return restResult(data, FAIL, msg);
    }

    public static <T> RestApiResult<T> fail(String code, String msg)
    {
        return restResult(null, code, msg);
    }

    private static <T> RestApiResult<T> restResult(T data, String code, String msg)
    {
        RestApiResult<T> apiResult = new RestApiResult<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }
}
