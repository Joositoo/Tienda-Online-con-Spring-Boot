package org.example.tiendaonlinespringboot.Service;

import org.example.tiendaonlinespringboot.Modelo.Historial;
import org.example.tiendaonlinespringboot.Repository.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HistorialService {
    private final HistorialRepository historialRepository;

    @Autowired
    public HistorialService(HistorialRepository historialRepository) {
        this.historialRepository = historialRepository;
    }

    public Iterable<Historial> getHistoriales() {
        return historialRepository.findAll();
    }

    public Optional<Historial> getHistorialById(int id) {
        return historialRepository.findById(id);
    }

    public void saveOrUpdate(Historial historial) {
        historialRepository.save(historial);
    }

    public void deleteById(int id) {
        historialRepository.deleteById(id);
    }
}
