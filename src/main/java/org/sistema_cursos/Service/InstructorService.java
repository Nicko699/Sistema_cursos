package org.sistema_cursos.Service;

import org.sistema_cursos.Dto.Instructor.InstructoRequestDto;
import org.sistema_cursos.Dto.Instructor.InstructorResponseDto;
import org.sistema_cursos.Exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InstructorService {

    public Page<InstructorResponseDto> listaInstructores(Pageable pageable);

    public InstructorResponseDto obtenerInstructor(Long id) throws NotFoundException;

    public InstructorResponseDto crearInstructor(InstructoRequestDto instructoRequestDto) throws NotFoundException;

    public InstructorResponseDto editarInstructor(Long id, InstructoRequestDto instructoRequestDto) throws NotFoundException;

    public void eliminarInstructor(Long id) throws NotFoundException;
}
