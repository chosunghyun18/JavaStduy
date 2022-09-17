package com.gdschufs.simplejpa.api;

import com.gdschufs.simplejpa.dto.MemberDto;
import com.gdschufs.simplejpa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.gdschufs.simplejpa.dto.MemberDto.*;

@RequiredArgsConstructor
@RestController
public class MemberApiController {
    private final MemberService memberService;

    @PostMapping(value="/api/member" , produces = "application/json;charset=UTF-8")
    public MemberResultResponse memberpost(@RequestBody MemberPostRequest request) {
        memberService.postMember(request.getM_name(), request.getM_email(), request.getM_password());
         MemberPostResponse memberPostResponse = new MemberPostResponse(request.getM_name(), request.getM_email(), request.getM_password());
        return new MemberResultResponse("this is my first spring",200,memberPostResponse);
    }

}
