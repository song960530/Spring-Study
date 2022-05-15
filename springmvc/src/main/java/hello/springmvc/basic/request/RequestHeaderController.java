package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class RequestHeaderController {

    @RequestMapping("/headers")
    public String header(
            HttpServletRequest request
            , HttpServletResponse response
            , HttpMethod method
            , Local local
            , @RequestHeader MultiValueMap<String, String> headerMap
            , @RequestHeader("host") String host
            , @CookieValue(value = "myCookie", required = false) String cookie
    ) {
        log.info("request: {}", request);
        log.info("response: {}", response);
        log.info("method: {}", method);
        log.info("local: {}", local);
        log.info("headerMap: {}", headerMap);
        log.info("host: {}", host);
        log.info("cookie: {}", cookie);

        return "ok";
    }
}
