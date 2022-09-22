package com.example.mtl_parking_finder.dao;

import com.example.mtl_parking_finder.mappers.SignMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.sql.DataSource;


class SignDaoImplTest {
    SignDaoImpl signDao;
    @Mock
    SignMapper signMapper;
    @Mock
    DataSource dataSource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        signDao = new SignDaoImpl(signMapper);
        signDao.setDataSource(dataSource);
    }

    @Test
    void listAll() {
    }

    @Test
    void listFirstN() {
    }

    @Test
    void listWithinRadius() {
    }

    @Test
    void listWithinRadiusOnDate() {

    }
}