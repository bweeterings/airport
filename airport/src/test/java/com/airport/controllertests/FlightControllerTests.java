package com.airport.controllertests;
/*
import com.fasterxml.jackson.databind.ObjectMapper;
import com.airport.controllers.FlightController;
import com.airport.models.Flight;
import com.airport.repositories.FlightRepository;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FlightControllerTests {

    @InjectMocks
    private FlightController flightController;

    @Mock
    private FlightRepository flightRepository;

    private MockMvc mockMvc;

    @Before
    public void setup() { this.mockMvc = MockMvcBuilders.standaloneSetup(flightController).build(); }

    @Test
    public void addingmoviesAPITest() throws Exception{

        Flight newFlight = new Flight(0,"Just me, no data!","Just me, friend of no data!");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(newFlight);

        when(flightRepository.save(Mockito.any(Flight.class))).thenReturn(newFlight);

        this.mockMvc.perform(post("/api/movies/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json))
                .andDo(print())
                .andExpect(jsonPath("$.id", is((int) newFlight.getId())))
                .andExpect(jsonPath("$.title", is(newFlight.getTitle())))
                .andExpect(jsonPath("$.airplane", is(newFlight.getAirplane())))
                .andExpect(status().isOk());
    }

    @Test
    public void gettingMoviesAPITest() throws Exception{

        List<Flight> flights = new ArrayList<>();

        Flight flight1 = new Flight(1, "Just me, a dummy","more dummies for testing");
        Flight flight2 = new Flight(2, "a friend of dummy","for testing");

        flights.add(flight1);
        flights.add(flight2);

        when(flightRepository.findAll()).thenReturn(flights);

        this.mockMvc.perform(get("/api/flights/"))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].id", is((int) flights.get(0).getId())))
                .andExpect(jsonPath("$.[0].title", is(flights.get(0).getOrigin())))
                .andExpect(jsonPath("$.[0].title", is(flights.get(0).getAirplane())))
                .andExpect(jsonPath("$.[1].id", is((int) flights.get(1).getId())))
                .andExpect(jsonPath("$.[1].title", is(flights.get(1).getAirplane())))
                .andExpect(jsonPath("$.[1].title", is(flights.get(1).getOrigin())))
                .andExpect(status().isOk());
    }

    @Test
    public void saveMoviesNoTitleTest() {
        Flight newFlight = new Flight();
        newFlight.setId(5);

        Flight result = flightController.addFlight(newFlight);
        assertTrue(null == result);
    }
}
*/