package com.springboot.api.controller;


import com.springboot.api.dto.MemberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName(){
        LOGGER.info("getName 메서드가 호출되었습니다.");
        return "Flature";
    }

//    @GetMapping(value = "/variable1/{variable}")
//    public String getVariable1(@PathVariable String variable) {
//        Logger.info("@PathVariable을 통해 들어온 값 : {} ", variable);
//        return variable;
//    }

    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDto memberDto) {
        return memberDto.toString();
        //return memberDto.getName() + "" + memberDto.getEmail() ... 같은 긴 쿼리를 toString()으로 줄임
    }
}
