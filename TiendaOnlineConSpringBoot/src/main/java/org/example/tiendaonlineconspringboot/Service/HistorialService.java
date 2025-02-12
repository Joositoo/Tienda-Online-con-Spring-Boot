package org.example.tiendaonlineconspringboot.Service;

import org.example.tiendaonlineconspringboot.Modelo.Historial;
import org.example.tiendaonlineconspringboot.Modelo.Producto;
import org.example.tiendaonlineconspringboot.Repository.HistorialRepository;
import org.example.tiendaonlineconspringboot.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class HistorialService {
    private final HistorialRepository historialRepository;
    private final ProductoRepository productoRepository;

    @Autowired
    public HistorialService(HistorialRepository historialRepository, ProductoRepository productoRepository) {
        this.historialRepository = historialRepository;
        this.productoRepository = productoRepository;
    }

    public Iterable<Historial> getHistoriales() {
        return historialRepository.findAll();
    }

    public Optional<Historial> getHistorialById(int id) {
        return historialRepository.findById(id);
    }

    public void saveOrUpdate(Historial historial) throws Exception {
        if (historial.getCantidad() <= historial.getProducto().getStock()) {
            Producto producto = historial.getProducto();
            producto.setStock(producto.getStock() - historial.getCantidad());

            productoRepository.save(producto);
            historialRepository.save(historial);
        } else if (historial.getCantidad() > historial.getProducto().getStock() || historial.getProducto().getStock() == 0) {
            throw new Exception("No se dispone de tal cantidad del producto");
        }
    }

    public void deleteById(int id) {
        Historial historial = historialRepository.findById(id).orElse(null);

        if (historial != null && historial.getFechaCompra().plusDays(30).isAfter(LocalDate.now())) {
            Producto producto = historial.getProducto();
            producto.setStock(producto.getStock() + historial.getCantidad());

            productoRepository.save(producto);
            historialRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("El historial no existe o han pasado más de 30 días");
        }
    }
}
