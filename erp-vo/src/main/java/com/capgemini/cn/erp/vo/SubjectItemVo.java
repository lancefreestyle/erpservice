package com.capgemini.cn.erp.vo;

import java.io.Serializable;

public class SubjectItemVo implements Serializable {

    private String id;

    private String constantValue;

    private String mappingStructureId;

    private String mappingStructureName;

    private String mappingValue;

    private String sourceType;

    private String sourceValue;

    private String subjectSegment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConstantValue() {
        return constantValue;
    }

    public void setConstantValue(String constantValue) {
        this.constantValue = constantValue;
    }

    public String getMappingStructureId() {
        return mappingStructureId;
    }

    public void setMappingStructureId(String mappingStructureId) {
        this.mappingStructureId = mappingStructureId;
    }

    public String getMappingStructureName() {
        return mappingStructureName;
    }

    public void setMappingStructureName(String mappingStructureName) {
        this.mappingStructureName = mappingStructureName;
    }

    public String getMappingValue() {
        return mappingValue;
    }

    public void setMappingValue(String mappingValue) {
        this.mappingValue = mappingValue;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getSourceValue() {
        return sourceValue;
    }

    public void setSourceValue(String sourceValue) {
        this.sourceValue = sourceValue;
    }

    public String getSubjectSegment() {
        return subjectSegment;
    }

    public void setSubjectSegment(String subjectSegment) {
        this.subjectSegment = subjectSegment;
    }
}
