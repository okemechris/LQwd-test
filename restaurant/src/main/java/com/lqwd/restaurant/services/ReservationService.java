package com.lqwd.restaurant.services;

import com.lqwd.restaurant.entities.Reservation;
import com.lqwd.restaurant.pojos.ApiResponse;
import com.lqwd.restaurant.pojos.ReservationCreateRequest;
import com.lqwd.restaurant.repositories.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public List<Reservation> findAll(){
        return reservationRepository.findAll();
    }

    public Optional<Reservation> findById(Long id){
        return reservationRepository.findById(id);
    }

    public void deleteById(Long id){
         reservationRepository.deleteById(id);
    }

    public ApiResponse<List<Reservation>> findAllReservations(){

        List<Reservation> reservations = findAll();
        return new ApiResponse<>(reservations, "Request Successful");

    }

    public ApiResponse<Reservation> getOneReservation(Long id){

        Reservation reservation = findById(id).orElse(null);
        if(reservation == null)
            return new ApiResponse<>(null, "No reservation found for the given id");

        return new ApiResponse<>(reservation, "Request Successful");

    }

    public ApiResponse<String> deleteReservationById(Long id){

        deleteById(id);
        return new ApiResponse<>(null, "Request Successful");

    }

    public ApiResponse<Reservation> create(ReservationCreateRequest request){
        Reservation reservation = new Reservation();
        reservation.setFirstName(request.getFirstName());
        reservation.setLastName(request.getLastName());
        reservation.setDate(request.getDate());

        reservation =  reservationRepository.save(reservation);

        return  new ApiResponse<>(reservation, "Request Successful");
    }

}
