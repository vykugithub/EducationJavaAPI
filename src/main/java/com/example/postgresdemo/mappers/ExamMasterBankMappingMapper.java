package com.example.postgresdemo.mappers;

import com.example.postgresdemo.dto.ExamMasterBankMappingDTO;
import com.example.postgresdemo.model.ExamMasterBankMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ExamBankMapper.class)
public interface ExamMasterBankMappingMapper {
    ExamMasterBankMappingMapper INSTANCE = Mappers.getMapper(ExamMasterBankMappingMapper.class);

    @Mappings({
            @Mapping(source = "examMaster.eid", target = "eid"),
            @Mapping(source = "subjectDetails.sid", target = "sid"),
    })
    ExamMasterBankMappingDTO objToDto(ExamMasterBankMapping examMasterBankMapping);

    @Mappings({
            @Mapping(source = "eid", target = "examMaster.eid"),
            @Mapping(source = "sid", target = "subjectDetails.sid")
    })
    ExamMasterBankMapping dtoToObj(ExamMasterBankMappingDTO examMasterBankMappingDTO);
}
