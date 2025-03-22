package org.sistema_cursos.Dto.Instructor;

public class InstructorEstuResponseDto {


    private String nombre;
    private String apellido;

    public InstructorEstuResponseDto() {
    }

    public InstructorEstuResponseDto(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
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
}
