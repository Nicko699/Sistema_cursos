package org.sistema_cursos.Dto.Curso;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.sistema_cursos.Dto.Inscripcion.InscripcionInstResponseDto;
import org.sistema_cursos.Model.Inscripcion;
import org.sistema_cursos.Model.Instructor;

import java.util.List;

public class CursoInstResponseDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private String duracion;
    private List<InscripcionInstResponseDto> listaInscripciones;

    public CursoInstResponseDto() {
    }

    public CursoInstResponseDto(Long id, String nombre, String descripcion, String duracion, List<InscripcionInstResponseDto> listaInscripciones) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
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

    public List<InscripcionInstResponseDto> getListaInscripciones() {
        return listaInscripciones;
    }

    public void setListaInscripciones(List<InscripcionInstResponseDto> listaInscripciones) {
        this.listaInscripciones = listaInscripciones;
    }
}
