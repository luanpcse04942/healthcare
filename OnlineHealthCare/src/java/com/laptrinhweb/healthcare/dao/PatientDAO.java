package com.laptrinhweb.healthcare.dao;

import com.laptrinhweb.healthcare.context.DBContext;
import com.laptrinhweb.healthcare.model.Time;
import com.laptrinhweb.healthcare.model.User;
import java.sql.Date;
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

    public List<User> getListPatient(int id) {
        String sql = "select u.id, firstName, lastName, email, gender, phoneNumber, address \n"
                + "from Users u, User_Profile up, Appointment a\n"
                + "where up.userId = u.id \n"
                + "and a.statusId = 3 \n"
                + "and a.userId = u.id \n"
                + "and doctorWorkingInfoId = " + id;
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
                acc.setFirstName(rs.getNString(2));
                acc.setLastName(rs.getNString(3));
                acc.setEmail(rs.getNString(4));
                acc.setGender(rs.getNString(5));
                acc.setPhoneNumber(rs.getString(6));
                acc.setAddress(rs.getNString(7));
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

    public Date getAppDate(int id) {
        String sql = "select select bookingDate\n"
                + "from Appointment\n"
                + "where  userId = " + id;
        PreparedStatement ps;
        ResultSet rs;
        DBContext db = new DBContext();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs.getDate(1);
        } catch (SQLException e) {
        }
        return null;
    }
}
