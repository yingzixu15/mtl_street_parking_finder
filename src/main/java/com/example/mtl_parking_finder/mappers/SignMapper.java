package com.example.mtl_parking_finder.mappers;

import com.example.mtl_parking_finder.model.Sign;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SignMapper implements RowMapper<Sign> {
    @Override
    public Sign mapRow(ResultSet rs, int rowNum) throws SQLException {
        Sign sign = new Sign();
        sign.setId(rs.getLong("id"));
        sign.setLongitude(rs.getDouble("longitude"));
        sign.setLatitude(rs.getDouble("latitude"));
        sign.setNom_arrond(rs.getString("nom_arrond"));
        sign.setDescription_rpa(rs.getString("description_rpa"));
        sign.setStart_month(rs.getInt("start_month"));
        sign.setStart_date(rs.getInt("start_date"));
        sign.setEnd_month(rs.getInt("end_month"));
        sign.setEnd_date(rs.getInt("end_date"));

        return sign;
    }
}
