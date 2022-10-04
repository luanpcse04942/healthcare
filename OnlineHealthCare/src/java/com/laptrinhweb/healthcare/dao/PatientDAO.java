package com.laptrinhweb.healthcare.dao;

import com.laptrinhweb.healthcare.context.DBContext;
import com.laptrinhweb.healthcare.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LuanPC
 */
public class PatientDAO extends DBContext {
    public List<User> getListPatient() {
        String sql = "select distinct u.id, firstName, lastName,  gender, phoneNumber, timeId from Users u, "
                + "User_Profile up, Appointment a\n" +
                "where a.statusId = 3 and a.userId = u.id";
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<User> listAccount = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                User acc = new User();
                acc.setId(rs.getInt(1));
                acc.setFirstName(rs.getString(2));
                acc.setLastName(rs.getString(3));
                acc.setEmail(rs.getString(4));
                acc.setPassword(rs.getString(5));
                acc.setOnlineStatus(rs.getBoolean(6));
                acc.setActivedStatus(rs.getBoolean(7));
                acc.setGender(rs.getString(8));
                acc.setPhoneNumber(rs.getString(9));
                acc.setAddress(rs.getString(10));
                acc.setImages(rs.getString(11));
                acc.setRoleId(rs.getInt(12));
                acc.setRoleName(rs.getString(13));
                listAccount.add(acc);
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
            }
        }
        return listAccount;
    }
}
