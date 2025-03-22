package org.sistema_cursos.Dto.Curso;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CursoRequestDto {
    @NotEmpty(message = "El nombre del curso no puede estar vacío")
    private String nombre;
    @NotEmpty(message = "La descripción del curso no puede estar vacía")
    private String descripcion;
    @NotEmpty(message = "La duración del curso no puede estar vacía")
    private String duracion;

    public CursoRequestDto() {
    }

    public CursoRequestDto(String nombre, String descripcion, String duracion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}
