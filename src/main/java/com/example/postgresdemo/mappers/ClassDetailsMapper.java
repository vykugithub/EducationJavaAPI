package com.example.postgresdemo.mappers;

import com.example.postgresdemo.dto.ClassDetailsDTO;
import com.example.postgresdemo.model.ClassDetails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClassDetailsMapper {

    ClassDetailsMapper INSTANCE = Mappers.getMapper(ClassDetailsMapper.class);
    ClassDetailsDTO objToDto(ClassDetails classDetails);
    ClassDetails dtoToObj(ClassDetailsDTO classDetailsDTO);
}
