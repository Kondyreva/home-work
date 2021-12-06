package com.sbrf.reboot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class XMLUtilsTest {

    @SneakyThrows
    @Test
    void toXMLRequest() {
        Request request = new Request("ATM12345");
        Assertions.assertTrue(XMLUtils.toXML(request).contains("atmNumber"));
    }

    @SneakyThrows
    @Test
    void toXMLResponse() {
        Response response = new Response("SUCCESS");
        Assertions.assertTrue(XMLUtils.toXML(response).contains("statusCode"));
    }

    @Test
    void XMLtoRequest() throws JsonProcessingException {
        Request request = XMLUtils.fromXML("<Request><atmNumber>ATM12345</atmNumber></Request>", Request.class);
        Assertions.assertEquals("ATM12345", request.getAtmNumber());
    }

    @Test
    void XMLtoResponse() throws JsonProcessingException {
        Response request = XMLUtils.fromXML("<Response><statusCode>SUCCESS</statusCode></Response>", Response.class);
        Assertions.assertEquals("SUCCESS", request.getStatusCode());
    }

}