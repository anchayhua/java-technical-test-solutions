package com.quique.api;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    @DisplayName("status200WhenValidRequest")
    public void getAllEmployeesAPI() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/planets")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*]").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].name").exists());
    }

    @Test
    @Order(2)
    @DisplayName("status200WhenGetIdPlanet")
    public void getPlanetByIdAPI() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/planet/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*]").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].name").exists());
    }
}
