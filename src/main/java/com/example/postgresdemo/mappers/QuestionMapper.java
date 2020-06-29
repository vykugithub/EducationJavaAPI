package com.example.postgresdemo.mappers;

import com.example.postgresdemo.dto.QuestionDTO;
import com.example.postgresdemo.model.QuestionBank;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = AnswerMapper.class)
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    @Mappings({
            @Mapping(source = "classDetails.cid", target = "cid"),
            @Mapping(source = "subjectDetails.sid", target = "sid"),
            @Mapping(source = "answersBank", target = "answers"),
    }
    )
    QuestionDTO objToDto(QuestionBank questionBank);

    @Mappings({
            @Mapping(source = "cid", target = "classDetails.cid"),
            @Mapping(source = "sid", target = "subjectDetails.sid"),
            @Mapping(source = "answers", target = "answersBank"),
    }
    )
    QuestionBank dtoToObj(QuestionDTO questionDTO);
}
