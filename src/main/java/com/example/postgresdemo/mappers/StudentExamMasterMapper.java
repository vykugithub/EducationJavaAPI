package com.example.postgresdemo.mappers;

import com.example.postgresdemo.dto.StudentExamMasterDTO;
import com.example.postgresdemo.model.StudentExamMaster;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentExamMasterMapper {
    StudentExamMasterMapper INSTANCE = Mappers.getMapper(StudentExamMasterMapper.class);
    @Mappings({
            @Mapping(source = "student.stu_id", target = "stu_id"),
            @Mapping(source = "examMaster.eid", target = "eid"),
    })
    StudentExamMasterDTO objToDto(StudentExamMaster studentExamMaster);
    @Mappings({
            @Mapping(source = "stu_id", target = "student.stu_id"),
            @Mapping(source = "eid", target = "examMaster.eid"),

    })
    StudentExamMaster dtoToObj(StudentExamMasterDTO studentExamMasterDTO);
}
