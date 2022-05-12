package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, Object> paramMap) {
        System.out.println("프론트 컨트롤러V3 통해서 접근 성공");
        ModelView mv = new ModelView("new-form");
        mv.getModel().put("param", "param");
        return mv;
    }
}
