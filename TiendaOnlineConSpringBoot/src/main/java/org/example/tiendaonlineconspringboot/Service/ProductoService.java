package org.example.tiendaonlineconspringboot.Service;

import org.example.tiendaonlineconspringboot.Modelo.Producto;
import org.example.tiendaonlineconspringboot.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Iterable<Producto> getProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> getProductoById(int id) {
        return productoRepository.findById(id);
    }

    public void saveOrUpdate(Producto producto) {
        String descripcion = producto.getDescripcion();
        if (producto.getPrecio().compareTo(new BigDecimal("10")) < 0){
            descripcion += "\nProducto de oferta.";
        }
        if (producto.getPrecio().compareTo(new BigDecimal("200")) > 0){
            descripcion += "\nProducto de calidad.";
        }

        if (productoRepository.findProductoByNombre(producto.getNombre()) != null){
            throw new RuntimeException("El producto ya existe");
        }

        producto.setDescripcion(descripcion);
        productoRepository.save(producto);
    }

    public void deleteById(int id) {
        productoRepository.deleteById(id);
    }
}
