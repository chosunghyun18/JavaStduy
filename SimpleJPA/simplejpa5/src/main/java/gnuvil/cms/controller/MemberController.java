package gnuvil.cms.controller;

import gnuvil.cms.domain.Member;
import gnuvil.cms.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    public void getMember(){

    }
}
