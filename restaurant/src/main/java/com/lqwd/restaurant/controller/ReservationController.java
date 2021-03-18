package com.lqwd.restaurant.controller;

import com.lqwd.restaurant.entities.Reservation;
import com.lqwd.restaurant.pojos.ApiResponse;
import com.lqwd.restaurant.pojos.ReservationCreateRequest;
import com.lqwd.restaurant.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;


    @GetMapping("/v1/reservations")
    public ResponseEntity<ApiResponse<List<Reservation>>> getAllReservations() {

        ApiResponse response = reservationService.findAllReservations();

        return ResponseEntity.ok().body(response);

    }

    @GetMapping("/v1/reservations/{id}")
    public ResponseEntity<ApiResponse<Reservation>> getReservationById(@PathVariable Long id) {

        ApiResponse response = reservationService.getOneReservation(id);

        return ResponseEntity.ok().body(response);

    }

    @PostMapping("/v1/reservations")
    public ResponseEntity<ApiResponse<Reservation>> createNewReservation(@RequestBody ReservationCreateRequest reservationCreateRequest) {

        ApiResponse response = reservationService.create(reservationCreateRequest);

        return ResponseEntity.ok().body(response);

    }

    @DeleteMapping("/v1/reservations/{id}")
    public ResponseEntity<ApiResponse<Reservation>> deleteReservation(@PathVariable Long id) {

        ApiResponse response = reservationService.deleteReservationById(id);

        return ResponseEntity.ok().body(response);

    }

}
