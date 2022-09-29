package com.example.mtl_parking_finder.mappers;

import com.example.mtl_parking_finder.model.Sign;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class SignMapper implements RowMapper<Sign> {
    @Override
    public Sign mapRow(ResultSet rs, int rowNum) throws SQLException {
        Sign sign = new Sign();
        sign.setId(rs.getLong("id"));
        sign.setLongitude(rs.getDouble("longitude"));
        sign.setLatitude(rs.getDouble("latitude"));
        sign.setNomArrond(rs.getString("nom_arrond"));
        sign.setDescription(rs.getString("description_rpa"));
        sign.setStartMonth(rs.getInt("start_month"));
        sign.setStartDate(rs.getInt("start_date"));
        sign.setEndMonth(rs.getInt("end_month"));
        sign.setEndDate(rs.getInt("end_date"));

        return sign;
    }
}
