package com.sbrf.reboot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;

public class XMLUtils {
    public static <T> String toXML(T request) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.writeValueAsString(request);
    }

    public static <T> T fromXML(String s, Class clazz) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        return (T) xmlMapper.readValue(s, clazz);
    }

}
