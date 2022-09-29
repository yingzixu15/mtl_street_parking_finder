package com.example.mtl_parking_finder.dao;

import com.example.mtl_parking_finder.mappers.SignMapper;
import com.example.mtl_parking_finder.model.Coordinate;
import com.example.mtl_parking_finder.model.Sign;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.time.LocalDate;
import java.util.List;


class SignDaoImplTest {
    SignDaoImpl signDao;
    @Mock
    SignMapper signMapper;
    @Mock
    JdbcTemplate jdbcTemplate;

    Sign sign1;
    Sign sign2;
    Sign sign3;
    Sign sign4;
    Sign sign5;
    Coordinate coordinate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        signDao = new SignDaoImpl(signMapper, jdbcTemplate);

        sign1 = new Sign(1L, 1.0, 1.0, "name1", "description1", 1, 1, 12, 31);
        sign2 = new Sign(2L, 1.5, 1.0, "name2", "description2", 4, 1, 10, 31);
        sign3 = new Sign(3L, 2.0, 2.0, "name3", "description3", 1, 1, 12, 31);
        sign4 = new Sign(4L, 1.5, 1.5, "name4", "description4", 1, 1, 12, 31);
        sign5 = new Sign(5L, 5.0, 5.0, "name5", "description5", 1, 1, 12, 31);
        coordinate = new Coordinate();
        coordinate.setLatitude(1.0);
        coordinate.setLongitude(1.0);
    }

    @Test
    void listAll() {
        List<Sign> expected = List.of(sign1, sign2, sign3, sign4, sign5);
        Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(SignMapper.class))).thenReturn(expected);
        List<Sign> result = signDao.listAll();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void listFirstN() {
        List<Sign> expected = List.of(sign1, sign2, sign3, sign4, sign5);
        Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(PreparedStatementSetter.class), Mockito.any(SignMapper.class))).thenReturn(expected);
        List<Sign> result = signDao.listFirstN(5);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void listWithinRadius() {
        List<Sign> expected = List.of(sign1, sign2);
        Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(PreparedStatementSetter.class), Mockito.any(SignMapper.class))).thenReturn(expected);
        List<Sign> result = signDao.listWithinRadius(coordinate, 1.0);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void listWithinRadiusOnDate() {
        LocalDate localDate = LocalDate.now();
        List<Sign> expected = List.of(sign1, sign5);
        Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(PreparedStatementSetter.class), Mockito.any(SignMapper.class))).thenReturn(expected);
        List<Sign> result = signDao.listWithinRadiusOnDate(coordinate, 1.0, localDate);
        Assertions.assertEquals(expected, result);
    }
}