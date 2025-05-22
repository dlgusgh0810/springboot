package com.Lect.week06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepos=null;

    public List<Member> getMembers(){
        String sql = "select * from member";
        return memberRepos.selectAll(sql);
    }
    public List<Member> getMembersUsingParameter(){
        String sql = "select * from MEMBER where email = ? and NAME=?";
        Object[] args = {"virus1@virus.net", "std1"};
        return memberRepos.selectAllUsingParameter(sql, args);
    }
    public List<Map<String, Member>> getMembersUsingMap (){
        String sql = "select id, name, password, regdate from MEMBER where email = ?";
        List<Map<String, Object>> rows = memberRepos.selectListMap(sql, "virus1@virus.net");
        List<Map<String, Member>> result = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            Member member = new Member(
                    null,
                    (String) row.get("PASSWORD"),
                    (String) row.get("NAME"),
                    (LocalDateTime) row.get("REGDATE")
            );
            Map<String, Member> map = new HashMap<>();
            map.put(row.get("id").toString(), member);
            result.add(map);
        }
        return result;
    }
    public List<Member> getUpdateMembers(){
        String sql = "update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?";
        Object[] args1 = {"stdVirus","2345","virus1@virus.net"};
        memberRepos.updateMember(sql,args1);

        sql = "select * from MEMBER where email = ?";
        Object[] args2 = {"virus1@virus.net"};
        return memberRepos.selectAllUsingParameter(sql, args2);
    }
}
