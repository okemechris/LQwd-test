package com.lqwd.restaurant.pojos;

import lombok.Data;

import java.util.Date;

@Data
public class ReservationCreateRequest {

    private String firstName;
    private String lastName;
    private Date date;
}
