package com.huawei.rtn.testtool.doa;

import com.huawei.rtn.testtool.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAll() {
        return jdbcTemplate.query(
                "select id, firstName, lastName, phoneNumber, emailAddress " +
                        "from users order by lastName",
                new RowMapper<User>() {
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        User user = new User();
                        user.setId(rs.getLong(1));
                        user.setFirstName(rs.getString(2));
                        user.setLastName(rs.getString(3));
                        user.setPhoneNumber(rs.getString(4));
                        user.setEmailAddress(rs.getString(5));
                        return user;
                    }
                });
    }

    public void save(User user) {
        jdbcTemplate.update(
                "insert into users " +
                        "(firstName, lastName, phoneNumber, emailAddress) " +
                        "values (?, ?, ?, ?)",
                user.getFirstName(), user.getLastName(),
                user.getPhoneNumber(), user.getEmailAddress());
    }
}
