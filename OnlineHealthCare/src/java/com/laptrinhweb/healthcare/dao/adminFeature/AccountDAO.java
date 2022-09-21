package com.laptrinhweb.healthcare.dao.adminFeature;

import com.laptrinhweb.healthcare.context.DBContext;
import com.laptrinhweb.healthcare.model.Account;
import com.laptrinhweb.healthcare.paging.Pageble;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author LuanPC
 */
public class AccountDAO extends DBContext {

    public ArrayList<Account> findAll(Pageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT * FROM [User]");
        if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
            sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + "");
        }
        if (pageble.getOffset() != null && pageble.getLimit() != null) {
            sql.append(" OFFSET " + pageble.getOffset() + " ROWS FETCH NEXT " + pageble.getLimit() + " ROWS ONLY");
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Account> listAccount = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account();
                acc.setId(rs.getInt("userId"));
                acc.setRoleId(rs.getInt("roleId"));
                acc.setFirstName(rs.getString("firstName"));
                acc.setLastName(rs.getString("lastName"));
                acc.setEmail(rs.getString("email"));
                acc.setPassword(rs.getString("password"));
                acc.setGender(rs.getString("gender"));
                acc.setPhoneNumber(rs.getString("phoneNumber"));
                acc.setAddress(rs.getString("address"));
                listAccount.add(acc);
            }
        } catch (SQLException e) {
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
        return listAccount;
    }

    public int getTotalItem() {
        String sql = "SELECT count(*) FROM [User]";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            int count = 0;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            return 0;
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
                return 0;
            }
        }
    }
}