package com.laptrinhweb.healthcare.dao;

import com.laptrinhweb.healthcare.context.DBContext;
import com.laptrinhweb.healthcare.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LuanPC
 */
public class UserDAO extends DBContext {
    
     public User checkUserExist(String username, String password) {
        String sql = "select * from [User] where email = ? and password = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        User acc = new User();
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
     
    public ArrayList<User> findAll(int start, int total) {
        String sql = "SELECT * FROM [User] where roleId not like 4 ORDER BY userId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<User> listAccount = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, total);
            rs = ps.executeQuery();
            while (rs.next()) {
                User acc = new User();
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

    public int getNoOfRecordAccounts() {
        String query = "SELECT count(*) FROM [User] where roleId not like 4";
        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return count;
    }

    public User getAccountDetail(int userId) {
        String sql = "SELECT * FROM [User] where userId = ?";
        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        User acc = new User();
        try {
            conn = db.getConn();
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
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return acc;
    }

    public ArrayList<User> searchByNameOrEmail(String search, int start, int total) {
        String sql = "SELECT * FROM [User] where (email like ? or lastName like ?) and roleId not like 4 ORDER BY userId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> listAccount = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, '%' + search.trim() + '%');
            ps.setString(2, '%' + search.trim() + '%');
            ps.setInt(3, start);
            ps.setInt(4, total);
            rs = ps.executeQuery();
            while (rs.next()) {
                User acc = new User();
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
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listAccount;
    }

    public int getNoOfRecordSearchAccounts(String search) {
        String query = "SELECT COUNT(*) FROM [User] WHERE 1 = 1 and (email like ? or lastName like ?) and roleId not like 4";
        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(query);
            ps.setString(1, '%' + search.trim() + '%');
            ps.setString(2, '%' + search.trim() + '%');
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return count;
    }
}