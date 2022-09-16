package com.example.mtl_parking_finder.dao;

import com.example.mtl_parking_finder.mappers.SignMapper;
import com.example.mtl_parking_finder.model.Coordinate;
import com.example.mtl_parking_finder.model.Sign;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.object.SqlQuery;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class SignDaoImpl implements SignDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Sign> listAll() {
        String stmt = "SELECT * FROM signs";
        SqlQuery<Sign> sqlQuery = new SqlQuery<>() {
            @Override
            protected RowMapper<Sign> newRowMapper(Object[] parameters, Map<?, ?> context) {
                return new SignMapper();
            }
        };
        sqlQuery.setDataSource(dataSource);
        sqlQuery.setSql(stmt);
        return sqlQuery.execute();
    }

    @Override
    public List<Sign> listFirstN(int n) {
        final String stmt = "SELECT * FROM signs LIMIT ?";
        return jdbcTemplate.query(stmt, ps -> ps.setInt(1, n), new SignMapper());
    }

    @Override
    public List<Sign> listWithinRadius(Coordinate center) {
        return null;
    }
}
