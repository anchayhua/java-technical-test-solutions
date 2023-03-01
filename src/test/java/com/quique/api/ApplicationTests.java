//package com.quique.api;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.quique.api.dto.PlanetDto;
//import org.junit.jupiter.api.*;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpHeaders;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
////@TestPropertySource(locations = "classpath:application-test.properties")
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@AutoConfigureMockMvc
//public class ApplicationTests {
//
//    static HttpHeaders authHeaders = new HttpHeaders();
//    ObjectMapper om = new ObjectMapper();
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
////    @Test
////    public void testGetPlanets() {
////        
////        HttpHeaders headers = new HttpHeaders();
//////headers.set("Authorization", "Bearer " + accessToken);
////
////        HttpEntity<String> entity = new HttpEntity<>(headers);
////
////        ResponseEntity<List<PlanetDto>> response = restTemplate.exchange("/api/planets?param={param}&page={page}",
////                HttpMethod.GET, entity, new ParameterizedTypeReference<List<PlanetDto>>() {
////                }, "paramValue", "pageValue");
//////        ResponseEntity<List<PlanetDto>> response = restTemplate.exchange("/api/planets?param={param}&page={page}",
//////                HttpMethod.GET, null, new ParameterizedTypeReference<List<PlanetDto>>() {
//////                }, "paramValue", "pageValue");
////
////        assertEquals(HttpStatus.OK, response.getStatusCode());
////        assertNotNull(response.getBody());
////    }
//    @Test
//    @Order(1)
//    @DisplayName("status200WhenValidRequest")
//    public void status200WhenValidRequest() throws Exception {
//        PlanetDto expectedRecord = PlanetDto.builder()
//                .area(13.2f)
//                .price(23.0f)
//                .city("Delhi")
//                .build();
//        PlanetDto actualHome = om.readValue(mockMvc.perform(post("/api/home")
//                .contentType("application/json")
//                .headers(authHeaders)
//                .content(om.writeValueAsString(expectedRecord)))
//                .andDo(print())
//                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), Home.class);
//
//        Assertions.assertEquals(expectedRecord.getArea(), actualHome.getArea());
//        Assertions.assertEquals(expectedRecord.getPrice(), actualHome.getPrice());
//        Assertions.assertEquals(expectedRecord.getCity(), actualHome.getCity());
//    }
//
////    @Test
////    public void testPostPeople() {
////        PeopleDto peopleDto = new PeopleDto();
////        // Set properties of PeopleDto
////
////        HttpEntity<PeopleDto> request = new HttpEntity<>(peopleDto);
////
////        ResponseEntity<List<PeopleDto>> response = restTemplate.exchange("/api/peoples",
////                HttpMethod.POST, request, new ParameterizedTypeReference<List<PeopleDto>>() {
////                });
////
////        assertEquals(HttpStatus.OK, response.getStatusCode());
////        assertNotNull(response.getBody());
////    }
//}
