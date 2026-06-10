package com.example.demo.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EchantillonTest {

    @Test
    void creerEchantillon() {

        Echantillon echantillon = new Echantillon(2, 3000);

        assertEquals(2, echantillon.getNombreDeVoitures());
        assertEquals(3000, echantillon.getPrixMoyen());
    }

    @Test
    void modifierEchantillon() {

        Echantillon echantillon = new Echantillon();

        echantillon.setNombreDeVoitures(5);
        echantillon.setPrixMoyen(10000);

        assertEquals(5, echantillon.getNombreDeVoitures());
        assertEquals(10000, echantillon.getPrixMoyen());
    }
}