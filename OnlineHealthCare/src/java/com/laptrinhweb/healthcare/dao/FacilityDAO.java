package com.laptrinhweb.healthcare.dao;

import com.laptrinhweb.healthcare.context.DBContext;
import com.laptrinhweb.healthcare.model.Facility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LuanPC
 */
public class FacilityDAO {
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
     public List<Facility> getAllFacility() {
        List<Facility> list = new ArrayList<>();
        String query = "select * from select*from MedicalFacilityInfo";
        try {
            conn = new DBContext().getConn();//luu y chua chac chan da hoat dong
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Facility(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getDate(5),
                        rs.getDate(6)));
            }
        } catch (Exception e) {
        }
        return list;
    
     
     
     
     
     }// main nay dung de test ket noi
      public static void main(String[] args) {
        FacilityDAO dao = new FacilityDAO();
        List<Facility> list = dao.getAllFacility();

        for (Facility o : list) {
            System.out.println(o);
        }
    }
}
