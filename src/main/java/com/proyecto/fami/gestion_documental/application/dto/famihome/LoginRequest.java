package com.proyecto.fami.gestion_documental.application.dto.famihome;

import lombok.Data;

@Data
public class LoginRequest {
    private String nombreUsuario;
    private String contraseña;
}
