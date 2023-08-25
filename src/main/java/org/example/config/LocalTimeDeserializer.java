package org.example.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalTime;

public class LocalTimeDeserializer extends JsonDeserializer<LocalTime> {
    @Override
    public LocalTime deserialize(JsonParser arg0, DeserializationContext arg1) throws IOException {
        String text = arg0.getText();
        if (text.split(":")[0].length() == 1) {
            text = "0" + text;
        }
        return LocalTime.parse(text);
    }
}
