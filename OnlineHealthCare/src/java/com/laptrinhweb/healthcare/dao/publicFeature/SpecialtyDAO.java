package com.laptrinhweb.healthcare.dao.publicFeature;

import com.laptrinhweb.healthcare.context.DBContext;
import com.laptrinhweb.healthcare.model.Specialty;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
/**
 *
 * @author LuanPC
 */
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
//                byte[] encodeBase64 = Base64.encodeBase64(rs.getBytes("image"));
//                String base64DataString = new String(encodeBase64, "UTF-8");
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
}
