package com.project.docker.service;

import com.project.docker.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{

    private final List<Producto> productos = new ArrayList<>();
    private Long contadorId = 1L;

    @Override
    public List<Producto> listar() {
        return productos;
    }

    @Override
    public Optional<Producto> obtenerPorId(Long id) {
        return productos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public Producto agregar(Producto producto) {
        producto.setId(contadorId++);
        productos.add(producto);
        return producto;
    }

    @Override
    public Optional<Producto> actualizar(Long id, Producto nuevoProducto) {
        return obtenerPorId(id).map(producto -> {
            producto.setNombre(nuevoProducto.getNombre());
            producto.setDescripcion(nuevoProducto.getDescripcion());
            producto.setPrecio(nuevoProducto.getPrecio());
            return producto;
        });
    }

    @Override
    public boolean eliminar(Long id) {
        return productos.removeIf(p -> p.getId().equals(id));
    }

}
