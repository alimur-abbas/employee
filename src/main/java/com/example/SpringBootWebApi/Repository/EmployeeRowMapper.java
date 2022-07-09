package com.example.SpringBootWebApi.Repository;

import com.example.SpringBootWebApi.Model.Employee;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("em")
public class EmployeeRowMapper implements RowMapper<Employee> {


    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Integer id = rs.getInt("ID");
        String uid = rs.getString("UID");
        String firstName = rs.getString("FIRST_NAME");
        String lastName = rs.getString("LAST_NAME");
        Employee e = new Employee(id, uid, firstName, lastName);
        return e;
    }
}
