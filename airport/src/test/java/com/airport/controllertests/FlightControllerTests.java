package com.airport.controllertests;

import com.airport.enumerations.Destination;
import com.airport.enumerations.Origin;
import com.airport.enumerations.PlaneType;
import com.airport.models.Airplane;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    public void addingFlightsAPITest() throws Exception{

        Flight newFlight = new Flight();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(newFlight);

        when(flightRepository.save(Mockito.any(Flight.class))).thenReturn(newFlight);

        this.mockMvc.perform(post("/api/flights/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json))
                .andDo(print())
                .andExpect(jsonPath("$.id", is((int) newFlight.getId())))
                .andExpect(jsonPath("$.airplane", is(newFlight.getAirplane())))
                .andExpect(jsonPath("$.origin", is(newFlight.getOrigin())))
                .andExpect(jsonPath("$.origin", is(newFlight.getDestination())))
                .andExpect(status().isOk());
    }

    @Test
    public void gettingFlightsAPITest() throws Exception{

        Airplane airplane1 = new Airplane(0, "Jap Deluxe", PlaneType.Boeing787, 5000, 5000);

        List<Flight> flights = new ArrayList<>();

        Flight flight1 = new Flight(0, airplane1, Origin.Amsterdam, Destination.Berlin, 2000, LocalDateTime.of(2018,02,27,17,15,00), LocalDateTime.of(2018,02,27,20,30,00));
        Flight flight2 = new Flight(1, airplane1, Origin.Berlin, Destination.Amsterdam, 2000, LocalDateTime.of(2018,03,11,15,20,00), LocalDateTime.of(2018,03,11,18,45,00));

        flights.add(flight1);
        flights.add(flight2);

        when(flightRepository.findAll()).thenReturn(flights);

        this.mockMvc.perform(get("/api/flights/"))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].id", is((int) flights.get(0).getId())))
                .andExpect(jsonPath("$.[0].airplane", is(flights.get(0).getAirplane())))
                .andExpect(jsonPath("$.[0].origin", is(flights.get(0).getOrigin())))
                .andExpect(jsonPath("$.[0].destination", is(flights.get(0).getDestination())))
                .andExpect(jsonPath("$.[1].id", is((int) flights.get(1).getId())))
                .andExpect(jsonPath("$.[1].airplane", is(flights.get(1).getAirplane())))
                .andExpect(jsonPath("$.[1].origin", is(flights.get(1).getOrigin())))
                .andExpect(jsonPath("$.[1].destination", is(flights.get(1).getDestination())))
                .andExpect(status().isOk());
    }

    @Test
    public void saveFlightsNoAirplaneTest() {
        Flight newFlight = new Flight();
        newFlight.setId(5);

        Flight result = flightController.addFlight(newFlight);
        assertTrue(null == result);
    }
}