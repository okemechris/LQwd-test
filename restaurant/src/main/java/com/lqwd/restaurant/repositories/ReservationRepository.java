package com.lqwd.restaurant.repositories;

import com.lqwd.restaurant.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
