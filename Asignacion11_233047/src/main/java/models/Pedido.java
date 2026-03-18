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
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_pedido_cliente"))
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<PedidoProducto> pedidoProductos = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getIdPedido() {
        return id;
    }

    public void setIdPedido(Long id) {
        this.id = id;
    }

    @Transient
    public BigDecimal getSubtotal() {
        return pedidoProductos.stream()
                .map(PedidoProducto::getImporte)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Transient
    public BigDecimal getIva() {
        return getSubtotal().multiply(new BigDecimal("0.16"));
    }

    @Transient
    public BigDecimal getTotal() {
        return getSubtotal().add(getIva());
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente c) {
        this.cliente = c;
    }

    public List<PedidoProducto> getPedidoProductos() {
        return pedidoProductos;
    }

    public void setPedidoProductos(List<PedidoProducto> pp) {
        this.pedidoProductos = pp;
    }

    @Override
    public String toString() {
        return "Pedido{id=" + id + ", total=" + getTotal() + "}";
    }
}
