package org.arun.springoauth.employee.config;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;

@Getter
@Setter
@Component
@Configuration
@ConfigurationProperties(prefix = "rest.security")
public class SecurityProperties {

  private boolean enabled;
  private String apiMatcher;
  private Cors cors;
  private String issuerUri;

  public CorsConfiguration getCorsConfiguration() {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.setAllowedOrigins(cors.allowedOrigins);
    corsConfiguration.setAllowedMethods(cors.allowedMethods);
    corsConfiguration.setAllowedHeaders(cors.allowedHeaders);
    corsConfiguration.setExposedHeaders(cors.exposedHeaders);
    corsConfiguration.setAllowCredentials(cors.allowCredentials);
    corsConfiguration.setMaxAge(cors.maxAge);

    return corsConfiguration;
  }

  @Getter
  @Setter
  public static class Cors {

    private List<String> allowedOrigins;
    private List<String> allowedMethods;
    private List<String> allowedHeaders;
    private List<String> exposedHeaders;
    private Boolean allowCredentials;
    private Long maxAge;
  }

}
