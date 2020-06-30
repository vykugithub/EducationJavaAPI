package com.example.postgresdemo.mappers;

import com.example.postgresdemo.dto.StudentExamDetailsDTO;
import com.example.postgresdemo.dto.SubjectDetailsDTO;
import com.example.postgresdemo.model.StudentExamDetails;
import com.example.postgresdemo.model.SubjectDetails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentExamDetailsMapper {
    StudentExamDetailsMapper INSTANCE = Mappers.getMapper(StudentExamDetailsMapper.class);
    StudentExamDetailsDTO objToDto(StudentExamDetails studentExamDetails);
    StudentExamDetails dtoToObj(StudentExamDetailsDTO studentExamDetailsDTO);
}
