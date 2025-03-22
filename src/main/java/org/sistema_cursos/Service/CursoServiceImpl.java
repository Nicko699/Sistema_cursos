package org.sistema_cursos.Service;

import org.sistema_cursos.Dto.Curso.CursoRequestDto;
import org.sistema_cursos.Dto.Curso.CursoResponseDto;
import org.sistema_cursos.Dto.Curso.CursoResponseEstuDto;
import org.sistema_cursos.Exception.NotFoundException;
import org.sistema_cursos.Mapper.CursoMapper;
import org.sistema_cursos.Model.Curso;
import org.sistema_cursos.Repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoMapper cursoMapper;

    @Override
    public Page<CursoResponseDto> listaCursos(Pageable pageable) {

        Page<Curso> listaCursos = cursoRepository.findAll(pageable);

        List<CursoResponseDto> listaCursosResponseDto = new ArrayList<>();

        for (Curso curso : listaCursos) {

            CursoResponseDto cursoResponseDto = cursoMapper.CursoToCursoResponseDto(curso);

            listaCursosResponseDto.add(cursoResponseDto);

        }

        return new PageImpl<>(listaCursosResponseDto, pageable, listaCursos.getTotalElements());

    }

    @Override
    public CursoResponseDto obtenerCurso(Long id) throws NotFoundException {

        Optional<Curso> obtenerCurso = cursoRepository.findById(id);

        if (obtenerCurso.isPresent()) {

            return cursoMapper.CursoToCursoResponseDto(obtenerCurso.get());

        } else {
            throw new NotFoundException("Id del curso no encontrado:" + id);
        }


    }

    @Override
    public CursoResponseDto crearCurso(CursoRequestDto cursoRequestDto) {

        Curso curso = cursoMapper.cursoRequestDtoToCurso(cursoRequestDto);
        Curso cursoCreado = cursoRepository.save(curso);

        return cursoMapper.CursoToCursoResponseDto(cursoCreado);
    }

    @Override
    public CursoResponseDto editarCurso(Long id, CursoRequestDto cursoRequestDto) throws NotFoundException {

        Optional<Curso> obtenerCurso = cursoRepository.findById(id);

        if (obtenerCurso.isPresent()) {

            obtenerCurso.get().setNombre(cursoRequestDto.getNombre());
            obtenerCurso.get().setDescripcion(cursoRequestDto.getDescripcion());
            obtenerCurso.get().setDuracion(cursoRequestDto.getDuracion());

            Curso cursoGuardado = cursoRepository.save(obtenerCurso.get());

            return cursoMapper.CursoToCursoResponseDto(cursoGuardado);

        } else {

            throw new NotFoundException("Id del curso no encontrado:" + id);
        }


    }

    @Override
    public void eliminarCurso(Long id) throws NotFoundException {

        Optional<Curso> cursoObtenido = cursoRepository.findById(id);

        if (cursoObtenido.isPresent()) {

            cursoRepository.deleteById(id);
        } else {
            throw new NotFoundException("Id del curso no encontrado:" + id);
        }
    }
}
