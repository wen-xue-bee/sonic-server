package org.cloud.sonic.controller.models.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.cloud.sonic.controller.models.base.TypeConverter;
import org.cloud.sonic.controller.models.domain.TestCaseElements;

import java.io.Serializable;
import java.util.List;

@Schema(name = "用例页面控件DTO 模型")
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseElementsDTO implements Serializable, TypeConverter<TestCaseElementsDTO, TestCaseElements> {

    @Schema(description = "id", example = "1")
    Integer id;

    @Schema(description = "所属用例id", example = "1")
    Integer testcaseId;

    @NotBlank
    @Schema(description = "步骤id", required = true, example = "首页底部按钮")
    Integer stepId;

    @Schema(description = "控件id", required = true, example = "xpath")
    Integer elementId;

    @Schema(description = "控件值", required = false, example = "//@[text()='home']")
    String eleParamkey;


    @Schema(description = "直接值内容", required = false, example = "1")
    String eleParamvalue;

    @Schema(description = "控件内容", required = false, example = "1")
    String eleValue;

    @Schema(description = "控件类型", required = false, example = "1")
    String eleType;

    @Schema(description = "控件名称", required = false, example = "1")
    String eleName;

    @JSONField(serialize = false)
    ModulesDTO modulesDTO;

    //因为一个控件可以存在于多个步骤，也可以一个步骤有多个同样的控件，所以是多对多关系
    @JsonIgnore
    @JSONField(serialize = false)
    List<StepsDTO> steps;
}
