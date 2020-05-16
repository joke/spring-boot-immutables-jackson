package io.github.joke.demo.immutablesjackson.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPerson() throws Exception {
        mockMvc.perform(get("/person").accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value(is("John")))
                .andExpect(jsonPath("$.lastName").value(is("Doe")))
                .andExpect(jsonPath("$.phones[0]").value(is("+49...")))
                .andExpect(jsonPath("$.address.street").value(is("Street 1")))
                .andExpect(jsonPath("$.address.country").value(is("Germany")));
    }

    @Test
    void postPersonSimple() throws Exception {
        mockMvc.perform(post("/person").accept(APPLICATION_JSON).contentType(APPLICATION_JSON)
                .content("{\"firstName\":\"John\",\"lastName\":\"Doe\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value(is("John")))
                .andExpect(jsonPath("$.lastName").value(is("Doe")))
                .andExpect(jsonPath("$.phones").value(empty()));
    }

    @Test
    void postPersonComplex() throws Exception {
        mockMvc.perform(post("/person").accept(APPLICATION_JSON).contentType(APPLICATION_JSON)
                .content("{\"firstName\":\"John\",\"lastName\":\"Doe\",\"address\":{\"street\":\"Street 1\",\"country\":\"Germany\"},\"phones\":[\"+49...\"]}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value(is("John")))
                .andExpect(jsonPath("$.lastName").value(is("Doe")))
                .andExpect(jsonPath("$.phones[0]").value(is("+49...")))
                .andExpect(jsonPath("$.address.street").value(is("Street 1")))
                .andExpect(jsonPath("$.address.country").value(is("Germany")));
    }

}