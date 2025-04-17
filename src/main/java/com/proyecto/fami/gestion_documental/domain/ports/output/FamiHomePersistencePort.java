package com.proyecto.fami.gestion_documental.domain.ports.output;

import com.proyecto.fami.gestion_documental.domain.model.FamiHome;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface FamiHomePersistencePort {

    /**
     * Guarda o actualiza un hogar FAMI.
     */
    FamiHome save(FamiHome home);

    /**
     * Busca un hogar FAMI por su ID.
     */
    Optional<FamiHome> findById(String id);

    /**
     * Busca un hogar FAMI por el nombre de usuario de la madre comunitaria
     * solo si está activa (para login).
     */
    Optional<FamiHome> findByNombreUsuarioAndActivoTrue(String nombreUsuario);

    /**
     * Devuelve todos los hogares FAMI activos.
     */
    List<FamiHome> findAllByActivoTrue();

    /**
     * Devuelve todos los hogares FAMI activos con soporte de paginación.
     * Útil para manejar grandes volúmenes de datos.
     */
    Page<FamiHome> findAllByActivoTrue(Pageable pageable);

    /**
     * Busca hogares FAMI activos por municipio.
     */
    List<FamiHome> findByMunicipioAndActivoTrue(String municipio);

    /**
     * Busca hogares FAMI activos por regional.
     */
    List<FamiHome> findByRegionalAndActivoTrue(String regional);

    /**
     * Marca un hogar como inactivo (soft delete lógico).
     */
    void disableFamiHome(String id);

    /**
     * Marca como inactiva a la madre comunitaria asociada a un hogar FAMI.
     */
    void disableMadreComunitaria(String idFamiHome);

    /**
     * Actualiza solo la contraseña cifrada de la madre comunitaria.
     */
    void updatePassword(String id, String hashedPassword);

    /**
     * Actualiza únicamente los datos personales de la madre comunitaria.
     */
    void updateMadreComunitariaDatos(String idFamiHome, FamiHome.MadreComunitaria datosActualizados);

    /**
     * Verifica si ya existe una madre registrada con la misma cédula.
     */
    boolean existsByMadreComunitariaCedula(String cedula);

}
