package com.sbrf.reboot.utils;

import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class JSONUtilsTest {

    @SneakyThrows
    @Test
    void toJSONRequest() {
        Request request = new Request("ATM12345");
        Assertions.assertTrue(JSONUtils.toJSON(request).contains("atmNumber"));
    }

    @SneakyThrows
    @Test
    void toJSONResponse() {
        Response response = new Response("SUCCESS");
        Assertions.assertTrue(JSONUtils.toJSON(response).contains("statusCode"));
    }

    @SneakyThrows
    @Test
    void JSONtoRequest()  {
        Request request = JSONUtils.fromJSON("{\"atmNumber\":\"ATM12345\"}", Request.class);
        Assertions.assertEquals("ATM12345", request.getAtmNumber());
    }

    @SneakyThrows
    @Test
    void JSONtoResponse()  {
        Response response = JSONUtils.fromJSON("{\"statusCode\":\"SUCCESS\"}", Response.class);
        Assertions.assertEquals("SUCCESS", response.getStatusCode());
    }

}