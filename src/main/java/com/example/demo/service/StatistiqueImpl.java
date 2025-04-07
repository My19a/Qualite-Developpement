package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.springframework.stereotype.Service;

@Service
public class StatistiqueImpl implements Statistique{

    @Override
    public void ajouter(Voiture voiture) {

    }

    @Override
    public Echantillon prixMoyen() throws ArithmeticException {
        return null;
    }
}
