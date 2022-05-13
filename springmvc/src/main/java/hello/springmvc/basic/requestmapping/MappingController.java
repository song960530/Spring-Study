package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MappingController {

    @RequestMapping(value = "/hello-basic-v1", method = RequestMethod.GET)
    public String helloV1() {
        log.info("hello-basic-v1");

        return "ok";
    }

    @GetMapping("hello-basic-v2")
    public String helloV2() {
        log.info("hello-basic-v2");

        return "ok";
    }

    /**
     * PathVariable (경로변수)
     * <p>
     * 변수 명이 같으면 생략 가능
     * ex) @PathVariable("userId") String userId -> @PathVariable String userId
     */
    @GetMapping("/mapping/{userId}")
    public String helloV2(@PathVariable String userId) {
        log.info("userId: {}", userId);

        return "ok";
    }
}
