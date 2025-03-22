package org.sistema_cursos.Service;

import org.sistema_cursos.Dto.Instructor.InstructoRequestDto;
import org.sistema_cursos.Dto.Instructor.InstructorEstuResponseDto;
import org.sistema_cursos.Dto.Instructor.InstructorResponseDto;
import org.sistema_cursos.Exception.NotFoundException;
import org.sistema_cursos.Mapper.InstructorMapper;
import org.sistema_cursos.Model.Curso;
import org.sistema_cursos.Model.Instructor;
import org.sistema_cursos.Repository.CursoRepository;
import org.sistema_cursos.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private InstructorMapper instructorMapper;
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Page<InstructorResponseDto> listaInstructores(Pageable pageable) {

        Page<Instructor> listaInstructores = instructorRepository.findAll(pageable);

        List<InstructorResponseDto> listaInstructoresDto = new ArrayList<>();

        for (Instructor instructor : listaInstructores) {

            InstructorResponseDto instructorDto = instructorMapper.instructorToInstructorResponseDto(instructor);

            listaInstructoresDto.add(instructorDto);
        }

        return new PageImpl<>(listaInstructoresDto, pageable, listaInstructores.getTotalElements());
    }

    @Override
    public InstructorResponseDto obtenerInstructor(Long id) throws NotFoundException {

        Optional<Instructor> instructor = instructorRepository.findById(id);
        if (instructor.isPresent()) {

            return instructorMapper.instructorToInstructorResponseDto(instructor.get());
        } else {
            throw new NotFoundException("Id del instructor no encontrado:" + id);
        }

    }

    @Override
    public InstructorResponseDto crearInstructor(InstructoRequestDto instructoRequestDto) throws NotFoundException {

        Instructor instructor = instructorMapper.InstructorRequestDtoToInstructor(instructoRequestDto);

        List<Curso> listaCursosEncontrados = new ArrayList<>();

        for (Curso curso : instructor.getListaCursos()) {

            Optional<Curso> cursoEncontrado = cursoRepository.findById(curso.getId());

            if (cursoEncontrado.isPresent()) {

                listaCursosEncontrados.add(cursoEncontrado.get());

            } else {
                throw new NotFoundException("Id del curso no encontrado:" + curso.getId());
            }

        }

        instructor.setListaCursos(listaCursosEncontrados);

        Instructor instructorGuardado = instructorRepository.save(instructor);


        for (Curso curso : instructorGuardado.getListaCursos()) {

            curso.setInstructor(instructor);

            cursoRepository.save(curso);

        }


        return instructorMapper.instructorToInstructorResponseDto(instructorGuardado);
    }

    @Override
    public InstructorResponseDto editarInstructor(Long id, InstructoRequestDto instructoRequestDto) throws NotFoundException {

        Optional<Instructor> instructor = instructorRepository.findById(id);

        if (instructor.isPresent()) {

            instructor.get().setNombre(instructoRequestDto.getNombre());
            instructor.get().setApellido(instructoRequestDto.getApellido());
            instructor.get().setCelular(instructoRequestDto.getCelular());
            instructor.get().setEmail(instructoRequestDto.getEmail());

            Instructor instructorEditado = instructorRepository.save(instructor.get());

            return instructorMapper.instructorToInstructorResponseDto(instructorEditado);
        }
        throw new NotFoundException("Id del instructor no encontrado:" + id);

    }

    @Override
    public void eliminarInstructor(Long id) throws NotFoundException {

        Optional<Instructor> instructor = instructorRepository.findById(id);

        if (instructor.isPresent()) {

            instructorRepository.deleteById(instructor.get().getId());
        } else {
            throw new NotFoundException("Id del instructor no encontrado:" + id);
        }

    }
}
