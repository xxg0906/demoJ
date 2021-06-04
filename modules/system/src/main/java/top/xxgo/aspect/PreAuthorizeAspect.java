package top.xxgo.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;
import top.xxgo.annotation.PreAuthorize;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * 自定义权限实现
 * 
 * @author ruoyi
 */
@Aspect
@Component
public class PreAuthorizeAspect
{


    /** 所有权限标识 */
    private static final String ALL_PERMISSION = "*:*:*";

    /** 管理员角色权限标识 */
    private static final String SUPER_ADMIN = "admin";

    /** 数组为0时 */
    private static final Integer ARRAY_EMPTY = 0;

    @Value("${spring.application.name}")
    String applicationName;

    @Around("@annotation(top.xxgo.annotation.PreAuthorize)")
    public Object around(ProceedingJoinPoint point) throws Throwable
    {

        SourceLocation sourceLocation = point.getSourceLocation();
        RestController restController = (RestController) sourceLocation.getWithinType().getAnnotation(RestController.class);
        String value = restController.value();

        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
         PreAuthorize annotation = method.getAnnotation(PreAuthorize.class);
        if (annotation == null)
        {
            return point.proceed();
        }
        System.out.println(applicationName+":"+value+":"+method.getName());
        if (!StringUtils.isEmpty(annotation.hasPermi()))
        {
            if (hasPermi(annotation.hasPermi()))
            {
                return point.proceed();
            }
            throw new  Exception();
        }
        else if (!StringUtils.isEmpty(annotation.lacksPermi()))
        {
            if (lacksPermi(annotation.lacksPermi()))
            {
                return point.proceed();
            }
            throw new Exception();
        }
        else if (ARRAY_EMPTY < annotation.hasAnyPermi().length)
        {
            if (hasAnyPermi(annotation.hasAnyPermi()))
            {
                return point.proceed();
            }
            throw new Exception();
        }
        else if (!StringUtils.isEmpty(annotation.hasRole()))
        {
            if (hasRole(annotation.hasRole()))
            {
                return point.proceed();
            }
            throw new Exception();
        }
        else if (!StringUtils.isEmpty(annotation.lacksRole()))
        {
            if (lacksRole(annotation.lacksRole()))
            {
                return point.proceed();
            }
            throw new Exception();
        }
        else if (ARRAY_EMPTY < annotation.hasAnyRoles().length)
        {
            if (hasAnyRoles(annotation.hasAnyRoles()))
            {
                return point.proceed();
            }
            throw new Exception();
        }

        return point.proceed();
    }

    /**
     * 验证用户是否具备某权限
     * 
     * @param permission 权限字符串
     * @return 用户是否具备某权限
     */
    public boolean hasPermi(String permission)
    {
         return  true;
    }

    /**
     * 验证用户是否不具备某权限，与 hasPermi逻辑相反
     *
     * @param permission 权限字符串
     * @return 用户是否不具备某权限
     */
    public boolean lacksPermi(String permission)
    {
        return hasPermi(permission) != true;
    }

    /**
     * 验证用户是否具有以下任意一个权限
     *
     * @param permissions 权限列表
     * @return 用户是否具有以下任意一个权限
     */
    public boolean hasAnyPermi(String[] permissions)
    {

        return false;
    }

    /**
     * 判断用户是否拥有某个角色
     * 
     * @param role 角色字符串
     * @return 用户是否具备某角色
     */
    public boolean hasRole(String role)
    {

        return false;
    }

    /**
     * 验证用户是否不具备某角色，与 isRole逻辑相反。
     *
     * @param role 角色名称
     * @return 用户是否不具备某角色
     */
    public boolean lacksRole(String role)
    {
        return hasRole(role) != true;
    }

    /**
     * 验证用户是否具有以下任意一个角色
     *
     * @param roles 角色列表
     * @return 用户是否具有以下任意一个角色
     */
    public boolean hasAnyRoles(String[] roles)
    {
        return false;
    }

    /**
     * 判断是否包含权限
     * 
     * @param authorities 权限列表
     * @param permission 权限字符串
     * @return 用户是否具备某权限
     */
    private boolean hasPermissions(Collection<String> authorities, String permission)
    {
return  true;
    }
}
