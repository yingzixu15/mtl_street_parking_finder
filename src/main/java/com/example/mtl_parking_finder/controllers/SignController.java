package com.example.mtl_parking_finder.controllers;

import com.example.mtl_parking_finder.dao.SignDao;
import com.example.mtl_parking_finder.model.Coordinate;
import com.example.mtl_parking_finder.model.Sign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/api/signs")
public class SignController {
    private final SignDao signDao;

    public SignController(SignDao signDao) {
        this.signDao = signDao;
    }

    @GetMapping(path = "/show-all", produces = "application/json")
    public List<Sign> getAllSigns() {
        log.info("GET: list all signs");
        return signDao.listAll();
    }

    @GetMapping(path = "/show-limit/{nStr}", produces = "application/json")
    public List<Sign> getFirstNSigns(@PathVariable String nStr) {
        int n = Integer.parseInt(nStr);
        log.info(String.format("GET: list first %d signs", n));
        return signDao.listFirstN(n);
    }

    @GetMapping(path = "/show-radius/long/{longStr}/lat/{latStr}/distance/{distStr}", produces = "application/json")
    public List<Sign> getSignsWithinDistance(@PathVariable String longStr, @PathVariable String latStr, @PathVariable String distStr) {
        Double longitude = Double.valueOf(longStr);
        Double latitude = Double.valueOf(latStr);
        Double dist = Double.valueOf(distStr);
        Coordinate center = new Coordinate();
        center.setLongitude(longitude);
        center.setLatitude(latitude);
        log.info(String.format("GET: list signs within distance %.5f km from centre (%.8f, %.8f)", dist, longitude, latitude));
        return signDao.listWithinRadius(center, dist);
    }

    @GetMapping(path = "/show-radius-on-date/long/{longStr}/lat/{latStr}/distance/{distStr}/month/{mStr}/day/{dStr}", produces = "application/json")
    public List<Sign> getSignsWithinDistanceOnDate(@PathVariable String longStr, @PathVariable String latStr, @PathVariable String distStr, @PathVariable String mStr, @PathVariable String dStr) {
        Double longitude = Double.valueOf(longStr);
        Double latitude = Double.valueOf(latStr);
        Double dist = Double.valueOf(distStr);
        int month = Integer.parseInt(mStr);
        int day = Integer.parseInt(dStr);
        Coordinate center = new Coordinate();
        center.setLongitude(longitude);
        center.setLatitude(latitude);
        LocalDate localDate = LocalDate.of(LocalDate.now().getYear(), month, day);
        log.info(String.format("GET: list signs within distance %.5f km from centre (%.8f, %.8f) on date %d-%d", dist, longitude, latitude, month, day));
        return signDao.listWithinRadiusOnDate(center, dist, localDate);
    }

}
