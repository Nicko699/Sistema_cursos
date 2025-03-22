package org.sistema_cursos.Dto.Inscripcion;

import org.sistema_cursos.Dto.Curso.CursoResponseEstuDto;

import java.time.LocalDate;

public class InscripcionEstuResponseDto {

    private Long id;
    private LocalDate fechaInscripcion;
    private String estado;
    private CursoResponseEstuDto curso;

    public InscripcionEstuResponseDto() {
    }

    public InscripcionEstuResponseDto(Long id, LocalDate fechaInscripcion, String estado, CursoResponseEstuDto curso) {
        this.id = id;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public CursoResponseEstuDto getCurso() {
        return curso;
    }

    public void setCurso(CursoResponseEstuDto curso) {
        this.curso = curso;
    }
}
