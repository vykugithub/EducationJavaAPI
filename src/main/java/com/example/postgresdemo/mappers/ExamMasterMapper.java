package com.example.postgresdemo.mappers;

import com.example.postgresdemo.dto.ExamMasterDTO;
import com.example.postgresdemo.model.ExamMaster;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ExamMasterBankMappingMapper.class)
public interface ExamMasterMapper {
    ExamMasterMapper INSTANCE = Mappers.getMapper(ExamMasterMapper.class);

    @Mappings({
            @Mapping(source = "classDetails.cid", target = "cid")
    })
    ExamMasterDTO objToDto(ExamMaster examMaster);
    @Mappings({
            @Mapping(source = "cid", target = "classDetails.cid")
    })
    ExamMaster dtoToObj(ExamMasterDTO examMasterDTO);
}
