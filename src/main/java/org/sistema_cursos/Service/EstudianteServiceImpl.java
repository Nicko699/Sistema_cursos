package org.sistema_cursos.Service;

import org.sistema_cursos.Dto.Estudiante.EstudianteRequestDto;
import org.sistema_cursos.Dto.Estudiante.EstudianteRespondeCreaEditDto;
import org.sistema_cursos.Dto.Estudiante.EstudianteResponseDto;
import org.sistema_cursos.Exception.NotFoundException;
import org.sistema_cursos.Mapper.EstudianteMapper;
import org.sistema_cursos.Model.Estudiante;
import org.sistema_cursos.Repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private EstudianteMapper estudianteMapper;

    @Override
    public Page<EstudianteResponseDto> listaEstudiantes(Pageable pageable) {

        Page<Estudiante> listaEstudiantes = estudianteRepository.findAll(pageable);

        List<EstudianteResponseDto> listaEstudiantesDto = new ArrayList<>();

        for (Estudiante estudiante : listaEstudiantes) {

            EstudianteResponseDto estudiantesDto = estudianteMapper.estudianteToEstudianteResponseDto(estudiante);

            listaEstudiantesDto.add(estudiantesDto);

        }

        return new PageImpl<>(listaEstudiantesDto, pageable, listaEstudiantes.getTotalElements());
    }

    @Override
    public EstudianteResponseDto obtenerestudiante(Long id) throws NotFoundException {

        Optional<Estudiante> estudiante = estudianteRepository.findById(id);

        if (estudiante.isPresent()) {

            return estudianteMapper.estudianteToEstudianteResponseDto(estudiante.get());

        } else {
            throw new NotFoundException("Id del estudiante no encontrado:" + id);
        }

    }

    @Override
    public EstudianteRespondeCreaEditDto crearEstudiante(EstudianteRequestDto estudianteRequestDto) {

        Estudiante estudiante = estudianteMapper.EstudianteRequestDtoToEstudiante(estudianteRequestDto);

        Estudiante estudianteGuardado = estudianteRepository.save(estudiante);

        return estudianteMapper.estudianteToEstudianteCrearResponseDto(estudianteGuardado);

    }

    @Override
    public EstudianteRespondeCreaEditDto editarEstudiante(Long id, EstudianteRequestDto estudianteRequestDto) throws NotFoundException {

        Optional<Estudiante> estudiante = estudianteRepository.findById(id);

        if (estudiante.isPresent()) {

            estudiante.get().setNombre(estudianteRequestDto.getNombre());
            estudiante.get().setApellido(estudianteRequestDto.getApellido());
            estudiante.get().setCelular(estudianteRequestDto.getCelular());
            estudiante.get().setEdad(estudianteRequestDto.getEdad());
            estudiante.get().setEmail(estudianteRequestDto.getEmail());


            Estudiante estudianteEditado = estudianteRepository.save(estudiante.get());

            return estudianteMapper.estudianteToEstudianteCrearResponseDto(estudianteEditado);

        } else {
            throw new NotFoundException("Id del estudiante no encontrado:" + id);
        }

    }

    @Override
    public void eliminarEstudiante(Long id) throws NotFoundException {

        Optional<Estudiante> estudiante = estudianteRepository.findById(id);

        if (estudiante.isPresent()) {

            estudianteRepository.deleteById(id);
        } else {
            throw new NotFoundException("id del estudiante no encontrado:" + id);
        }


    }
}
