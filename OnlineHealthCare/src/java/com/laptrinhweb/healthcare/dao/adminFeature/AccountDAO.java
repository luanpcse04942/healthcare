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
        StringBuilder sql = new StringBuilder("SELECT * FROM [User] where roleId not like 4");
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
                int roleId = rs.getInt("roleId");
                acc.setRoleId(rs.getInt("roleId"));
                switch (roleId) {
                    case 1:
                        acc.setRoleName("Admin");
                        break;
                    case 2:
                        acc.setRoleName("Bác sĩ");
                        break;
                    case 3:
                        acc.setRoleName("Bệnh nhân");
                        break;
                    default:
                        break;
                }
                acc.setFirstName(rs.getString("firstName"));
                acc.setLastName(rs.getString("lastName"));
                acc.setEmail(rs.getString("email"));
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
    
    public Account getAccountDetail(int userId) {
        String sql = "SELECT * FROM [User] where userId = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Account acc = new Account();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                acc.setId(rs.getInt("userId"));
                int roleId = rs.getInt("roleId");
                acc.setRoleId(rs.getInt("roleId"));
                switch (roleId) {
                    case 1:
                        acc.setRoleName("Admin");
                        break;
                    case 2:
                        acc.setRoleName("Bác sĩ");
                        break;
                    case 3:
                        acc.setRoleName("Bệnh nhân");
                        break;
                    default:
                        break;
                }
                acc.setFirstName(rs.getString("firstName"));
                acc.setLastName(rs.getString("lastName"));
                acc.setEmail(rs.getString("email"));
                acc.setGender(rs.getString("gender"));
                acc.setPhoneNumber(rs.getString("phoneNumber"));
                acc.setAddress(rs.getString("address"));
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
        return acc;
    }
    
    public ArrayList<Account> searchByNameOrEmail(String search) {
        String sql = "SELECT * FROM [User] where (email like ? or lastName like ?) and roleId not like 4";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Account> listAccount = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, '%' + search.trim() + '%');
            ps.setString(2, '%' + search.trim() + '%');
            rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account();
                acc.setId(rs.getInt("userId"));
                int roleId = rs.getInt("roleId");
                acc.setRoleId(rs.getInt("roleId"));
                switch (roleId) {
                    case 1:
                        acc.setRoleName("Admin");
                        break;
                    case 2:
                        acc.setRoleName("Bác sĩ");
                        break;
                    case 3:
                        acc.setRoleName("Bệnh nhân");
                        break;
                    default:
                        break;
                }
                acc.setFirstName(rs.getString("firstName"));
                acc.setLastName(rs.getString("lastName"));
                acc.setEmail(rs.getString("email"));
                acc.setGender(rs.getString("gender"));
                acc.setPhoneNumber(rs.getString("phoneNumber"));
                acc.setAddress(rs.getString("address"));
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