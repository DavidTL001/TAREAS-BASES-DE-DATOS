/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Alejandro Tirado Luna 00000233047
 */
@Entity
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "cod_barras", length = 50, unique = true)
    private String codBarras;

    @OneToMany(mappedBy = "producto",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<PedidoProducto> pedidoProductos = new ArrayList<>();

    public Producto() {
    }

    public Producto(String descripcion, BigDecimal precio,
            Integer stock, String codBarras) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.codBarras = codBarras;
    }

    public Long getIdProducto() {
        return id;
    }

    public void setIdProducto(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String d) {
        this.descripcion = d;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal p) {
        this.precio = p;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer s) {
        this.stock = s;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String cb) {
        this.codBarras = cb;
    }

    public List<PedidoProducto> getPedidoProductos() {
        return pedidoProductos;
    }

    public void setPedidoProductos(List<PedidoProducto> pp) {
        this.pedidoProductos = pp;
    }

    @Override
    public String toString() {
        return "Producto{id=" + id + ", descripcion='" + descripcion + "'}";
    }
}
