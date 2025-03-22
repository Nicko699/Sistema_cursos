package org.sistema_cursos.Dto.Inscripcion;

import jakarta.persistence.ManyToOne;
import org.sistema_cursos.Dto.Estudiante.EstudianteInstResponseDto;
import org.sistema_cursos.Model.Curso;
import org.sistema_cursos.Model.Estudiante;

import java.time.LocalDate;

public class InscripcionInstResponseDto {

    private EstudianteInstResponseDto estudiante;

    public InscripcionInstResponseDto() {
    }

    public InscripcionInstResponseDto(EstudianteInstResponseDto estudiante) {
        this.estudiante = estudiante;
    }

    public EstudianteInstResponseDto getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteInstResponseDto estudiante) {
        this.estudiante = estudiante;
    }
}
