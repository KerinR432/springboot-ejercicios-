package com.example.GrasaCorporalObejeto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GrasaCorporal.class)
class GrasaCorporalTest {
     @Autowired
     private MockMvc mockMvc;
    @Test
    void verFormulario() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("formulario"));

    }

    @Test
    void comprobarInfoPersona() throws Exception {
        mockMvc.perform(post("/ComprobarInfoPersona")
                .param("nombre","Juan")
                .param("edad","28")
                .param("genero","H")
                .param("IMC","22.5"))
                .andExpect(status().isOk())
                .andExpect(view().name("resultado"))
                .andExpect(model().attributeExists("grasaCorporal"));
    }
}