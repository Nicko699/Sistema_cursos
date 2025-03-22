package org.sistema_cursos.Service;

import org.sistema_cursos.Dto.Inscripcion.InscripcionEstuResponseDto;
import org.sistema_cursos.Dto.Inscripcion.InscripcionRequestDto;
import org.sistema_cursos.Exception.BadRequest;
import org.sistema_cursos.Exception.NotFoundException;

public interface InscripcionService {

    public InscripcionEstuResponseDto crearInscripcion(InscripcionRequestDto inscripcionRequestDto) throws NotFoundException, BadRequest;

    public void eliminarInscripcion(Long id) throws NotFoundException;


}
