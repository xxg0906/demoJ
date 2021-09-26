package top.xxgo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xxgo.common.core.web.domain.ApiResult;

/**
 * @author xxg
 */
@RestController
public class FallbackController {


    @GetMapping("/fallbackA")
    public ApiResult fallbackA() {
      return   ApiResult.error(100, "服务暂时不可用");
    }
}
