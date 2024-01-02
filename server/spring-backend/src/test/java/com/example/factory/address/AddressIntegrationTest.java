package com.example.factory.address;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldFetchAddressesFromApiCall() throws Exception {
        mockMvc.perform(get("/api/address"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldFetchAddressByIdFromApiCall() throws Exception {
        mockMvc.perform(get("/api/address/5"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldFetchAddressesByPageFromApiCall() throws Exception {
        mockMvc.perform(get("/api/address/page/2"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldCreateNewAddress() throws Exception {
        String requestBody = "{\"addressStreetName\":\"MyStreet\",\"addressStreetNameNumber\":\"123\"}";

        mockMvc.perform(post("/api/address")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"addressId\":51,\"addressStreetName\":\"MyStreet\",\"addressStreetNameNumber\":\"123\",\"customers\":[]}"))
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldChangeAddress() throws Exception {
        String requestBody = "{\"addressStreetName\":\"MyUpdatedStreet\",\"addressStreetNameNumber\":\"781\"}";

        mockMvc.perform(put("/api/address/51")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"addressId\":51,\"addressStreetName\":\"MyUpdatedStreet\",\"addressStreetNameNumber\":\"781\",\"customers\":[]}"))
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldDeleteAddress() throws Exception {
        mockMvc.perform(delete("/api/address/51"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

}
