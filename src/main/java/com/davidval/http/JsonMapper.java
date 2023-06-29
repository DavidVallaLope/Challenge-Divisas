package com.davidval.http;

import com.davidval.business.Divisas;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formdev.flatlaf.json.Json;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class JsonMapper {
    private Consumer consumer;
    private Divisas divisas;
    private ObjectMapper objectMapper;

    public JsonMapper(Consumer consumer, Divisas divisas) {
        this.consumer = consumer;
        this.divisas = divisas;
        this.objectMapper = new ObjectMapper();
    }

    public void convertJsonToMap() {
        String json = consumer.doPetition().body();
        objectMapper.addMixInAnnotations(Map.class, Divisas.MixIn.class);
        try {
            divisas.setMapOfDivisas(objectMapper.readValue(json, Map.class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
