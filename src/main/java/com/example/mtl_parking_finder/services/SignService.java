package com.example.mtl_parking_finder.services;

import com.example.mtl_parking_finder.domain.Sign;

import java.util.List;

public interface SignService {
    List<Sign> findNearbySigns(Double longitude, Double latitude, Double searchRadius, int limit);
}
