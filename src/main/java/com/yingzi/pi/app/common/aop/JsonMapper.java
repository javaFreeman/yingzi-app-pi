package com.yingzi.pi.app.common.aop;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class JsonMapper {
    private static ObjectMapper objectMapper = new ObjectMapper();


    private JsonMapper(){}
    /**
     * 对象转 json 字符串
     *
     * @param src 元对象
     * @param <T> 类型
     * @return json 字符串
     */
    public static <T> String obj2Str(T src) {
        if (src == null) {
            return null;
        }
        try {
            return src instanceof String ? (String) src : objectMapper.writeValueAsString(src);
        } catch (IOException e) {
            log.error("【JSON 转换：对象 --> 字符串】，异常堆栈：{}", e);
            return null;
        }
    }

    /**
     * json 字符串转化为对象
     *
     * @param src           源 json 字符串
     * @param typeReference 转化后的类型
     * @param <T>           类型
     * @return 返回转化后的对象
     */
    public static <T> T str2Obj(String src, TypeReference<T> typeReference) {
        if (src == null || typeReference == null) {
            return null;
        }
        try {
            return (T) (typeReference.getType().equals(String.class) ? src : objectMapper.readValue(src, typeReference));
        } catch (Exception e) {
            log.error("【JSON 转换：字符串 --> 对象】，异常堆栈：{}", e);
            return null;
        }
    }
}