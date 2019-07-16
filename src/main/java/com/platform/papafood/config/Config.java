//package com.platform.papafood.config;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.module.SimpleModule;
//import com.google.gson.JsonObject;
//import com.platform.papafood.util.JsonUtils;
//import com.tpp.persistence.Meta;
//import lombok.Getter;
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ResourceBundleMessageSource;
//
//import java.util.Map;
//
//@Configuration
//@Getter
//public class Config {
//
//    @Bean
//    public ObjectMapper objectMapper() {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
//        SimpleModule module = new SimpleModule();
//        module.addSerializer(Meta.class, (JsonSerializer<Meta>) (src, typeOfSrc, context) -> {
//            JsonObject obj = new JsonObject();
//            for (Map.Entry<String, Object> entry : src.entrySet()) {
//                if (entry.getKey().matches("^[a-zA-Z_][a-zA-Z0-9_-]*$")) {
//                    obj.add(entry.getKey(), JsonUtils.toJsonElement(entry.getValue()));
//                }
//            }
//            return obj;
//        });
//
//
//
//        mapper.addDeserializer(Meta.class, (JsonSerializer<Meta>) (src, typeOfSrc, context) -> {
//            JsonObject obj = new JsonObject();
//            for (Map.Entry<String, Object> entry : src.entrySet()) {
//                if (entry.getKey().matches("^[a-zA-Z_][a-zA-Z0-9_-]*$")) {
//                    obj.add(entry.getKey(), JsonUtils.toJsonElement(entry.getValue()));
//                }
//            }
//            return obj;
//        });
//        return mapper;
//    }
//
//    @Bean(name = "messageResourceBean")
//    public MessageSource messageResource() {
//        ResourceBundleMessageSource messageBundle = new ResourceBundleMessageSource();
//        messageBundle.setBasename("message");
//        messageBundle.setDefaultEncoding("UTF-8");
//        return messageBundle;
//    }
//}
