package com.Lect.week06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class MemberRepository {
    @Autowired
    private final JdbcTemplate jdbcTemplate = null;

    public List<Member> selectAll(String sql){
        List<Member> results = jdbcTemplate.query(sql ,
                new RowMapper<Member>() {

                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member(
                                rs.getString("EMAIL"),
                                rs.getString("PASSWORD"),
                                rs.getString("NAME"),
                                rs.getTimestamp("REGDATE").toLocalDateTime()
                        );
                        member.setId(rs.getLong("ID"));
                        return member;
                    }
                }

        );
        return results;
    }
    public List<Member> selectAllUsingParameter(String sql, Object[] args){
        List<Member> results = jdbcTemplate.query(sql, args, new MemberRowMapper());
        return results;
    }

    public List<Map<String, Object>> selectListMap(String sql, String email){
        return  jdbcTemplate.queryForList(sql, email);
    }
    public void updateMember(String sql, Object[] args){
        int cnt = jdbcTemplate.update(sql, args);
    }
}
