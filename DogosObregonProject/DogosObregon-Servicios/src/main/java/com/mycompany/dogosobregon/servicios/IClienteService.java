package com.mycompany.dogosobregon.servicios;

import com.mycompany.dogosobregon.dominio.Cliente;



public interface IClienteService extends IGenericoService<Cliente, Long> {
    Cliente buscarPorNombre(String nombre);
    void registrarClienteNuevo(Cliente c);
}
