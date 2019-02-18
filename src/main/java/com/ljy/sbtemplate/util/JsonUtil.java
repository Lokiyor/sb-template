package com.ljy.sbtemplate.util;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author Lokiy
 * @date 2018/6/14
 * @description
 */
public class JsonUtil {

    private static final Logger logger = LogManager.getLogger();

    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <T> T toObject(String string, Class<T> clazz) {
        try {
            return JSON.parseObject(string, clazz);
        } catch (Exception e) {
            logger.error("Exception", e);
        }
        return null;
    }

    public static <T> String toJson(T t) {
        try {
            return JSON.toJSONString(t);
        } catch (Exception e) {
            logger.error("Exception", e);
        }
        return null;
    }

    public static <T> T toComplexObject(String s, Type type){
        try {
            return new Gson().fromJson(s, type);
        } catch (JsonSyntaxException e) {
            logger.error("Exception", e);
        }
        return null;
    }

    public static <T> String toGson(T t) {
        return new Gson().toJson(t);
    }

    public static <T> Map<String, T> toMap(String jsonAsString) throws JsonGenerationException {
        try {
            return mapper.readValue(jsonAsString, new  TypeReference<Map<String, T>>() {
            });
        } catch (Exception e) {
            logger.error("parse jsonString error.[" + jsonAsString + "]");
            throw new JsonGenerationException(e);
        }
    }

    public static <T> Map<String, T>[] toMapArray(String jsonAsString) throws JsonGenerationException {
        try {
            return mapper.readValue(jsonAsString, new TypeReference<Map<String, T>[]>() {
            });
        } catch (Exception e) {
            logger.error("parse jsonString error.[" + jsonAsString + "]");
            throw new JsonGenerationException(e);
        }
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    public static <T> T toList(String string, Class<?> clazzList,Class<?> clazzBean) {
        try {
            JavaType javaType = getCollectionType(clazzList, clazzBean);
            return mapper.readValue(string, javaType);
        } catch (IOException e) {
            logger.error("Exception", e);
        }
        return null;
    }

    public static <T> T mapToObject(Object fromValue, Class<T> toValueType){
        return mapper.convertValue(fromValue, toValueType);
    }
}
