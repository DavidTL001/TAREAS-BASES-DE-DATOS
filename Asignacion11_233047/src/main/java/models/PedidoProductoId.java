/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author David Alejandro Tirado Luna 00000233047
 */

@Embeddable
public class PedidoProductoId implements Serializable {

    @Column(name = "id_pedido")
    private Long idPedido;

    @Column(name = "id_producto")
    private Long idProducto;

    public PedidoProductoId() {
    }

    public PedidoProductoId(Long idPedido, Long idProducto) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long id) {
        this.idPedido = id;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long id) {
        this.idProducto = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PedidoProductoId)) {
            return false;
        }
        PedidoProductoId that = (PedidoProductoId) o;
        return Objects.equals(idPedido, that.idPedido)
                && Objects.equals(idProducto, that.idProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido, idProducto);
    }
}
