package top.yms.server.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.yms.server.utils.InetAddressUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;

@Aspect
@Component
public class OperatorLog {
    private final Logger LOGGER = LoggerFactory.getLogger(OperatorLog.class);

    @Pointcut("within(top.yms.server.controller.blog.InfoController)")
    private void pointCutMethod() {}

    @Before("pointCutMethod()")
    public void beforeCall()  {
        recordAccess();
    }
    public void recordAccess() {
        Date accessDate = new Date();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String remoteIp = InetAddressUtils.getClientIpAddr(request);
        LOGGER.info("recordAccess(INFO): 当前来访ip[ "+remoteIp+" ], 日期: [ "+accessDate+" ]");
    }

    @After("pointCutMethod()")
    public void afterCall() {
        System.out.println("After call");
    }

    @AfterReturning("pointCutMethod()")
    public void afterReturn() {
        System.out.println("After Return");
    }

    @AfterThrowing("pointCutMethod()")
    public void throwExce(){
        System.out.println("AfterThrowExceptoin");
    }

    @Around("pointCutMethod()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("beforeAround");
        Object obj = pjp.proceed();
        System.out.println("afterAround");
        return obj;
        //return new HashMap<String, Object>() {{put("sucess",obj);}};
    }
}
