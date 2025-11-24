package com.R3_UD2.ProyectoR3UD2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class formuarioControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testeo() throws Exception {
        mockMvc.perform(get())
    }


}