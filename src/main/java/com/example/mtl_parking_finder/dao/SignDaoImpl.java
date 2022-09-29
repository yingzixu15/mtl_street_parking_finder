package com.example.mtl_parking_finder.dao;

import com.example.mtl_parking_finder.mappers.SignMapper;
import com.example.mtl_parking_finder.model.Coordinate;
import com.example.mtl_parking_finder.model.Sign;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

@Service
public class SignDaoImpl implements SignDao {
    private final SignMapper signMapper;
    private final JdbcTemplate jdbcTemplate;

    public SignDaoImpl(SignMapper signMapper, JdbcTemplate jdbcTemplate) {
        this.signMapper = signMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate.setDataSource(dataSource);
    }

    @Override
    public List<Sign> listAll() {
        final String stmt = "SELECT * FROM signs";
        return jdbcTemplate.query(stmt, signMapper);
    }

    @Override
    public List<Sign> listFirstN(int n) {
        final String stmt = "SELECT * FROM signs LIMIT ?";
        return jdbcTemplate.query(stmt, ps -> ps.setInt(1, n), signMapper);
    }

    @Override
    public List<Sign> listWithinRadius(Coordinate center, Double radiusInKm) {
        Double longitudeRange = center.longitudeSizeByKm(center.getLatitude(), radiusInKm);
        Double latitudeRange = center.latitudeSizeByKm(radiusInKm);
        final String stmt = "SELECT * FROM signs WHERE (longitude BETWEEN ? AND ?) AND (latitude BETWEEN ? AND ?)";
        return jdbcTemplate.query(stmt, ps -> {
            ps.setDouble(1, center.getLongitude() - longitudeRange);
            ps.setDouble(2, center.getLongitude() + longitudeRange);
            ps.setDouble(3, center.getLatitude() - latitudeRange);
            ps.setDouble(4, center.getLatitude() + latitudeRange);
        }, signMapper);
    }

    @Override
    public List<Sign> listWithinRadiusOnDate(Coordinate center, Double radiusInKm, LocalDate localDate) {
        Double longitudeRange = center.longitudeSizeByKm(center.getLatitude(), radiusInKm);
        Double latitudeRange = center.latitudeSizeByKm(radiusInKm);
        int month = localDate.getMonth().getValue();
        int day = localDate.getDayOfMonth();
        final String stmt = "SELECT * FROM signs " +
                "WHERE (longitude BETWEEN ? AND ?) AND (latitude BETWEEN ? AND ?)" +
                "AND ((start_month < ? AND end_month > ?) " +
                "OR (start_month == ? AND start_date <= ?)" +
                "OR (end_month == ? AND end_date >= ?))";
        return jdbcTemplate.query(stmt, ps -> {
            ps.setDouble(1, center.getLongitude() - longitudeRange);
            ps.setDouble(2, center.getLongitude() + longitudeRange);
            ps.setDouble(3, center.getLatitude() - latitudeRange);
            ps.setDouble(4, center.getLatitude() + latitudeRange);
            ps.setInt(5, month);
            ps.setInt(6, month);
            ps.setInt(7, month);
            ps.setInt(8, day);
            ps.setInt(9, month);
            ps.setInt(10, day);
        }, signMapper);
    }
}
