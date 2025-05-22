package com.Lect.week06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
    public void batchInsertMember(String sql, List<Object[]> memberData){
        jdbcTemplate.batchUpdate(sql, memberData);
    }
    public void batchInsertMembersSetter(String sql, List<Member> memberData){
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Member member = memberData.get(i);
                ps.setString(1, member.getEmail());
                ps.setString(2, member.getPassword());
                ps.setString(3, member.getName());
                ps.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
            }

            @Override
            public int getBatchSize() {
                return memberData.size();
            }
        });
    }
}
