package com.example.factory.machine;

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
public class ItemIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldFetchMachinesFromApiCall() throws Exception {
        mockMvc.perform(get("/api/machine"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldFetchMachineByIdFromApiCall() throws Exception {
        mockMvc.perform(get("/api/machine/5"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldFetchMachinesByPageFromApiCall() throws Exception {
        mockMvc.perform(get("/api/machine/page/2"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldCreateNewMachine() throws Exception {
        String requestBody = "{\"machineName\":\"xbox\",\"itemQuantity\":1}";

        mockMvc.perform(post("/api/machine")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"machineId\":51,\"machineName\":\"xbox\",\"itemQuantity\":1,\"subassemblies\":[]}"))
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldChangeMachine() throws Exception {
        String requestBody = "{\"machineName\":\"Playstation\",\"itemQuantity\":1}";

        mockMvc.perform(put("/api/machine/5")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"machineId\":5,\"machineName\":\"Playstation\",\"itemQuantity\":1}"))
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldDeleteMachine() throws Exception {

        mockMvc.perform(delete("/api/customer/51"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

}
