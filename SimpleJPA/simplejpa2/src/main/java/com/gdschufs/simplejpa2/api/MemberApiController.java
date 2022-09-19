package com.gdschufs.simplejpa2.api;

import com.gdschufs.simplejpa2.domain.Address;
import com.gdschufs.simplejpa2.domain.Member;
import com.gdschufs.simplejpa2.dto.MemberDtos.* ;
import com.gdschufs.simplejpa2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class MemberApiController {
    private final MemberService memberService;

    @PostMapping(value="/api/member" , produces = "application/json;charset=UTF-8")
    public MemberResultResponse memberpost(@RequestBody MemberPostRequest form) {


        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        Member member = new Member();
        member.setM_name(form.getM_name());
        member.setAddress(address);
        memberService.join(member);

        MemberPostResponse memberPostResponse = new MemberPostResponse(member);
        return new MemberResultResponse("this is my first spring",200,memberPostResponse);
    }
    @GetMapping(value="/api/members" , produces = "application/json;charset=UTF-8")
    public MemberResultResponse membersGet() {
        List<Member> findMembers = memberService.findMembers();
        List<MemberDto> collect = findMembers.stream().map(m -> new MemberDto(m,m.getAddress())).collect(Collectors.toList());
        return new MemberResultResponse("this is my first spring",200,collect);
    }
}
