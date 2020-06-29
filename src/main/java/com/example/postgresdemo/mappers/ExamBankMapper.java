package com.example.postgresdemo.mappers;

import com.example.postgresdemo.dto.ExamBankDTO;
import com.example.postgresdemo.model.ExamBank;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExamBankMapper {
    ExamBankMapper INSTANCE = Mappers.getMapper(ExamBankMapper.class);

    @Mappings({
            @Mapping(source = "examMasterBankMapping.examMaster.classDetails.cid", target = "cid"),
            @Mapping(source = "examMasterBankMapping.subjectDetails.sid", target = "sid")
    }
    )
    ExamBankDTO objToDto(ExamBank examBank);

    @Mappings({
            @Mapping(source = "cid", target = "examMasterBankMapping.examMaster.classDetails.cid"),
            @Mapping(source = "sid", target = "examMasterBankMapping.subjectDetails.sid")
    }
    )
    ExamBank dtoToObj(ExamBankDTO examBankDTO);
}
