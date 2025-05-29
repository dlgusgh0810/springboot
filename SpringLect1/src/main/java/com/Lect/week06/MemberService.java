package com.Lect.week06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

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
    public List<Member> getBatchUpdateArray(){
        String sql = "insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE) values (?, ?, ?, ?)";
        List<Object[]> memberData = Arrays.asList(
                new Object[]{"john@example.com", "2456", "John", LocalDateTime.now()},
                new Object[]{"jane@example.com", "34567", "Jane", LocalDateTime.now()},
                new Object[]{"mike@example.com", "4567", "Mike", LocalDateTime.now()}
        );
        memberRepos.batchInsertMember(sql, memberData);
        return getMembers();
    }
    public List<Member> getBatchUpdateSetter(){
        String sql = "insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE) values (?, ?, ?, ?)";
        List<Member> memberData = Arrays.asList(
                new Member("john@Setter.com", "2456", "JohnSetter", LocalDateTime.now()),
                new Member("jane@Setter.com", "34567", "JaneSetter", LocalDateTime.now()),
                new Member("mike@Seter.com", "4567", "MikeSetter", LocalDateTime.now())
        );
        memberRepos.batchInsertMembersSetter(sql, memberData);
        return getMembers();
    }
    public List<Member> getKeyHolder(){
        String sql = "insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE) values (?, ?, ?, ?)";
        Member member = new Member("virus1@virus.com", "3456", "홍길동", LocalDateTime.now());
        long keyHolder = memberRepos.insertMember(member, sql);
        System.out.println("자동 생성된 키 값 : "+keyHolder);
        return  getMembers();
    }
    public List<Member> transactionProcess(){
        try{
            Member member = new Member("홍길동@virus.com" ,"1234","홍길동", LocalDateTime.now());
            memberRepos.changePassword(member, "5678");
        } catch (Exception e){
            System.out.println("Transaction rolled back: " + e.getMessage());

        }
        String sql = "select * from MEMBER";
        return memberRepos.selectAll(sql);
    }
}
