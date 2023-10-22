package com.comprayahorraback.marketplace.configurations;

import java.sql.Date;
import java.time.LocalDate;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date>{
    
    @Override
    public Date convertToDatabaseColumn(LocalDate attribute) {
        return (attribute == null) ? null : Date.valueOf(attribute);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date dbData) {
        return (dbData == null) ? null : dbData.toLocalDate();
    } 
}
