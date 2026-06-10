package com.example.demo.web;

import com.example.demo.data.Voiture;
import com.example.demo.service.Echantillon;
import com.example.demo.service.StatistiqueImpl;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WebTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getStatistiques() throws Exception {

        when(statistiqueImpl.prixMoyen())
                .thenReturn(new Echantillon(1, 2000));

        mockMvc.perform(get("/statistique"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreDeVoitures").value(1))
                .andExpect(jsonPath("$.prixMoyen").value(2000));
    }

    @Test
    void getStatistiquesSansVoiture() throws Exception {

        when(statistiqueImpl.prixMoyen())
                .thenThrow(new ArithmeticException());

        mockMvc.perform(get("/statistique"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void ajouterVoiture() throws Exception {

        mockMvc.perform(post("/voiture")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                                "marque":"Audi",
                                "prix":7000
                            }
                            """))
                .andExpect(status().isOk());
    }
}