package com.example.mtl_parking_finder;

import java.time.LocalDate;
import java.time.LocalTime;

public class DataToDbUtil {
    private class ParkingSign {
        private LocalDate startDate;
        private LocalDate endDate;
        private LocalTime startTime;
        private LocalTime endTime;
        private Double longitude;
        private Double latitude;
        private String description;
        private String nomArrond;

        public ParkingSign(Double longitude, Double latitude, String description, String nomArrond) {
            this.longitude = longitude;
            this.latitude = latitude;
            this.description = description;
            this.nomArrond = nomArrond;


        }
    }
}