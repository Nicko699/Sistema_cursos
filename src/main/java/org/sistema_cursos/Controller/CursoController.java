package org.sistema_cursos.Controller;

import jakarta.validation.Valid;
import org.sistema_cursos.Dto.Curso.CursoRequestDto;
import org.sistema_cursos.Dto.Curso.CursoResponseDto;
import org.sistema_cursos.Exception.NotFoundException;
import org.sistema_cursos.Model.Curso;
import org.sistema_cursos.Service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<Page<CursoResponseDto>> listaCursos(Pageable pageable) {

        Page<CursoResponseDto> listaCursos = cursoService.listaCursos(pageable);

        return ResponseEntity.ok(listaCursos);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDto> obtenerCurso(@PathVariable Long id) throws NotFoundException {

        CursoResponseDto cursoResponseDto = cursoService.obtenerCurso(id);

        return ResponseEntity.ok(cursoResponseDto);

    }

    @PostMapping
    public ResponseEntity<CursoResponseDto> crearCurso(@Valid @RequestBody CursoRequestDto cursoRequestDto) {

        CursoResponseDto cursoResponseDto = cursoService.crearCurso(cursoRequestDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
                .buildAndExpand(cursoResponseDto.getId()).toUri();

        return ResponseEntity.created(location).body(cursoResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponseDto> editarCurso(@PathVariable Long id, @Valid @RequestBody CursoRequestDto cursoRequestDto) throws NotFoundException {

        CursoResponseDto cursoEditado = cursoService.editarCurso(id, cursoRequestDto);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CursoResponseDto> eliminarCurso(@PathVariable Long id) throws NotFoundException {
        cursoService.eliminarCurso(id);

        return ResponseEntity.noContent().build();
    }


}
