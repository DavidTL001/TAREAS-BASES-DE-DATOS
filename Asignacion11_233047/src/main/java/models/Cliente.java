/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Alejandro Tirado Luna 00000233047
 */ 
@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "ap_mat", length = 100)
    private String apMat;

    @Column(name = "ap_pat", length = 100)
    private String apPat;

    @Column(name = "fch_nac")
    private LocalDate fchNac;


    @OneToMany(mappedBy = "cliente",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<ClienteTelefono> telefonos = new ArrayList<>();


    @OneToMany(mappedBy = "cliente",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<ClienteCorreo> correos = new ArrayList<>();


    @OneToMany(mappedBy = "cliente",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Pedido> pedidos = new ArrayList<>();


    public Cliente() {
    }

    public Cliente(String nombre, String apMat, String apPat, LocalDate fchNac) {
        this.nombre = nombre;
        this.apMat = apMat;
        this.apPat = apPat;
        this.fchNac = fchNac;
    }


    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApMat() {
        return apMat;
    }

    public void setApMat(String apMat) {
        this.apMat = apMat;
    }

    public String getApPat() {
        return apPat;
    }

    public void setApPat(String apPat) {
        this.apPat = apPat;
    }

   
    @Transient
    public Integer getEdad() {
        if (this.fchNac == null) {
            return null;
        }
        return Period.between(this.fchNac, LocalDate.now()).getYears();
    }

    public LocalDate getFchNac() {
        return fchNac;
    }

    public void setFchNac(LocalDate d) {
        this.fchNac = d;
    }

    public List<ClienteTelefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<ClienteTelefono> t) {
        this.telefonos = t;
    }

    public List<ClienteCorreo> getCorreos() {
        return correos;
    }

    public void setCorreos(List<ClienteCorreo> c) {
        this.correos = c;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> p) {
        this.pedidos = p;
    }

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nombre='" + nombre + "'}";
    }
}
