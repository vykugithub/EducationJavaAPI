package com.example.postgresdemo.mappers;

import com.example.postgresdemo.dto.StudentDTO;
import com.example.postgresdemo.dto.SubjectDetailsDTO;
import com.example.postgresdemo.model.Student;
import com.example.postgresdemo.model.SubjectDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
    @Mappings({
            @Mapping(source = "classDetails.cid", target = "cid")
    })
    StudentDTO objToDto(Student student);
    @Mappings({
            @Mapping(source = "cid", target = "classDetails.cid")
    })
    Student dtoToObj(StudentDTO studentDTO);
}
