package org.sistema_cursos.Dto.Instructor;
import org.sistema_cursos.Dto.Curso.CursoInstResponseDto;


import java.util.List;

public class InstructorResponseDto {

    private Long id;
    private String nombre;
    private String apellido;
    private List<CursoInstResponseDto> listaCursos;

    public InstructorResponseDto() {
    }

    public InstructorResponseDto(Long id, String nombre, String apellido, List<CursoInstResponseDto> listaCursos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.listaCursos = listaCursos;
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

    public List<CursoInstResponseDto> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<CursoInstResponseDto> listaCursos) {
        this.listaCursos = listaCursos;
    }
}
