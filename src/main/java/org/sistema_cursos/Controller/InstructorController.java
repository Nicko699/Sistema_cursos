package org.sistema_cursos.Controller;

import jakarta.validation.Valid;
import org.sistema_cursos.Dto.Instructor.InstructoRequestDto;
import org.sistema_cursos.Dto.Instructor.InstructorResponseDto;
import org.sistema_cursos.Exception.NotFoundException;
import org.sistema_cursos.Service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @GetMapping
    public ResponseEntity<Page<InstructorResponseDto>> listaInstructores(Pageable pageable) {

        Page<InstructorResponseDto> listaInstructores = instructorService.listaInstructores(pageable);

        return ResponseEntity.ok(listaInstructores);

    }

    @GetMapping("/{id}")
    public ResponseEntity<InstructorResponseDto> obtenerInstructor(@PathVariable Long id) throws NotFoundException {

        InstructorResponseDto obtenerInstructor = instructorService.obtenerInstructor(id);

        return ResponseEntity.ok(obtenerInstructor);

    }


    @PostMapping
    public ResponseEntity<InstructorResponseDto> crearInstructor(@Valid @RequestBody InstructoRequestDto instructoRequestDto) throws NotFoundException {

        InstructorResponseDto crearInstructor = instructorService.crearInstructor(instructoRequestDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(crearInstructor.getId()).toUri();

        return ResponseEntity.created(location).body(crearInstructor);

    }

    @PutMapping("/{id}")
    public ResponseEntity<InstructorResponseDto> editarInstructor(@PathVariable Long id, @Valid @RequestBody InstructoRequestDto instructoRequestDto) throws NotFoundException {

        InstructorResponseDto editarInstructor = instructorService.editarInstructor(id, instructoRequestDto);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InstructorResponseDto> eliminarInstructor(@PathVariable Long id) throws NotFoundException {

        instructorService.eliminarInstructor(id);

        return ResponseEntity.noContent().build();


    }

}
