package com.gdschufs.simplejpa.api;

import com.gdschufs.simplejpa.domain.Member;
import com.gdschufs.simplejpa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.gdschufs.simplejpa.dto.MemberDtos.*;

@RequiredArgsConstructor
@RestController
public class MemberApiController {
    private final MemberService memberService;
    // 생성
    @PostMapping(value="/api/member" , produces = "application/json;charset=UTF-8")
    public MemberResultResponse memberPost(@RequestBody MemberPostRequest request) {
        memberService.postMember(request.getM_name(), request.getM_email(), request.getM_password());
         MemberPostResponse memberPostResponse = new MemberPostResponse(request.getM_name(), request.getM_email(), request.getM_password());
        return new MemberResultResponse("생성 완료",200,memberPostResponse);
    }
    // 삭제
    @DeleteMapping(value="/api/member" , produces = "application/json;charset=UTF-8")
    public MemberMessageResponse memberDelete(@RequestBody MemberIdRequest request) {
        memberService.deleteMember(request.getId());
        return new MemberMessageResponse("삭제 완료",200);
    }
    // 단일조회
    @GetMapping(value="/api/member" , produces = "application/json;charset=UTF-8")
    public MemberResultResponse memberGetOne(@Param("memberId") Long memberId) // param("~") 과 맞춰 줘야함
    {
        try{
            Member member = memberService.findOneByid(memberId);
            return new MemberResultResponse("호출 성공",200,member);}
        catch (NullPointerException e)
        {
            return new MemberResultResponse("no result",400,null);
        }
    }


    // 전체조회
    @GetMapping(value="/api/memberall" , produces = "application/json;charset=UTF-8")
    public MemberResultResponse memberGetAll()
    {
        List<Member> findMembers = memberService.findALL();
        List<MemberDto> collect = findMembers.stream().map(m -> new MemberDto(m)).collect(Collectors.toList());
        return new MemberResultResponse("호출 성공",200,collect);
    }





}
