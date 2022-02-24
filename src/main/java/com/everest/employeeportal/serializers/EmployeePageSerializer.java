package com.everest.employeeportal.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.domain.PageImpl;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

@JsonComponent
public class EmployeePageSerializer extends JsonSerializer<PageImpl<?>> {

    @Override
    public void serialize(PageImpl page, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("data", page.getContent());
        jsonGenerator.writeNumberField("totalPages", page.getTotalPages());
        jsonGenerator.writeNumberField("totalElements", page.getTotalElements());
        jsonGenerator.writeNumberField("pageSize", page.getSize());
        jsonGenerator.writeNumberField("current", page.getNumber());
        jsonGenerator.writeBooleanField("hasNext", page.hasNext());
        jsonGenerator.writeBooleanField("hasPrevious", page.hasPrevious());
    }
}
