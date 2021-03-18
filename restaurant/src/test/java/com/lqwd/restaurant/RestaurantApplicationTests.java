package com.lqwd.restaurant;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lqwd.restaurant.entities.Reservation;
import com.lqwd.restaurant.pojos.ApiResponse;
import com.lqwd.restaurant.pojos.ReservationCreateRequest;
import com.lqwd.restaurant.services.ReservationService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.junit.Before;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class RestaurantApplicationTests {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper mapper;

    protected MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    void contextLoads() {
    }

    @Test
    public void listAllReservations() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/v1/reservations"))
                .andExpect(status().isOk());
    }

    @Test
    public void getOne() throws Exception {


        ReservationCreateRequest request = new ReservationCreateRequest();
        request.setDate(new Date());
        request.setFirstName("test");
        request.setLastName("test");

		ApiResponse<Reservation> reservationApiResponse =  reservationService.create(request);

        mvc.perform(MockMvcRequestBuilders.get("/v1/reservations/"+reservationApiResponse.getData().getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void createNewReservation() throws Exception {



        ReservationCreateRequest request = new ReservationCreateRequest();
        request.setDate(new Date());
        request.setFirstName("test");
        request.setLastName("test");


        mvc.perform(MockMvcRequestBuilders.post("/v1/reservations").content(mapper.writeValueAsString(request)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteReservation() throws Exception {


        ReservationCreateRequest request = new ReservationCreateRequest();
        request.setDate(new Date());
        request.setFirstName("test");
        request.setLastName("test");

		ApiResponse<Reservation> reservationApiResponse =  reservationService.create(request);

        mvc.perform(MockMvcRequestBuilders.delete("/v1/reservations/"+reservationApiResponse.getData().getId()))
                .andExpect(status().isOk());

        assertEquals(false, reservationService.findById(reservationApiResponse.getData().getId()).isPresent());
    }
}
