package org.sistema_cursos.Dto.Curso;

import org.sistema_cursos.Dto.Instructor.InstructorEstuResponseDto;

public class CursoResponseEstuDto {

    private Long id;
    private String nombre;
    private String descripcion;
    private String duracion;
    private InstructorEstuResponseDto instructor;


    public CursoResponseEstuDto() {
    }

    public CursoResponseEstuDto(Long id, String nombre, String descripcion, String duracion, InstructorEstuResponseDto instructor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.instructor = instructor;
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
}
