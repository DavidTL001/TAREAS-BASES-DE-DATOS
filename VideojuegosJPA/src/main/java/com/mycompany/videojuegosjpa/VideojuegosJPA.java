/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.videojuegosjpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author David TL
 */
public class VideojuegosJPA {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideojuegosPU");
        EntityManager em = emf.createEntityManager();
    }
    
    
}
