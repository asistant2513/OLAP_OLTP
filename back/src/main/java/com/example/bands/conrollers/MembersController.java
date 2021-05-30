package com.example.bands.conrollers;

import com.example.bands.models.Member;
import com.example.bands.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MembersController {

    private final MemberService memberService;

    @Autowired
    public MembersController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/{id}")
    public List<Member> getAll(@PathVariable int id){
        return memberService.getAll(id);
    }

    @PostMapping("/{id}/add")
    public void addBand(@RequestBody Member member, @PathVariable("id") int bandId){
        member.setBandId(bandId);
        System.out.println(member.toString());
        memberService.add(member);
    }

    @DeleteMapping("/delete/{id}")
    public void remBand(@PathVariable int id){
        System.out.println("Deleting " + id);
        memberService.delete(id);
    }

    @PutMapping("/update")
    public void updateBand(@RequestBody Member member){
        System.out.println("editing\n" + member);
        memberService.update(member);
    }
}
