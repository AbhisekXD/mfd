package com.cyfrifpro.util;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.util.Base64;

public class Base64ByteArrayConverter {

    // Converter: byte[] -> Base64 String
    public static final Converter<byte[], String> byteArrayToBase64 = 
        new Converter<byte[], String>() {
            @Override
            public String convert(MappingContext<byte[], String> context) {
                byte[] source = context.getSource();
                if (source == null || source.length == 0) {
                    return null;
                }
                return Base64.getEncoder().encodeToString(source);
            }
        };

    // Converter: Base64 String -> byte[]
    public static final Converter<String, byte[]> base64ToByteArray = 
        new Converter<String, byte[]>() {
            @Override
            public byte[] convert(MappingContext<String, byte[]> context) {
                String source = context.getSource();
                if (source == null || source.isEmpty()) {
                    return null;
                }
                return Base64.getDecoder().decode(source);
            }
        };
}
