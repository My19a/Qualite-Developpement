package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatistiqueImplTest {

    private StatistiqueImpl statistique;

    @BeforeEach
    void init() {
        statistique = new StatistiqueImpl();
    }

    @Test
    void ajouterVoiture() {
        statistique.ajouter(new Voiture("Opel", 2000));

        Echantillon echantillon = statistique.prixMoyen();

        assertEquals(1, echantillon.getNombreDeVoitures());
        assertEquals(2000, echantillon.getPrixMoyen());
    }

    @Test
    void calculPrixMoyen() {
        statistique.ajouter(new Voiture("Opel", 2000));
        statistique.ajouter(new Voiture("Renault", 4000));

        Echantillon echantillon = statistique.prixMoyen();

        assertEquals(2, echantillon.getNombreDeVoitures());
        assertEquals(3000, echantillon.getPrixMoyen());
    }

    @Test
    void aucuneVoiture() {
        assertThrows(ArithmeticException.class,
                () -> statistique.prixMoyen());
    }
}