package com.laptrinhweb.healthcare.dao.publicFeature;

import com.laptrinhweb.healthcare.context.DBContext;
import com.laptrinhweb.healthcare.model.Specialty;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SpecialtyDAO extends DBContext {

    public ArrayList<Specialty> getAllSpecialty() throws SQLException {
        String sql = "select * from Specialty";
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
                String encodeBase64 = Base64.getEncoder().encodeToString(rs.getBytes("image"));
                spec.setImage(encodeBase64);
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
    
    public ArrayList<Specialty> getAllSpecialtyPublic(int start, int total) throws SQLException {
        String sql = "select * from Specialty ORDER BY specialtyId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
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
                spec.setImage(rs.getString("image"));
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
        String query = "SELECT count(*) FROM Specialty";
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
}
