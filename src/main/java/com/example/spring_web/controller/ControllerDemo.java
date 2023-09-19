package com.example.spring_web.controller;

import com.example.spring_web.validator.CalcValidator;
import com.example.spring_web.form.CalcForm;
import com.example.spring_web.repository.MemberRepository;
import com.example.spring_web.table.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ControllerDemo {

    private final CalcValidator calcValidator;

    private final MemberRepository memberRepository;



    @InitBinder("calcForm") // 유효성 검사를 진행할 메소드를 지정해준다. validate()메서드를 호출하지 않아도 최초로 호출되어 데이터를 검증함.  value = 검사할 클래스(객체)
    public void initBinder(WebDataBinder webDataBinder) { // WebDataBinder 클래스가 유효성검사를 진행할 메소드를 추가할 수 있다.
        webDataBinder.addValidators(calcValidator);
    }

    @GetMapping("/index")
    public String showIndex() {


        return "index";
    }

    @GetMapping("/home")
    public String showHome(Model model) {
        List<Member> nameList = memberRepository.findAll();
        model.addAttribute("nameList", nameList);

        return "home";
    }
//
//    @GetMapping("/getNameAll")
//    public String getNameAll(Model model) {
//        List<Member> nameList = tableRepository.findAll();
//        model.addAttribute("nameList", nameList);
//
//        return "home";
//    }

    @GetMapping("/function/{no}")
    public String selectFunction(@PathVariable Integer no) {
        String view = null;
        switch (no) {
            case 1:
                view = "pathVariable/function1";
                break;
            case 2:
                view = "pathVariable/function2";
                break;
            case 3:
                view = "pathVariable/function3";
                break;
        }
        return view;
    }

    @PostMapping(value = "send", params = "a")
    public String showAView() {
        return "submit/a";
    }

    @PostMapping(value = "send", params = "b")
    public String showBView() {
        return "submit/b";
    }

    @PostMapping(value = "send", params = "c")
    public String showCView() {
        return "submit/c";
    }

    // entry.html에서 사용
    @ModelAttribute
    public CalcForm setUpForm() {
        return new CalcForm();
    }

    @GetMapping("show")
    public String showShow() {
        return "calc/entry";
    }

    @PostMapping("calc")
    public String confirmView(@Validated CalcForm form, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "calc/entry";
        }
        Integer result = form.getLeftNum() + form.getRightNum();

        model.addAttribute("result", result);

        return "calc/confirm";
    }
}
