package com.example.mtl_parking_finder.dao;

import com.example.mtl_parking_finder.model.Coordinate;
import com.example.mtl_parking_finder.model.Sign;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

public interface SignDao {
    void setDataSource(DataSource dataSource);
    List<Sign> listAll();
    List<Sign> listFirstN(int n);
    List<Sign> listWithinRadius(Coordinate center, Double radiusInKm);
    List<Sign> listWithinRadiusOnDate(Coordinate center, Double radiusInKm, LocalDate localDate);
}
