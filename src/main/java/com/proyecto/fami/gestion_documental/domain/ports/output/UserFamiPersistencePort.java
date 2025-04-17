package com.proyecto.fami.gestion_documental.domain.ports.output;

import com.proyecto.fami.gestion_documental.domain.model.UserFami;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserFamiPersistencePort {

    UserFami save(UserFami user);
    Optional<UserFami> findById(String id);
    boolean existsByNuip(Integer nuip);
    void marcarInactivo(String id);
    void actualizarParcial(String id, UserFami datosParciales);
    Page<UserFami> findAllActivos(Pageable pageable);
    Page<UserFami> findByHogarFamiIdAndActivoTrue(String idHogarFami, Pageable pageable);
    Page<UserFami> findByTipoUsuario(String tipoUsuario, Pageable pageable);
    Page<UserFami> buscarPorFiltros(String idHogarFami, String tipoUsuario, boolean soloActivos, Pageable pageable);
}
