package org.sistema_cursos.Dto.Estudiante;

import org.sistema_cursos.Dto.Inscripcion.InscripcionEstuResponseDto;

import java.util.List;

public class EstudianteResponseDto {

    private Long id;
    private String nombre;
    private String apellido;
    private List<InscripcionEstuResponseDto> listaInscripciones;

    public EstudianteResponseDto() {
    }

    public EstudianteResponseDto(Long id, String nombre, String apellido, List<InscripcionEstuResponseDto> listaInscripciones) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.listaInscripciones = listaInscripciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<InscripcionEstuResponseDto> getListaInscripciones() {
        return listaInscripciones;
    }

    public void setListaInscripciones(List<InscripcionEstuResponseDto> listaInscripciones) {
        this.listaInscripciones = listaInscripciones;
    }
}
