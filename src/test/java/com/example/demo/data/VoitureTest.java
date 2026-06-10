package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoitureTest {

    
    @Test
    void creerVoiture(){
        Voiture voiture = new Voiture("Opel",2000);
        Assert.isTrue(voiture.getMarque().equals("Opel"),"Doit être Opel");
        Assert.isTrue(voiture.getPrix() == 2000,"Doit être 2000");
        
    }

}
