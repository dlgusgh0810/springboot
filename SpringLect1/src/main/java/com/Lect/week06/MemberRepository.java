package com.Lect.week06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.List;
import java.util.Map;

@Repository
public class  MemberRepository {
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
    public PreparedStatementCreator createPreparedStatement(Member member, String sql, String[] args){
        return new PreparedStatementCreator(){

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pstmt = con.prepareStatement(sql, args);
                pstmt.setString(1, member.getEmail());
                pstmt.setString(2, member.getPassword());
                pstmt.setString(3, member.getName());
                pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
                return pstmt;
            }

        };
    }
    public long insertMember(Member member, String sql){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator pstmtObj = createPreparedStatement(member, sql, new String[] {"ID"});
        jdbcTemplate.update(pstmtObj, keyHolder);
        Number keyValue = keyHolder.getKey();
        return keyValue.longValue();
    }
    @Transactional(rollbackFor = SQLSyntaxErrorException.class)
    public void changePassword(Member member, String newPasswd) {
        String sql = "insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE) values (?, ?, ?, ?)";
        insertMember(member, sql);
        sql = "update MEMBER set NAME = ?, PASSWORD = ? where EMAI = ?";
        Object[] args1 = {member.getName(), newPasswd, member.getEmail()};
        updateMember(sql, args1);
    }
}
