package com.project.docker.service;

import com.project.docker.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> obtenerPorId(Long id);
    Producto agregar(Producto producto);
    Optional<Producto> actualizar(Long id, Producto nuevoProducto);
    boolean eliminar(Long id);
}
