package com.example;

import org.springframework.core.serializer.DefaultSerializer;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 马克
 * @date 2023/10/7
 */
public class SerializableDemo implements Serializable {
    public static void main(String[] args) throws IOException {
        DefaultSerializer defaultSerializer = new DefaultSerializer();

        Map<String, Object> map = new HashMap<>();

        map.put("a", Boolean.TRUE);

        byte[] bytes = defaultSerializer.serializeToByteArray(map);
        System.out.println("bytes = " + bytes);
    }
}
