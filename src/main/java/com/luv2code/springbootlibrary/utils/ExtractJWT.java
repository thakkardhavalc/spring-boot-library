package com.luv2code.springbootlibrary.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Base64;

/**
 * Created By dhhaval thakkar on 2024-02-03
 */
@Component
public class ExtractJWT {

    public static String payloadJWTExtraction(String token) {
        token.replace("Bearer", "");
        String[] chunks = token.split("\\.");

        Base64.Decoder decoder = Base64.getUrlDecoder();
        String payload = new String(decoder.decode(chunks[1]));

        ObjectMapper mapper = new ObjectMapper();
        JsonNode parent = null;
        try {
            parent = mapper.readTree(payload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return parent.path("sub").asText();
    }
}
