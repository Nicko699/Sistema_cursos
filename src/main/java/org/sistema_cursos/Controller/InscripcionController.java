package org.sistema_cursos.Controller;

import org.sistema_cursos.Dto.Inscripcion.InscripcionEstuResponseDto;
import org.sistema_cursos.Dto.Inscripcion.InscripcionRequestDto;
import org.sistema_cursos.Exception.BadRequest;
import org.sistema_cursos.Exception.NotFoundException;
import org.sistema_cursos.Service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequestMapping("/inscripcion")
@RestController
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;

    @PostMapping
    public ResponseEntity<InscripcionEstuResponseDto> crearInscripcion(@RequestBody InscripcionRequestDto inscripcionRequestDto) throws BadRequest, NotFoundException {

        InscripcionEstuResponseDto inscripcionCreada = inscripcionService.crearInscripcion(inscripcionRequestDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(inscripcionCreada.getId()).toUri();

        return ResponseEntity.created(location).body(inscripcionCreada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InscripcionEstuResponseDto> eliminarInscripcion(@PathVariable Long id) throws NotFoundException {

        inscripcionService.eliminarInscripcion(id);

        return ResponseEntity.noContent().build();
    }
}
