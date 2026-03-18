/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.persistence.*;

/**
 *
 * @author David Alejandro Tirado Luna 00000233047
 */ 
@Entity
@Table(name = "ClientesCorreos")
public class ClienteCorreo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_correo")
    private Long idCorreo;

    
    @Column(name = "correo", nullable = false, length = 150, unique = true)
    private String correo;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_correo_cliente"))
    private Cliente cliente;


    public ClienteCorreo() {
    }

    public ClienteCorreo(String correo, Cliente cliente) {
        this.correo = correo;
        this.cliente = cliente;
    }

    public Long getIdCorreo() {
        return idCorreo;
    }

    public void setIdCorreo(Long id) {
        this.idCorreo = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String c) {
        this.correo = c;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente c) {
        this.cliente = c;
    }

    @Override
    public String toString() {
        return "ClienteCorreo{id=" + idCorreo + ", correo='" + correo + "'}";
    }
}
