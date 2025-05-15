package com.Lect.week06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepos=null;

    public List<Member> getMembers(){
        String sql = "select * from member";
        return memberRepos.selectAll(sql);
    }
}
