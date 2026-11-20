package co.api.shared.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonConverter {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JsonConverter() {}

    public static <T> T toObject(String json, Class<T> targetType) {
        try {
            return OBJECT_MAPPER.readValue(json, targetType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
