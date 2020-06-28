package com.example.postgresdemo.mappers;

import com.example.postgresdemo.dto.SubjectDetailsDTO;
import com.example.postgresdemo.model.SubjectDetails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectDetailsMapper {
    SubjectDetailsMapper INSTANCE = Mappers.getMapper(SubjectDetailsMapper.class);

    SubjectDetailsDTO objToDto(SubjectDetails subjectDetails);

    SubjectDetails dtoToObj(SubjectDetailsDTO subjectDetailsDTO);
}
