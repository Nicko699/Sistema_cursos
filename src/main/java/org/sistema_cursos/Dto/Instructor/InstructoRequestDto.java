package org.sistema_cursos.Dto.Instructor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.sistema_cursos.Dto.Curso.CursoInstResponseDto;


import java.util.List;

public class InstructoRequestDto {

    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;
    @NotEmpty(message = "El apellido no puede estar vacío")
    private String apellido;
    @NotEmpty(message = "El email no puede estar vacío")
    @Email(message = "El email debe de tener un formato válido")
    private String email;
    @NotNull(message = "El numero de celular no puede estar vacío")
    @Size(min = 10, max = 10, message = "El numero de celular debe de tener 10 digitos")
    private String celular;
    private List<CursoInstResponseDto> listaCursos;

    public InstructoRequestDto() {
    }

    public InstructoRequestDto(String nombre, String apellido, String email, String celular, List<CursoInstResponseDto> listaCursos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;
        this.listaCursos = listaCursos;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public List<CursoInstResponseDto> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<CursoInstResponseDto> listaCursos) {
        this.listaCursos = listaCursos;
    }
}
