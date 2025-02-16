package org.example.tiendaonlineconspringboot.Service;

import org.example.tiendaonlineconspringboot.Modelo.Producto;
import org.example.tiendaonlineconspringboot.Repository.ProductoRepository;
import org.example.tiendaonlineconspringboot.Repository.ServicioAlmacenamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;
    private final ServicioAlmacenamiento servicioAlmacenamiento;

    @Autowired
    public ProductoService(ProductoRepository productoRepository, ServicioAlmacenamiento servicioAlmacenamiento) {
        this.productoRepository = productoRepository;
        this.servicioAlmacenamiento = servicioAlmacenamiento;
    }

    public Iterable<Producto> getProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> getProductoById(int id) {
        return productoRepository.findById(id);
    }

    public Producto saveOrUpdate(Producto producto) {
        String descripcion = producto.getDescripcion();
        if (producto.getPrecio().compareTo(new BigDecimal("10")) < 0){
            descripcion += " - Producto de oferta -.";
        }
        if (producto.getPrecio().compareTo(new BigDecimal("200")) > 0){
            descripcion += " - Producto de calidad -.";
        }

        if (productoRepository.findProductoByNombre(producto.getNombre()) != null){
            throw new RuntimeException("El producto ya existe");
        }

        producto.setDescripcion(descripcion);
        productoRepository.save(producto);
        return producto;
    }

    public Producto saveOrUpdateWithImage (Producto producto, MultipartFile imagen) {
        servicioAlmacenamiento.store(imagen);
        producto.setImagen_url(servicioAlmacenamiento.load(imagen.getOriginalFilename()).toString());
        return saveOrUpdate(producto);
    }

    public void deleteById(int id) {
        productoRepository.deleteById(id);
    }
}
