package com.exam.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
  @RequestMapping("/sbb")
  @ResponseBody
  public String index(){
    return "안녕하세요.asdasd";
  }
  @GetMapping("/page1")
  @ResponseBody
  public String showGet(){
    return """
        <form method="POST" action="/page2"/>
            <input type="number" name="age" placeholder="나이 입력" />
            <input type="submit" value="page2로 post방식으로 이동" />
        </form>
        """;
  }

  @PostMapping("/page2")
  @ResponseBody
  public String showPage2Post(@RequestParam(defaultValue = "0") int age){
    return """
        <h1>입력된 나이 : %d</h1>
        <h1>안녕하세요. POST방식으로 오신걸 환영합니다.</h1>
        """.formatted(age);
  }

  @GetMapping("/page2")
  @ResponseBody
  public String showPost(@RequestParam(defaultValue = "0") int age){
    return """
        <h1>입력된 나이 : %d</h1>
        <h1>안녕하세요. GET방식으로 오신걸 환영합니다.</h1>
        """.formatted(age);
  }
}
