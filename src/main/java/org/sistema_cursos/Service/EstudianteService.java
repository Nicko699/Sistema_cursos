package org.sistema_cursos.Service;

import org.sistema_cursos.Dto.Estudiante.EstudianteRequestDto;
import org.sistema_cursos.Dto.Estudiante.EstudianteRespondeCreaEditDto;
import org.sistema_cursos.Dto.Estudiante.EstudianteResponseDto;
import org.sistema_cursos.Exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EstudianteService {

    public Page<EstudianteResponseDto> listaEstudiantes(Pageable pageable);

    public EstudianteResponseDto obtenerestudiante(Long id) throws NotFoundException;

    public EstudianteRespondeCreaEditDto crearEstudiante(EstudianteRequestDto estudianteRequestDto);

    public EstudianteRespondeCreaEditDto editarEstudiante(Long id, EstudianteRequestDto estudianteRequestDto) throws NotFoundException;

    public void eliminarEstudiante(Long id) throws NotFoundException;
}
