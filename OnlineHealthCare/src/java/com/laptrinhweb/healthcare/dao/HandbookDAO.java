package com.laptrinhweb.healthcare.dao;

import com.laptrinhweb.healthcare.context.DBContext;
import com.laptrinhweb.healthcare.model.Handbook;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LuanPC
 */
public class HandbookDAO extends DBContext{
    public ArrayList<Handbook> findAll(int start, int total) {
        String sql = "select * from Handbooks ORDER BY handBookId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
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
    
        public ArrayList<Handbook> getHanbookDetail() {
        String sql = "select * from Handbooks";
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<Handbook> listHandbook = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
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
}
