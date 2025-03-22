package org.sistema_cursos.Service;

import org.sistema_cursos.Dto.Curso.CursoRequestDto;
import org.sistema_cursos.Dto.Curso.CursoResponseDto;
import org.sistema_cursos.Dto.Curso.CursoResponseEstuDto;
import org.sistema_cursos.Exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CursoService {


    public Page<CursoResponseDto> listaCursos(Pageable pageable);

    public CursoResponseDto obtenerCurso(Long id) throws NotFoundException;

    public CursoResponseDto crearCurso(CursoRequestDto cursoRequestDto);

    public CursoResponseDto editarCurso(Long id, CursoRequestDto cursoRequestDto) throws NotFoundException;

    public void eliminarCurso(Long id) throws NotFoundException;


}
