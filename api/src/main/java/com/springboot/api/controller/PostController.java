package com.springboot.api.controller;


import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample(){
        return "Hello Post API";
    }

    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map-> {
            sb.append(map.getKey() + ":" + map.getValue()+"\n");
        });

        return sb.toString();
    }

    //map 객체는 어떤값이 들어올지 모를때 주로 사용

    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }

    //요청값에 값이 정해져있다면 DTO 객체를 매개변수삼아 작성하면 됨
    //위 처럼 작성시 멤버변수를 요청메시지의 키와 매핑해서 값을 가져오게 됨
}
