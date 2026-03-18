/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.persistence.*;

import java.math.BigDecimal;


/**
 *
 * @author David Alejandro Tirado Luna 00000233047
 */ 
@Entity
@Table(name = "PedidosProductos")
public class PedidoProducto {


    @EmbeddedId
    private PedidoProductoId id = new PedidoProductoId();

  
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idPedido")
    @JoinColumn(name = "id_pedido",
            foreignKey = @ForeignKey(name = "fk_pp_pedido"))
    private Pedido pedido;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idProducto")
    @JoinColumn(name = "id_producto",
            foreignKey = @ForeignKey(name = "fk_pp_producto"))
    private Producto producto;


    @Column(name = "precio_venta", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioVenta;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;


    public PedidoProducto() {
    }

    public PedidoProducto(Pedido pedido, Producto producto,
            BigDecimal precioVenta, Integer cantidad) {
        this.pedido = pedido;
        this.producto = producto;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
        this.id = new PedidoProductoId(pedido.getIdPedido(),
                producto.getIdProducto());
    }


    public PedidoProductoId getId() {
        return id;
    }

    public void setId(PedidoProductoId id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido p) {
        this.pedido = p;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto p) {
        this.producto = p;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal pv) {
        this.precioVenta = pv;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer c) {
        this.cantidad = c;
    }


    @Transient
    public BigDecimal getImporte() {
        if (this.precioVenta == null || this.cantidad == null) {
            return BigDecimal.ZERO;
        }
        return this.precioVenta.multiply(new BigDecimal(this.cantidad));
    }

    @Override
    public String toString() {
        return "PedidoProducto{pedido=" + id.getIdPedido() + ", producto=" + id.getIdProducto() + ", cantidad=" + cantidad + "}";
    }
}
