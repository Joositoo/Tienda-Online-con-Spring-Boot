package org.example.tiendaonlinespringboot.Controller;

import org.example.tiendaonlinespringboot.Modelo.Historial;
import org.example.tiendaonlinespringboot.Service.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/historiales")
public class HistorialController {
    @Autowired
    private HistorialService historialService;

    @GetMapping("/listar")
    public ResponseEntity<Iterable<Historial>> getAll(){
        return ResponseEntity.ok(historialService.getHistoriales());
    }

    @GetMapping("/historial/{id}")
    public ResponseEntity<Optional<Historial>> getHistorialById(@PathVariable int id){
        return ResponseEntity.ok(historialService.getHistorialById(id));
    }

    @PostMapping("/alta")
    public ResponseEntity<Historial> saveOrUpdateHistorial(@RequestBody Historial historial){
        historialService.saveOrUpdate(historial);
        return ResponseEntity.ok(historial);
    }

    @DeleteMapping("/baja/{id}")
    public ResponseEntity<String> deleteHistorialById(@PathVariable int id){
        historialService.deleteById(id);
        return ResponseEntity.ok("Historial con id " +id+ " eliminado.");
    }
}
