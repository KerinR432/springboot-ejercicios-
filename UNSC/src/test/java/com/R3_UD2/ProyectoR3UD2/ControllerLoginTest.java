package com.R3_UD2.ProyectoR3UD2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@WebMvcTest
class ControllerLoginTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void loginValidaRedirige() throws Exception {
        mockMvc.perform(get("/login")
                .param("nombre","Fernando")
                .param("contraseña","1234"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/credenciales"));

    }
}