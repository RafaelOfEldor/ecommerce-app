package com.example.factory.part;


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
public class PartIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldFetchPartsFromApiCall() throws Exception {
        mockMvc.perform(get("/api/part"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldFetchPartByIdFromApiCall() throws Exception {
        mockMvc.perform(get("/api/part/5"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldFetchPartsByPageFromApiCall() throws Exception {
        mockMvc.perform(get("/api/part/page/2"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldCreateNewPart() throws Exception {
        String requestBody = "{\"partName\":\"Sim card\"}";

        mockMvc.perform(post("/api/part")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"partId\":201,\"partName\":\"Sim card\"}"))
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldChangePart() throws Exception {
        String requestBody = "{\"partName\":\"sim card\"}";

        mockMvc.perform(put("/api/part/5")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"partId\":5,\"partName\":\"sim card\"}"))
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldDeletePart() throws Exception {

        mockMvc.perform(delete("/api/part/201"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

}
