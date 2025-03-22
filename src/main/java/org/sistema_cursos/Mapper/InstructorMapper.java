package org.sistema_cursos.Mapper;

import org.mapstruct.Mapper;
import org.sistema_cursos.Dto.Instructor.InstructoRequestDto;
import org.sistema_cursos.Dto.Instructor.InstructorEstuResponseDto;
import org.sistema_cursos.Dto.Instructor.InstructorResponseDto;
import org.sistema_cursos.Model.Instructor;

@Mapper(componentModel = "spring")
public interface InstructorMapper {

    Instructor InstructorRequestDtoToInstructor(InstructoRequestDto instructoRequestDto);

    InstructorResponseDto instructorToInstructorResponseDto(Instructor instructor);

}
