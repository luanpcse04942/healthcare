package com.laptrinhweb.healthcare.dao;

import com.laptrinhweb.healthcare.context.DBContext;
import com.laptrinhweb.healthcare.model.Handbook;
import com.laptrinhweb.healthcare.model.Specialty;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LuanPC
 */
public class HandbookDAO extends DBContext{
    
        public ArrayList<Handbook> findAll(int start, int total) {
        String sql = "  select a.handBookId,a.adminId,a.name,a.publishAt,a.image,a.content,CONCAT(b.firstName , ' ', b.lastName) nameAdmin from Handbooks a join Users b on b.id = a.adminId  ORDER BY a.handBookId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<Handbook> listHandbook = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, total);
            rs = ps.executeQuery();
            while (rs.next()) {
                Handbook acc = new Handbook();
                acc.setId(rs.getInt("handBookId"));
                acc.setAdminId(rs.getInt("adminId"));
                acc.setHandbookName(rs.getString("name"));
                acc.setPublishedAt(rs.getDate("publishAt"));
                String base64StringImage = new String(rs.getBytes("image"), "UTF-8");
                acc.setImage(base64StringImage);
                acc.setContent(rs.getString("content"));
                acc.setFullName(rs.getString("nameAdmin"));
                listHandbook.add(acc);
            }
        } catch (Exception e) {
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
        return listHandbook;
    }
        
    public Handbook getHanbookDetail(int handbookId) {
        String sql = "select a.handBookId,a.adminId,a.name,a.publishAt,a.image,a.content,CONCAT(b.firstName , ' ', b.lastName) nameAdmin from Handbooks a join Users b on b.id = a.adminId where a.handBookId = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        Handbook handbook = new Handbook();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, handbookId);
            rs = ps.executeQuery();
            while (rs.next()) {
                handbook.setId(rs.getInt("handBookId"));
                handbook.setAdminId(rs.getInt("adminId"));
                handbook.setHandbookName(rs.getString("name"));
                handbook.setPublishedAt(rs.getDate("publishAt"));
                String base64StringImage = new String(rs.getBytes("image"), "UTF-8");
                handbook.setImage(base64StringImage);
                handbook.setContent(rs.getString("content"));
                handbook.setFullName(rs.getString("nameAdmin"));
            }
        } catch (Exception e) {
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
        return handbook;
    }    
    
public boolean addSpecialty(String name, byte[] fileName, String content) {
        boolean addSpecSuccess = false;
        
        String sql = "INSERT INTO Handbooks(name,adminId, publishAt, image, content) VALUES (?, 1, GETDATE(), ?, ?)";
        
        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setBytes(2, fileName);
            ps.setString(3, content);
            ps.executeUpdate();
            addSpecSuccess = true;
        } catch (SQLException e) {
            e.printStackTrace();
            addSpecSuccess = false;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HandbookDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HandbookDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HandbookDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return addSpecSuccess;
    }    

    public boolean updateHandbook(int id, String name, String description, byte[] fileName) {
        boolean editSpecSuccess = false;
        
        String sql = "UPDATE handbooks SET name = ?, content = ?, image = ? where handBookId = ?";
        
        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setBytes(3, fileName);
            ps.setInt(4, id);
            ps.executeUpdate();
            editSpecSuccess = true;
        } catch (SQLException e) {
            e.printStackTrace();
            editSpecSuccess = false;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HandbookDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HandbookDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HandbookDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return editSpecSuccess;
    }
    
    public int getNoOfRecordHandbook() {
        String query = "SELECT count(*) FROM Handbooks";
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
                    Logger.getLogger(HandbookDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HandbookDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HandbookDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return count;
    }
    public int getNoOfRecordSearchHandbook(String search) {
        String sql = "SELECT count(*) FROM Handbooks s where s.name like ?";
        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, '%' + search.trim() + '%');
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
                    Logger.getLogger(HandbookDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HandbookDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HandbookDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return count;
    }
    
    public ArrayList<Handbook> searchByNameHandbook(String search, int start, int total) {
        String sql = "select a.handBookId,a.adminId,a.name,a.publishAt,a.image,a.content,CONCAT(b.firstName , ' ', b.lastName) nameAdmin from Handbooks a join Users b on b.id = a.adminId where a.name like ? ORDER BY a.handBookId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        PreparedStatement ps = null;
        ResultSet rs = null;
         DBContext db = new DBContext();
        ArrayList<Handbook> listhandbook = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, '%' + search.trim() + '%');
            ps.setInt(2, start);
            ps.setInt(3, total);
            rs = ps.executeQuery();
            while (rs.next()) {
                Handbook acc = new Handbook();
                acc.setId(rs.getInt("handBookId"));
                acc.setAdminId(rs.getInt("adminId"));
                acc.setHandbookName(rs.getString("name"));
                acc.setPublishedAt(rs.getDate("publishAt"));
                String base64StringImage = new String(rs.getBytes("image"), "UTF-8");
                acc.setImage(base64StringImage);
                acc.setContent(rs.getString("content"));
                acc.setFullName(rs.getString("nameAdmin"));
                listhandbook.add(acc);
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HandbookDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HandbookDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HandbookDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listhandbook;
    }
}
