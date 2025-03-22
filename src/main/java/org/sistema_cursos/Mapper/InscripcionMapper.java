package org.sistema_cursos.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema_cursos.Dto.Inscripcion.InscripcionEstuResponseDto;
import org.sistema_cursos.Dto.Inscripcion.InscripcionRequestDto;
import org.sistema_cursos.Model.Inscripcion;

@Mapper(componentModel = "spring")
public interface InscripcionMapper {

    InscripcionEstuResponseDto InscripcionToInscripcionEstuResponseDto(Inscripcion inscripcion);


}
