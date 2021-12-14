package com.sbrf.reboot.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class JSONUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> String toJSON(T request) throws IOException {
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, request);
        return writer.toString();
    }

    public static <T> T fromJSON(String jsonString, Class clazz) throws IOException {
        StringReader reader = new StringReader(jsonString);
        return (T) mapper.readValue(reader, clazz);
    }
}
