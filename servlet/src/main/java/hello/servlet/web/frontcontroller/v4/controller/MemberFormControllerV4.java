package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        System.out.println("프론트 컨트롤러V4 통해서 접근 성공");
        model.put("param", "param22222");
        return "new-form";
    }
}
