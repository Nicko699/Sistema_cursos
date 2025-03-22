package org.sistema_cursos.Mapper;

import org.mapstruct.Mapper;
import org.sistema_cursos.Dto.Estudiante.EstudianteRequestDto;
import org.sistema_cursos.Dto.Estudiante.EstudianteRespondeCreaEditDto;
import org.sistema_cursos.Dto.Estudiante.EstudianteResponseDto;
import org.sistema_cursos.Model.Estudiante;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {

    Estudiante EstudianteRequestDtoToEstudiante(EstudianteRequestDto estudianteRequestDto);

    EstudianteResponseDto estudianteToEstudianteResponseDto(Estudiante estudiante);

    EstudianteRespondeCreaEditDto estudianteToEstudianteCrearResponseDto(Estudiante estudiante);


}
