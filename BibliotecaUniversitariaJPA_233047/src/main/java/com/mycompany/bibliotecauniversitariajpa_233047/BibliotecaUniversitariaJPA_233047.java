/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bibliotecauniversitariajpa_233047;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author David TL
 */
public class BibliotecaUniversitariaJPA_233047 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibliotecaUniversitariaPU");
        EntityManager em = emf.createEntityManager();
    }
}
