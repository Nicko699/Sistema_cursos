package org.sistema_cursos.Service;

import org.sistema_cursos.Dto.Inscripcion.InscripcionEstuResponseDto;
import org.sistema_cursos.Dto.Inscripcion.InscripcionRequestDto;
import org.sistema_cursos.Exception.BadRequest;
import org.sistema_cursos.Exception.NotFoundException;
import org.sistema_cursos.Mapper.InscripcionMapper;
import org.sistema_cursos.Model.Curso;
import org.sistema_cursos.Model.Estudiante;
import org.sistema_cursos.Model.Inscripcion;
import org.sistema_cursos.Repository.CursoRepository;
import org.sistema_cursos.Repository.EstudianteRepository;
import org.sistema_cursos.Repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class InscripcionServiceImpl implements InscripcionService {
    @Autowired
    private InscripcionRepository inscripcionRepository;
    @Autowired
    private InscripcionMapper inscripcionMapper;
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private CursoRepository cursoRepository;


    @Override
    public InscripcionEstuResponseDto crearInscripcion(InscripcionRequestDto inscripcionRequestDto) throws NotFoundException, BadRequest {

        Inscripcion inscripcion = new Inscripcion();

        Optional<Estudiante> estudiante = estudianteRepository.findById(inscripcionRequestDto.getEstudianteId());

        if (estudiante.isPresent()) {

            inscripcion.setEstudiante(estudiante.get());
        } else {
            throw new NotFoundException("El id del estudiante no encontrado:" + inscripcionRequestDto.getEstudianteId());
        }

        if (!(estudiante.get().getListaInscripciones().size() >= 2)) {

            Optional<Curso> cursoEncontrado = cursoRepository.findById(inscripcionRequestDto.getCursoId());

            if ((cursoEncontrado.isPresent())) {
                inscripcion.setCurso(cursoEncontrado.get());
                inscripcion.setFechaInscripcion(LocalDate.now());
                inscripcion.setEstado("En ejecución");

                Inscripcion inscripcionGuardada = inscripcionRepository.save(inscripcion);

                return inscripcionMapper.InscripcionToInscripcionEstuResponseDto(inscripcionGuardada);

            } else {
                throw new NotFoundException("Id del curso no encontrado:" + inscripcionRequestDto.getCursoId());
            }
        } else {
            throw new BadRequest("Solo te puedes inscribir a 2 cursos a la vez");
        }


    }

    @Override
    public void eliminarInscripcion(Long id) throws NotFoundException {
        Optional<Inscripcion> inscripcion = inscripcionRepository.findById(id);

        if (inscripcion.isPresent()) {

            inscripcionRepository.findById(inscripcion.get().getId());
        } else {
            throw new NotFoundException("Id de la inscripción no encontrada");
        }

    }
}
