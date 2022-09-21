package com.laptrinhweb.healthcare.dao.publicFeature;

import com.laptrinhweb.healthcare.context.DBContext;
import com.laptrinhweb.healthcare.model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LuanPC
 */
public class UserDAO extends DBContext {

    public Account checkUserExist(String username, String password) {
        String sql = "select * from [User] where email = ? and password = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Account acc = new Account();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                acc.setId(rs.getInt("userId"));
                acc.setRoleId(rs.getInt("roleId"));
                acc.setFirstName(rs.getString("firstName"));
                acc.setLastName(rs.getString("lastName"));
                acc.setEmail(rs.getString("email"));
                acc.setPassword(rs.getString("password"));
                acc.setGender(rs.getString("gender"));
                acc.setPhoneNumber(rs.getString("phoneNumber"));
                acc.setAddress(rs.getString("address"));
            }
        } 
        catch (SQLException e) {
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                /* Ignored */ }
            try {
                ps.close();
            } catch (SQLException e) {
                /* Ignored */ }
            try {
                conn.close();
            } catch (SQLException e) {
                /* Ignored */ }
        }
        return acc;
    }
}
