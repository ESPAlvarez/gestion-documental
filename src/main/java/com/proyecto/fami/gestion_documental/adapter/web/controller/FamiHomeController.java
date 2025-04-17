package com.proyecto.fami.gestion_documental.adapter.web.controller;

import com.proyecto.fami.gestion_documental.application.dto.LoginRequest;
import com.proyecto.fami.gestion_documental.domain.model.FamiHome;
import com.proyecto.fami.gestion_documental.domain.ports.input.FamiHomeServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fami-home")
public class FamiHomeController {

    private final FamiHomeServicePort famiHomeService;

    public FamiHomeController(FamiHomeServicePort famiHomeService) {
        this.famiHomeService = famiHomeService;
    }

    @PostMapping("/registro")
    public ResponseEntity<FamiHome> registrar(@RequestBody FamiHome famiHome) {
        return ResponseEntity.ok(famiHomeService.registrar(famiHome));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return famiHomeService.login(request.getNombreUsuario(), request.getContraseña())
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(401).body("Credenciales inválidas"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamiHome> obtenerPorId(@PathVariable String id) {
        return famiHomeService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/activos")
    public List<FamiHome> listarActivos() {
        return famiHomeService.obtenerTodos();
    }

    @PutMapping("/{id}/perfil")
    public void actualizarPerfil(@PathVariable String id, @RequestBody FamiHome.MadreComunitaria datos) {
        famiHomeService.actualizarPerfil(id, datos);
    }

    @PatchMapping("/{id}/contraseña")
    public void actualizarContraseña(@PathVariable String id, @RequestBody String nuevaContraseña) {
        famiHomeService.actualizarContraseña(id, nuevaContraseña);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        famiHomeService.eliminarLogicamente(id);
    }
}