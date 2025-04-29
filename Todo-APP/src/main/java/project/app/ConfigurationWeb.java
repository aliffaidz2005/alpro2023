package project.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import project.app.resolver.ArgumenResolverToken;

import java.util.List;
@Configuration
public class ConfigurationWeb implements WebMvcConfigurer {


    private ArgumenResolverToken argumenResolver;

    public ConfigurationWeb(ArgumenResolverToken argumenResolver){
        this.argumenResolver = argumenResolver;

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(argumenResolver);
    }

}
