package org.sistema_cursos.Dto.Curso;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.sistema_cursos.Dto.Inscripcion.InscripcionEstuResponseDto;
import org.sistema_cursos.Dto.Inscripcion.InscripcionInstResponseDto;
import org.sistema_cursos.Dto.Instructor.InstructorEstuResponseDto;
import org.sistema_cursos.Model.Inscripcion;
import org.sistema_cursos.Model.Instructor;

import java.util.List;

public class CursoResponseDto {

    private Long id;
    private String nombre;
    private String descripcion;
    private String duracion;
    private InstructorEstuResponseDto instructor;
    private List<InscripcionInstResponseDto> listaInscripciones;

    public CursoResponseDto() {
    }

    public CursoResponseDto(Long id, String nombre, String descripcion, String duracion, InstructorEstuResponseDto instructor, List<InscripcionInstResponseDto> listaInscripciones) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.instructor = instructor;
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

    public InstructorEstuResponseDto getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorEstuResponseDto instructor) {
        this.instructor = instructor;
    }

    public List<InscripcionInstResponseDto> getListaInscripciones() {
        return listaInscripciones;
    }

    public void setListaInscripciones(List<InscripcionInstResponseDto> listaInscripciones) {
        this.listaInscripciones = listaInscripciones;
    }
}
