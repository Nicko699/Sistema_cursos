package org.sistema_cursos.Dto.Estudiante;

public class EstudianteInstResponseDto {

    private String nombre;
    private String apellido;
    private String email;
    private String celular;

    public EstudianteInstResponseDto() {
    }

    public EstudianteInstResponseDto(String nombre, String apellido, String email, String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;
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
}
