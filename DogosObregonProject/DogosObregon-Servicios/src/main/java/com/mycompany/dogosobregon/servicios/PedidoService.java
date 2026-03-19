package com.mycompany.dogosobregon.servicios;


import com.mycompany.dogosobregon.dominio.Pedido;
import com.mycompany.dogosobregon.persistencia.IPedidoDAO;
import com.mycompany.dogosobregon.persistencia.PedidoDAO;
import com.mycompany.dogosobregon.utilerias.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class PedidoService implements IPedidoService {

    private IPedidoDAO pedidoDao;

    public PedidoService() {
        this.pedidoDao = new PedidoDAO();
    }

    private void validarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo.");
        }
        if (pedido.getCliente() == null) {
            throw new IllegalArgumentException("El pedido debe tener un cliente asociado.");
        }
        if (pedido.getMetodoPago() == null) {
            throw new IllegalArgumentException("El método de pago es obligatorio.");
        }
    }

    @Override
    public void guardar(Pedido entidad) {
        validarPedido(entidad);
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            pedidoDao.guardar(entidad, em);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(Pedido entidad) {
        validarPedido(entidad);
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            pedidoDao.actualizar(entidad, em);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Pedido buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return pedidoDao.buscarPorId(id, em);
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            pedidoDao.eliminar(id, em);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Pedido> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return pedidoDao.buscarTodos(em);
        } finally {
            em.close();
        }
    }
}
