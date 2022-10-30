package com.laptrinhweb.healthcare.dao;

import com.laptrinhweb.healthcare.context.DBContext;
import com.laptrinhweb.healthcare.model.Specialty;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpecialtyDAO extends DBContext {

    public ArrayList<Specialty> getAllSpecialty() {
        String sql = "select TOP 4 * from Specialties ORDER BY specialtyId";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Specialty> listSpecialty = new ArrayList<Specialty>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Specialty spec = new Specialty();
                spec.setId(rs.getInt("specialtyId"));
                spec.setName(rs.getString("name"));
                spec.setDescription(rs.getString("description"));
                String base64StringImage = new String(rs.getBytes("image"), "UTF-8");
                spec.setImage(base64StringImage);
                listSpecialty.add(spec);
            }
        } catch (Exception e) {
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                ps.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                conn.close();
            } catch (Exception e) {
                /* Ignored */ }
        }
        return listSpecialty;
    }

    public ArrayList<Specialty> getAllSpecialtyPublic(int start, int total) {
        String sql = "select * from Specialties ORDER BY specialtyId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Specialty> listSpecialty = new ArrayList<Specialty>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, total);
            rs = ps.executeQuery();
            while (rs.next()) {
                Specialty spec = new Specialty();
                spec.setId(rs.getInt("specialtyId"));
                spec.setName(rs.getString("name"));
                spec.setDescription(rs.getString("description"));
                String base64StringImage = new String(rs.getBytes("image"), "UTF-8");
                spec.setImage(base64StringImage);
                listSpecialty.add(spec);
            }
        } catch (Exception e) {
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                ps.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                conn.close();
            } catch (Exception e) {
                /* Ignored */ }
        }
        return listSpecialty;
    }

    public int getNoOfRecordAccounts() {
        String query = "SELECT count(*) FROM Specialties";
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
                    Logger.getLogger(SpecialtyDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SpecialtyDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SpecialtyDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return count;
    }

    public ArrayList<Specialty> searchByNameOrEmail(String search, int start, int total) {
        String sql = "SELECT * from Specialties s where s.name like ? ORDER BY s.specialtyId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<Specialty> listSpec = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, '%' + search.trim() + '%');
            ps.setInt(2, start);
            ps.setInt(3, total);
            rs = ps.executeQuery();
            while (rs.next()) {
                Specialty spec = new Specialty();
                spec.setId(rs.getInt(1));
                spec.setName(rs.getString(2));
                spec.setDescription(rs.getString(3));
                String base64StringImage = new String(rs.getBytes(4), "UTF-8");
                spec.setImage(base64StringImage);
                listSpec.add(spec);
            }
        } catch (Exception e) {
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
        return listSpec;
    }

    public int getNoOfRecordSearchSpecialty(String search) {
        String sql = "SELECT count(*) FROM Specialties s where s.name like ?";
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

    public boolean addSpecialty(String name, String description, byte[] fileName) {
        boolean addSpecSuccess = false;

        String sql = "INSERT INTO Specialties(name, description, image) VALUES (?, ?, ?)";

        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setBytes(3, fileName);
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
        return addSpecSuccess;
    }

    public boolean updateSpecialty(int id, String name, String description, byte[] fileName) {
        boolean editSpecSuccess = false;
        String sql;
        if (fileName != null) {
            sql = "UPDATE Specialties SET name = ?, description = ?, image = ? where specialtyId = ?";
        } else {
            sql = "UPDATE Specialties SET name = ?, description = ? where specialtyId = ?";
        }
        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            if (fileName != null) {
                ps.setString(1, name);
                ps.setString(2, description);
                ps.setBytes(3, fileName);
                ps.setInt(4, id);
            }else {
                ps.setString(1, name);
                ps.setString(2, description);
                ps.setInt(3, id);
            }
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
        return editSpecSuccess;
    }

    public Specialty getSpecialtyInfo(int specialtyId) {
        String sql = "SELECT * from Specialties where specialtyId = ?";
        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Specialty spec = new Specialty();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, specialtyId);
            rs = ps.executeQuery();
            while (rs.next()) {
                spec.setId(specialtyId);
                spec.setName(rs.getString("name"));
                spec.setDescription(rs.getString("description"));
                String base64StringImage = new String(rs.getBytes("image"), "UTF-8");
                spec.setImage(base64StringImage);
            }
        } catch (Exception e) {
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
        return spec;
    }
}
