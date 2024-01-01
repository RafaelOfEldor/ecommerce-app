package com.example.factory.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldFetchCustomersFromApiCall() throws Exception {
        mockMvc.perform(get("/api/customer"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldFetchCustomerByIdFromApiCall() throws Exception {
        mockMvc.perform(get("/api/customer/5"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldFetchCustomersByPageFromApiCall() throws Exception {
        mockMvc.perform(get("/api/customer/page/5"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    // The id that gets returned here depends on whether the other integration test was run first, so beware
    // run this test suite solo, and it should be correct

    @Test
    void shouldCreateNewCustomer() throws Exception {
        String requestBody = "{\"customerName\":\"Jason Derulo\",\"customerEmail\":\"jason@derulo.com\"}";

        mockMvc.perform(post("/api/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"customerId\":51,\"customerName\":\"Jason Derulo\",\"customerEmail\":\"jason@derulo.com\",\"orders\":[],\"addresses\":[]}"))
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }



    @Test
    void shouldChangeCustomer() throws Exception {
        String requestBody = "{\"customerName\":\"Mac Miller\",\"customerEmail\":\"mac@miller.com\"}";

        mockMvc.perform(put("/api/customer/5")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"customerId\":5,\"customerName\":\"Mac Miller\",\"customerEmail\":\"mac@miller.com\"}"))
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldDeleteCustomer() throws Exception {

        mockMvc.perform(delete("/api/customer/51"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }


}
