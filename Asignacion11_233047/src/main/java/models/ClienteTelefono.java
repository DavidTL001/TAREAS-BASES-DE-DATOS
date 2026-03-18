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
@Table(name = "ClientesTelefonos")
public class ClienteTelefono {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefono")
    private Long idTelefono;


    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_telefono_cliente"))
    private Cliente cliente;

 
    public ClienteTelefono() {
    }

    public ClienteTelefono(String telefono, Cliente cliente) {
        this.telefono = telefono;
        this.cliente = cliente;
    }


    public Long getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(Long id) {
        this.idTelefono = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String t) {
        this.telefono = t;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente c) {
        this.cliente = c;
    }

    @Override
    public String toString() {
        return "ClienteTelefono{id=" + idTelefono + ", telefono='" + telefono + "'}";
    }
}
