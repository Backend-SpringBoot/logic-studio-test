package logic.studio.base.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class CharEncodingFilter {
  @Bean
  public FilterRegistrationBean<CharacterEncodingFilter> filterRegistrationBean() {
    CharacterEncodingFilter filter = new CharacterEncodingFilter();
    filter.setEncoding("UTF-8");
    filter.setForceEncoding(true);

    FilterRegistrationBean<CharacterEncodingFilter> registrationBean =
        new FilterRegistrationBean<>();
    registrationBean.setFilter(filter);
    registrationBean.addUrlPatterns("/*");

    return registrationBean;
  }

  @Bean
  public FilterRegistrationBean<CharsetResponseFilter> charsetResponseFilterRegistrationBean() {
    FilterRegistrationBean<CharsetResponseFilter> registrationBean = new FilterRegistrationBean<>();
    registrationBean.setFilter(new CharsetResponseFilter());
    registrationBean.addUrlPatterns("/*");
    return registrationBean;
  }
}
