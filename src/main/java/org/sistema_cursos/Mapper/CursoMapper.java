package org.sistema_cursos.Mapper;

import org.mapstruct.Mapper;
import org.sistema_cursos.Dto.Curso.CursoRequestDto;
import org.sistema_cursos.Dto.Curso.CursoResponseDto;
import org.sistema_cursos.Dto.Curso.CursoResponseEstuDto;
import org.sistema_cursos.Model.Curso;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    Curso cursoRequestDtoToCurso(CursoRequestDto cursoRequestDto);

    CursoResponseEstuDto CursoToCursoResponseEstDto(Curso curso);

    CursoResponseDto CursoToCursoResponseDto(Curso curso);
}
