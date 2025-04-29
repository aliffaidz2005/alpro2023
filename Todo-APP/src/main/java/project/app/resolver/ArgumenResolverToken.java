package project.app.resolver;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import project.app.entity.User;
import project.app.exception.UnautorizedUserException;
import project.app.model.Token;
import project.app.repository.UserRespository;

@Component
public class ArgumenResolverToken implements HandlerMethodArgumentResolver {

    private UserRespository userRespository;

    public ArgumenResolverToken(UserRespository userRespository){
        this.userRespository = userRespository;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Token.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        String token = null;

        Cookie[] cookies = request.getCookies();
        for (Cookie data : cookies){
            if("TOKEN".equals(data.getName())){
                token = data.getValue();
                break;
            }
        }

        if(token == null){
           throw  new UnautorizedUserException("user tidak dikenali harap login ulang");
        }

        User user = userRespository.findFirstUserByToken(token).orElseThrow(
                ()-> new UnautorizedUserException("user tidak dikenali harap login ulang argumen")
        );
        return new Token(user.getToken(),user.getId());
    }
}
