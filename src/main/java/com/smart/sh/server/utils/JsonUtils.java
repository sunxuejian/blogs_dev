package com.smart.sh.server.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.sh.server.exception.SaExceptionCode;
import com.smart.sh.server.exception.SmartAppException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 孙雪键 on 2017/4/16.
 */
public class JsonUtils {
    private static ObjectMapper mapper;

    private JsonUtils() {
    }

    static {
        mapper = new ObjectMapper();

    }

    /**
     * object To String
     */
    public static String writeValueAsString(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new SmartAppException(SaExceptionCode.JSONPARSE_ERROR, e.getMessage());
        }
    }

    /**
     * String To Object
     */
    public static <T> T readValue(String jsonStr, Class<T> clazz) {
        try {
            return mapper.readValue(jsonStr, clazz);
        } catch (Exception e) {
            throw new SmartAppException(SaExceptionCode.JSONPARSE_ERROR, e.getMessage());
        }
    }


    /**
     * json string convert to map
     */
    public static <T> Map readValue(String jsonStr) {
        try {
            return readValue(jsonStr, Map.class);
        } catch (Exception e) {
            throw new SmartAppException(SaExceptionCode.JSONPARSE_ERROR, e.getMessage());
        }
    }


    /**
     * json string convert to map with javaBean
     */
    public static <T> Map<String, T> jsonToMap(String jsonStr, Class<T> clazz) {
        try {
            Map<String, Map<String, Object>> map = mapper.readValue(jsonStr,
                    new TypeReference<Map<String, T>>() {
                    });
            Map<String, T> result = new HashMap<String, T>();
            for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {
                result.put(entry.getKey(), mapToPojo(entry.getValue(), clazz));
            }
            return result;
        } catch (Exception e) {
            throw new SmartAppException(SaExceptionCode.JSONPARSE_ERROR, e.getMessage());
        }
    }


    /**
     * json array string convert to list with javaBean
     */
    public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz) {
        List<Map<String, Object>> list = null;
        try {
            list = mapper.readValue(jsonArrayStr,
                    new TypeReference<List<T>>() {
                    });
            List<T> result = new ArrayList<T>();
            for (Map<String, Object> map : list) {
                result.add(mapToPojo(map, clazz));
            }
            return result;
        } catch (IOException e) {
            throw new SmartAppException(SaExceptionCode.JSONPARSE_ERROR, e.getMessage());
        }
    }


    /**
     * map convert to javaBean
     */
    public static <T> T mapToPojo(Map map, Class<T> clazz) {
        return mapper.convertValue(map, clazz);
    }
}
