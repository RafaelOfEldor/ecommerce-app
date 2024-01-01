package com.example.factory.order;

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
public class OrderIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldFetchOrdersFromApiCall() throws Exception {
        mockMvc.perform(get("/api/order"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldFetchOrderByIdFromApiCall() throws Exception {
        mockMvc.perform(get("/api/order/5"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldFetchOrdersByPageFromApiCall() throws Exception {
        mockMvc.perform(get("/api/order/page/2"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldCreateNewOrder() throws Exception {
        String requestBody = "{\"orderName\":\"xbox for Jason Derulo\"}";

        mockMvc.perform(post("/api/order")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"orderId\":51,\"orderName\":\"xbox for Jason Derulo\",\"machines\":[],\"customer\":null}"))
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldChangeOrder() throws Exception {
        String requestBody = "{\"orderName\":\"Playstation for Jason Derulo\"}";

        mockMvc.perform(put("/api/order/5")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"orderId\":5,\"orderName\":\"Playstation for Jason Derulo\"}"))
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldDeleteOrder() throws Exception {

        mockMvc.perform(delete("/api/order/51"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }
}
