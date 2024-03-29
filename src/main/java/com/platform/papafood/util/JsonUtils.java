//package com.platform.papafood.util;
//
//import com.google.gson.*;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//public class JsonUtils {
//    private static final ThreadLocal<DateFormat> DATE_FORMAT = new ThreadLocal<DateFormat>() {
//        @Override
//        public DateFormat get() {
//            DateFormat f = super.get();
//            if (f == null) {
//                f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//                f.setTimeZone(TimeZone.getTimeZone("GMT"));
//                set(f);
//            }
//            return f;
//        }
//    };
//
//    public static String getString(JsonObject obj, String name) {
//        if (obj.has(name)) return obj.get(name).getAsString();
//        return null;
//    }
//
//    public static Date getDateTime(JsonObject obj, String name) throws JsonParseException {
//        String str = getString(obj, name);
//        if (str != null && str.length() >= 19) {
//            try {
//                return DATE_FORMAT.get().parse(str);
//            } catch (ParseException e) {
//                throw new JsonParseException("failed to parse dateTime: " + str);
//            }
//        }
//        return null;
//    }
//
//    public static int getInteger(JsonObject obj, String name) throws JsonParseException {
//        if (obj.has(name)) return obj.get(name).getAsInt();
//        return 0;
//    }
//
//    public static long getLong(JsonObject obj, String name) throws JsonParseException {
//        if (obj.has(name)) return obj.get(name).getAsLong();
//        return 0L;
//    }
//
//    public static float getFloat(JsonObject obj, String name) throws JsonParseException {
//        if (obj.has(name)) return obj.get(name).getAsFloat();
//        return 0f;
//    }
//
//    public static double getDouble(JsonObject obj, String name) throws JsonParseException {
//        if (obj.has(name)) return obj.get(name).getAsDouble();
//        return 0;
//    }
//
//    public static Object getValue(JsonElement ele) throws JsonParseException {
//        if (ele == null) {
//            return null;
//        } else if (ele.isJsonArray()) {
//            JsonArray data = (JsonArray) ele;
//            ArrayList<Object> list = new ArrayList<Object>(data.size());
//
//            for (Iterator<JsonElement> iter = data.iterator(); iter.hasNext(); ) {
//                JsonElement item = iter.next();
//                list.add(getValue(item));
//            }
//            return list;
//        } else if (ele.isJsonObject()) {
//            JsonObject data = (JsonObject) ele;
//            LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
//            for (Map.Entry<String, JsonElement> entry : data.entrySet()) {
//                map.put(entry.getKey(), getValue(entry.getValue()));
//            }
//            return map;
//        } else if (ele.isJsonPrimitive()) {
//            JsonPrimitive pri = (JsonPrimitive) ele;
//            if (pri.isBoolean()) return pri.getAsBoolean();
//            else if (pri.isString()) {
//                String value = pri.getAsString();
//                if (value.length() == 19 && value.charAt(10) == 'T') {
//                    try {
//                        return DATE_FORMAT.get().parse(value);
//                    } catch (ParseException e) {
//                        // ignore exception
//                    }
//                }
//                return value;
//            } else if (pri.isNumber()) {
//                if (pri.getAsString().indexOf('.') == -1) return pri.getAsLong();
//                else return pri.getAsDouble();
//            } else {
//                throw new JsonParseException("Unexpected type: " + pri.getClass());
//            }
//        } else if (ele.isJsonNull()) {
//            return null;
//        } else {
//            throw new JsonParseException("Unknown type for: " + ele.getClass());
//        }
//    }
//
//    public static JsonElement toJsonElement(Object value) {
//        JsonElement ele;
//        if (value == null) {
//            ele = JsonNull.INSTANCE;
//        } else if (value instanceof String) {
//            ele = new JsonPrimitive((String) value);
//        } else if (value instanceof java.sql.Date) {
//            ele = new JsonPrimitive("" + value);
//        } else if (value instanceof Date) {
//            ele = new JsonPrimitive(DATE_FORMAT.get().format((Date) value));
//        } else if (value instanceof Number) {
//            ele = new JsonPrimitive((Number) value);
//        } else if (value instanceof Boolean) {
//            ele = new JsonPrimitive((Boolean) value);
//        } else if (value instanceof List) {
//            List<?> list = (List<?>) value;
//
//            JsonArray arr = new JsonArray();
//            for (Object item : list)
//                arr.add(toJsonElement(item));
//
//            ele = arr;
//        } else if (value instanceof Map) {
//            @SuppressWarnings("unchecked")
//            Map<String, Object> map = (Map<String, Object>) value;
//
//            JsonObject obj = new JsonObject();
//            for (Map.Entry<String, Object> e : map.entrySet())
//                obj.add(e.getKey(), toJsonElement(e.getValue()));
//
//            ele = obj;
//        } else {
//            throw new RuntimeException("Unknown type " + value.getClass());
//        }
//        return ele;
//    }
//
//}