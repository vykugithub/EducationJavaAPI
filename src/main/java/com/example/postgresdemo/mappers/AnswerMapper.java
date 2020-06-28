package com.example.postgresdemo.mappers;

import com.example.postgresdemo.dto.AnswerDTO;
import com.example.postgresdemo.model.AnswersBank;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses=QuestionMapper.class)
public interface AnswerMapper {
    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);
    AnswerDTO objToDto(AnswersBank classDetails);
    AnswersBank dtoToObj(AnswerDTO classDetailsDTO);
}
