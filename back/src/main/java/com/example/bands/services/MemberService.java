package com.example.bands.services;

import com.example.bands.data.BandDAO;
import com.example.bands.data.MemberDAO;
import com.example.bands.models.Band;
import com.example.bands.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberDAO memberRepository;

    @Autowired
    public MemberService(MemberDAO memberRepository){
        this.memberRepository = memberRepository;
    }

    public List<Member> getAll(){
        return memberRepository.getAll();
    }

    public void add(Member member){
        memberRepository.save(member);
    }

    public void delete(int id){
        memberRepository.deleteById(id);
    }

    public void update(Member member){
        memberRepository.update(member);
    }

    public List<Member> getAll(int id){
        return memberRepository.getAllById(id);
    }
}
