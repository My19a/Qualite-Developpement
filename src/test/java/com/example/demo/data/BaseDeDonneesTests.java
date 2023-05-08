package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BaseDeDonneesTests {

    @MockBean
    private VoitureRepository voitureRepository;

    @Test
    void uneVoiture(){
        Voiture voiture = new Voiture("Ferrari", 5000);
        when(voitureRepository.save(voiture)).thenReturn(voiture);
        when(voitureRepository.findAll()).thenReturn(Collections.singletonList(voiture));
    }

    @Test
    void uneSeuleVoiture(){
        Voiture voiture = new Voiture("Ferrari", 5000);
        when(voitureRepository.save(voiture)).thenReturn(voiture);
        when(voitureRepository.findById(voiture.getId())).thenReturn(Optional.of(voiture));
    }

    @Test
    void supprimerVoiture(){
        Voiture voiture = new Voiture("Ferrari", 5000);
        when(voitureRepository.save(voiture)).thenReturn(voiture);
        voitureRepository.delete(voiture);
        Mockito.verify(voitureRepository, times(1)).delete(voiture);
    }

}
