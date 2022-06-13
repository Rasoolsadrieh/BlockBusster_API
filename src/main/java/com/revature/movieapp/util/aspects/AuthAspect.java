package com.revature.movieapp.util.aspects;
import com.revature.movieapp.util.exceptions.AuthenticationException;
import com.revature.movieapp.util.web.SecureEndpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class AuthAspect {

    private HttpServletRequest request;

    @Autowired
    public AuthAspect(HttpServletRequest request){
        this.request = request;
    }


    @Around("@annotation(com.revature.movieapp.util.web.SecureEndpoint)")
    public Object secureEndpoints(ProceedingJoinPoint pjp) throws Throwable {
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        SecureEndpoint anno = method.getAnnotation(SecureEndpoint.class);

        List<String> allowedUsers = Arrays.asList(anno.allowedUsers());


        if(request.getParameter("email") == null) throw new AuthenticationException("Please log in");

        String email = request.getParameter("email");
        if(anno.isLoggedIn() == true && email == null) throw new AuthenticationException("Please log in before requesting this endpoint");
        if(!allowedUsers.isEmpty() && !allowedUsers.contains(email)) throw new AuthenticationException("Forbidden request made to sensitive endpoint by user: " + email);


        Object returned = pjp.proceed();

        return returned;
    }

}
