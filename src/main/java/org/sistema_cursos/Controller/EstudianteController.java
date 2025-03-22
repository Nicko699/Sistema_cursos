package org.sistema_cursos.Controller;

import jakarta.validation.Valid;
import org.sistema_cursos.Dto.Estudiante.EstudianteRequestDto;
import org.sistema_cursos.Dto.Estudiante.EstudianteRespondeCreaEditDto;
import org.sistema_cursos.Dto.Estudiante.EstudianteResponseDto;
import org.sistema_cursos.Exception.NotFoundException;
import org.sistema_cursos.Service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public ResponseEntity<Page<EstudianteResponseDto>> listaEstudiantes(Pageable pageable) {

        Page<EstudianteResponseDto> listaEstudianteResponseDto = estudianteService.listaEstudiantes(pageable);

        return ResponseEntity.ok(listaEstudianteResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteResponseDto> obtenerEstudiante(@PathVariable Long id) throws NotFoundException {

        EstudianteResponseDto obtenerEstudianteDto = estudianteService.obtenerestudiante(id);

        return ResponseEntity.ok(obtenerEstudianteDto);
    }

    @PostMapping
    public ResponseEntity<EstudianteRespondeCreaEditDto> crearEstudiante(@Valid @RequestBody EstudianteRequestDto estudianteRequestDto) {

        EstudianteRespondeCreaEditDto crearEstudiante = estudianteService.crearEstudiante(estudianteRequestDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id").buildAndExpand(crearEstudiante.getId()).toUri();

        return ResponseEntity.created(location).body(crearEstudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteRespondeCreaEditDto> editarEstudiante(@PathVariable Long id, @Valid @RequestBody EstudianteRequestDto estudianteRequestDto) throws NotFoundException {

        EstudianteRespondeCreaEditDto editarEstudiante = estudianteService.editarEstudiante(id, estudianteRequestDto);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EstudianteResponseDto> eliminarEstudiante(@PathVariable Long id) throws NotFoundException {

        estudianteService.eliminarEstudiante(id);

        return ResponseEntity.noContent().build();

    }
}
