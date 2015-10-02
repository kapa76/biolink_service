package org.biolink.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;

import java.util.Date;

public class ApiController {
    protected static JsonElement stringToJson(String text) {
        if (text == null) {
            return JsonNull.INSTANCE;
        } else {
            return new JsonPrimitive(text);
        }
    }

    protected static JsonElement longToJson(Long l) {
        if (l == null) {
            return JsonNull.INSTANCE;
        } else {
            return new JsonPrimitive(l);
        }
    }

    protected static JsonElement dateToJson(Date date) {
        if (date == null) {
            return JsonNull.INSTANCE;
        } else {
            return new JsonPrimitive(date.getTime());
        }
    }

    protected static JsonElement booleanToJson(Boolean b) {
        if (b == null) {
            return JsonNull.INSTANCE;
        } else {
            return new JsonPrimitive(b);
        }
    }

}
