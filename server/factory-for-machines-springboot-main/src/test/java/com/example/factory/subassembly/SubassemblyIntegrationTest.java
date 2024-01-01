package com.example.factory.subassembly;

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
public class SubassemblyIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldFetchSubassembliesFromApiCall() throws Exception {
        mockMvc.perform(get("/api/subassembly"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldFetchSubassemblyByIdFromApiCall() throws Exception {
        mockMvc.perform(get("/api/subassembly/5"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldFetchSubassembliesByPageFromApiCall() throws Exception {
        mockMvc.perform(get("/api/subassembly/page/2"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldCreateNewSubassembly() throws Exception {
        String requestBody = "{\"subassemblyName\":\"Motherboard\"}";

        mockMvc.perform(post("/api/subassembly")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"subassemblyId\":51,\"subassemblyName\":\"Motherboard\",\"parts\":[]}"))
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldChangeSubassembly() throws Exception {
        String requestBody = "{\"subassemblyName\":\"engine\"}";

        mockMvc.perform(put("/api/subassembly/5")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"subassemblyId\":5,\"subassemblyName\":\"engine\"}"))
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldDeleteSubassembly() throws Exception {

        mockMvc.perform(delete("/api/subassembly/51"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }
}
