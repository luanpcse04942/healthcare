package com.laptrinhweb.healthcare.dao;

import com.laptrinhweb.healthcare.context.DBContext;
import com.laptrinhweb.healthcare.model.Province;
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
        StringBuilder sql = new StringBuilder("select u.id, u.firstName, u.lastName, u.email, u.password, u.onlineStatus, u.activedStatus, ");
        sql.append(" up.gender, up.phoneNumber, up.address, up.image, r.id, r.roleName from Users u ");
        sql.append(" join  User_Profile up on u.id = up.id ");
        sql.append(" join User_Roles ur on ur.userId = u.id ");
        sql.append(" join Roles r on ur.roleId = r.id ");
        sql.append(" where u.email = ? and u.password = ?");
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        User acc = new User();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
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
        return acc;
    }

    public ArrayList<User> findAll(int start, int total) {
        StringBuilder sql = new StringBuilder("select u.id, u.firstName, u.lastName, u.email, u.password,  u.onlineStatus, u.activedStatus, ");
        sql.append(" up.gender, up.phoneNumber, up.address, up.image, r.id, r.roleName from Users u ");
        sql.append(" join  User_Profile up on u.id = up.id ");
        sql.append(" join User_Roles ur on ur.userId = u.id ");
        sql.append(" join Roles r on ur.roleId = r.id ");
        sql.append(" where ur.roleId not like 4 ORDER BY u.id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<User> listAccount = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, start);
            ps.setInt(2, total);
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

    public int getNoOfRecordAccounts() {
        String query = "SELECT count(*) FROM Users u join User_Roles ur on u.id = ur.userId where ur.roleId not like 4";
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
        StringBuilder sql = new StringBuilder("select u.id, u.firstName, u.lastName, u.email, u.password, u.onlineStatus, u.activedStatus, ");
        sql.append(" up.gender, up.phoneNumber, up.address, up.image, r.id, r.roleName from Users u ");
        sql.append(" join  User_Profile up on u.id = up.id ");
        sql.append(" join User_Roles ur on ur.userId = u.id ");
        sql.append(" join Roles r on ur.roleId = r.id ");
        sql.append(" where u.id = ?");
        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        User acc = new User();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
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
        StringBuilder sql = new StringBuilder("select distinct u.id, u.firstName, u.lastName, u.email, u.password, u.onlineStatus, u.activedStatus, ");
        sql.append(" up.gender, up.phoneNumber, up.address, up.image, r.id, r.roleName from Users u ");
        sql.append(" join  User_Profile up on u.id = up.userId ");
        sql.append(" join User_Roles ur on ur.userId = u.id ");
        sql.append(" join Roles r on ur.roleId = r.id ");
        sql.append(" where (u.email like ? or convert(VARCHAR(255), u.firstName)+' '+convert(VARCHAR(255), u.lastName) like ?) and ur.roleId not like 4 ORDER BY u.id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<User> listAccount = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
            ps.setString(1, '%' + search.trim() + '%');
            ps.setString(2, '%' + search.trim() + '%');
            ps.setInt(3, start);
            ps.setInt(4, total);
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
     public ArrayList<Province> getAllProvinces() {
        String sql = "SELECT * FROM Provinces";
        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Province> proList = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Province pro = new Province();
                pro.setId(rs.getInt(1));
                pro.setName(rs.getString(2));
                proList.add(pro);
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
        return proList;
    }
     
    public int getNoOfRecordSearchAccounts(String search) {
        StringBuilder sql = new StringBuilder("SELECT count(*) FROM Users u join User_Roles ur on u.id = ur.userId ");
        sql.append(" join (select t.id ,CONCAT(t.[firstName],' ',t.[lastName]) as name from Users t) n ");
        sql.append(" on n.id = u.id and (u.email like ? or n.name like ?) and ur.roleId not like 4");
        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
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

    public boolean addUser(String email, String password, String firstName, String lastName) {
        String sql = "INSERT INTO Users(firstName, lastName, email, password, activedStatus) VALUES (?, ?, ?, ?, ?)";

        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean addSuccess = false;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setInt(5, 5);
            ps.executeUpdate();
            addSuccess = true;
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
        return addSuccess;
    }

    public void addUserProfile(int userId, String imageName) {
        String sql = "INSERT INTO User_Profile(userId, image) VALUES (?, ?)";

        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setString(2, imageName);
            ps.executeUpdate();
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
    }

    public int getUserId(String email) {
        String sql = "SELECT id from Users where email = ? ";

        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = 0;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
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
        return id;
    }

    public void addUserRole(int userId, int roleId) {
        String sql = "INSERT INTO User_Roles(userId, roleId) VALUES (?, ?)";

        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, roleId);
            ps.executeUpdate();
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
    }

    public void addMedicalFacilityInfo(int medicalFacilityId) {
        String sql = "INSERT INTO MedicalFacilityInfo(medicalFacilityId) VALUES (?)";

        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, medicalFacilityId);
            ps.executeUpdate();
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
    }
    public ArrayList<User> findAllDoctor(int start, int total) {
        String sql = "select * from Users a join User_Roles b on b.userId = a.id join Roles c on c.id = b.roleId join User_Profile d on d.userId = a.id where c.id = 2 ORDER BY a.id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<User> listUser = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, total);
            rs = ps.executeQuery();
            while (rs.next()) {
                User acc = new User();
                acc.setId(rs.getInt("id"));
                acc.setRoleId(rs.getInt("roleId"));
                acc.setFirstName(rs.getString("firstName"));
                acc.setLastName(rs.getString("lastName"));
                acc.setEmail(rs.getString("email"));
                acc.setGender(rs.getString("gender"));
                acc.setPhoneNumber(rs.getString("phoneNumber"));
                acc.setAddress(rs.getString("address"));
                acc.setImages(rs.getString("image"));
                listUser.add(acc);
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
        return listUser;
    }

    public void addUserProvince(int userId, int provinceId) {
         String sql = "INSERT INTO User_Province(userId, provinceId) VALUES (?, ?)";

        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, provinceId);
            ps.executeUpdate();
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
    }

}
