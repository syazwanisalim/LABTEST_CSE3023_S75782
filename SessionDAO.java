/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.model.SessionBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MP2-4
 */
public class SessionDAO {


    private String jdbcURL ="jdbc:mysql://localhost:3306/drivesmart_db";

    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

   
    public Connection getConnection() {

        Connection conn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    
    public void bookSession(SessionBean session) {

        String sql =
        "INSERT INTO Training_Sessions(student_name,branch_location,lesson_type,status) VALUES(?,?,?,?)";

        try {

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,session.getStudent_name());
            ps.setString(2,session.getBranch_location());
            ps.setString(3,session.getLesson_type());
            ps.setString(4,session.getStatus());
            ps.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
   public List<SessionBean> getAllSessions() {
    List<SessionBean> list = new ArrayList<>();
    String sql = "SELECT * FROM Training_Sessions ORDER BY branch_location ASC";

    try (Connection conn = getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            SessionBean s = new SessionBean();
            s.setSession_id(rs.getInt("session_id"));
            s.setStudent_name(rs.getString("student_name"));
            s.setBranch_location(rs.getString("branch_location"));
            s.setLesson_type(rs.getString("lesson_type"));
            s.setStatus(rs.getString("status"));
            list.add(s);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}

}