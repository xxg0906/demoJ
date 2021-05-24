package top.xxgo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xxg
 */
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "auth.ignore")
@Data
public class AuthIgnoreProperties {

    List<String> ignores=new ArrayList<>();

}
