package com.ionbr.students;

import org.junit.*;

import java.sql.*;
import java.util.Properties;

public class TeacherJDBCTest {

    @Test
    public void testFindAll() throws SQLException {

        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "root");

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/courses", props);
            st = conn.createStatement();
            String sqlQuery = "SELECT * FROM teacher";
            rs = st.executeQuery(sqlQuery);


            while (rs.next()) {
                System.out.println("is== " + rs.getInt(1)
                        + " firstname == " + rs.getString("first_name") +
                        " lastname == " + rs.getString("last_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();


        } finally {
            if (null != conn) {
                conn.close();
            }
            if (null != st) {
                st.close();
            }
        }
        if (null != rs) {
            rs.close();
        }
    }

    @Test
    public void testUpdateTEather() throws SQLException {

        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "root");

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/courses", props);
            st = conn.createStatement();
            String sqlQuery = "UPDATE teacher SET first_name= 'Alexandru' WHERE id=1";
            int noRowUpdated = st.executeUpdate(sqlQuery);
            
            Assert.assertEquals(noRowUpdated, 1);


        } catch (SQLException e) {
            e.printStackTrace();


        } finally {
            if (null != conn) {
                conn.close();
            }
            if (null != st) {
                st.close();
            }
        }
        if (null != rs) {
            rs.close();
        }
    }
    @Test
    public void testPrepareStatement() throws SQLException{
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "root");

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            //Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/courses", props);
            String sqlQuery = "SELECT * FROM teacher WHERE first_name = ? ";
            st = conn.prepareStatement(sqlQuery);
            st.setString(1, "Alexandru");

            rs = st.executeQuery();

            while (rs.next()){
                System.out.println("Firstname == " + rs.getString("first_name"));
            }


        } catch (SQLException e) {
            e.printStackTrace();


        } finally {
            if (null != conn) {
                conn.close();
            }
            if (null != st) {
                st.close();
            }
        }
        if (null != rs) {
            rs.close();
        }
    }
    }
