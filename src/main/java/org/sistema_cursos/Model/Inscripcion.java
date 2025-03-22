package org.sistema_cursos.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaInscripcion;
    private String estado;
    @ManyToOne
    private Estudiante estudiante;
    @ManyToOne
    private Curso curso;

    public Inscripcion() {
    }

    public Inscripcion(Long id, LocalDate fechaInscripcion, String estado, Estudiante estudiante, Curso curso) {
        this.id = id;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
        this.estudiante = estudiante;
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

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
