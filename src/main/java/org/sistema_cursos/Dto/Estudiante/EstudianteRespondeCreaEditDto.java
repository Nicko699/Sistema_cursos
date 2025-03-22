package org.sistema_cursos.Dto.Estudiante;

public class EstudianteRespondeCreaEditDto {
    private Long id;
    private String nombre;
    private String apellido;
    private Long edad;
    private String email;
    private String celular;

    public EstudianteRespondeCreaEditDto() {
    }

    public EstudianteRespondeCreaEditDto(Long id, String nombre, String apellido, Long edad, String email, String celular) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
        this.celular = celular;
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
