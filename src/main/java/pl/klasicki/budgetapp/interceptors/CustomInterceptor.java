package pl.klasicki.budgetapp.interceptors;




import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class CustomInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        var handlerMethod = (HandlerMethod) handler;

        if (handlerMethod.hasMethodAnnotation(ControllerCode.class)) {

            StringBuilder sb = new StringBuilder();
            Map<String, String> params = getParams(request);

            var controllerCode = handlerMethod.getMethodAnnotation(ControllerCode.class).code();

            if (!params.isEmpty()) {
                sb.append("parameters={").append(params).append("} ");
            }

            log.info("controller code: {}", controllerCode);
            log.info("request: {}", request.getRequestURL());
            log.info("method: {}", request.getMethod());
            log.info("responseCode: {}", response.getStatus());
            log.info("params: {}", params.toString());
        }
    }

    private Map<String, String> getParams(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration<?> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String key = (String) params.nextElement();
            String value = request.getParameter(key);
            map.put(key, value);
        }
        return map;
    }

}
