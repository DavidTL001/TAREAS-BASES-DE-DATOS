/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.asignacion11_233047;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author David Alejandro Tirado Luna 00000233047
 */ 
public class Asignacion11_233047 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AmazonPU");
        EntityManager em = emf.createEntityManager();
    }
}
