package org.sistema_cursos.Dto.Estudiante;


import jakarta.validation.constraints.*;

public class EstudianteRequestDto {

    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;
    @NotEmpty(message = "El apellido no puede estar vacío")
    private String apellido;
    @NotNull(message = "La edad no puede estar vacía")
    private Long edad;
    @NotEmpty(message = "El email no puede estar vacío")
    @Email(message = "El email debe tener un formato correcto")
    private String email;
    @NotEmpty(message = "El numero de celular no puede estar vacío")
    @Size(min = 10, max = 10, message = "El numero de celular debe ser de 10 digitos")
    private String celular;


    public EstudianteRequestDto() {
    }

    public EstudianteRequestDto(String nombre, String apellido, Long edad, String email, String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
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

    public Long getEdad() {
        return edad;
    }

    public void setEdad(Long edad) {
        this.edad = edad;
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
