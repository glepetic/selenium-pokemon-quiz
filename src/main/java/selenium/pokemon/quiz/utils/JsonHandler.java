package selenium.pokemon.quiz.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import selenium.pokemon.quiz.exceptions.JsonDeserializationException;
import selenium.pokemon.quiz.exceptions.JsonSerializationException;

import java.io.IOException;

public class JsonHandler {

    private static ObjectMapper mapper;

    public JsonHandler() {
        initMapper();
    }

    public <T> T deserialize(String jsonContent, TypeReference<T> type){
        try {
            return mapper.readValue(jsonContent, type);
        } catch (JsonMappingException e) {
            throw new JsonDeserializationException("No coincide la estructura del JSON recibido con la esperada.");
        } catch (JsonParseException e) {
            throw new JsonDeserializationException("Lo recibido no cumple con formato JSON.");
        } catch (IOException e) {
            throw new JsonDeserializationException("Hubo un error de E/S al deserializar el contenido del json");
        }
    }


    public <T> String serialize(T object){

        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e1) {
            throw new JsonSerializationException("Hubo un error al serializar un objeto");
        }
    }

    public static ObjectMapper getMapper() {
        initMapper();
        return mapper;
    }

    private static void initMapper() {
        if (mapper == null) {
            mapper = new ObjectMapper();
            mapper.registerModules(new Jdk8Module());
            mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES, true);
            mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        }
    }


}
