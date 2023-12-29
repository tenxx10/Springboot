package com.springboot.api.controller;


import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController   //@Controller와 @ResponseBody 합친 효과를 냄
@RequestMapping("/api/v1/put-api")   //처리하는 모든 요청은 "/api/v1/put-api" 경로로 시작할 것
public class PutController {

    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map-> {
            sb.append(map.getKey()+":"+map.getValue()+"\n");
        });
        return sb.toString();
    }

    @PutMapping(value = "/member1")
    public String postMemberDto1(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }

    //리턴값이 String -> 문자열로 전달됨

    @PutMapping(value = "/member2")
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto) {
        return memberDto;
    }

    //리턴값이 DTO객체 타입  -> ResponseBody는 자동으로 값을 JSON형식으로 변환해서 전달
}


