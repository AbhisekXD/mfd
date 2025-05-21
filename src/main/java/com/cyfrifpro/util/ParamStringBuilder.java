package com.cyfrifpro.util;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public final class ParamStringBuilder {

    // Private constructor to prevent instantiation
    private ParamStringBuilder() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Build a parameter string from the provided DTO, excluding specified fields.
     * If no excluded fields are provided (null or empty), all fields are included.
     *
     * @param dto The object whose fields are to be processed.
     * @param excludedFields A set of field names to be excluded from the generated param string.
     *                       If null or empty, no fields are excluded.
     * @return A parameter string with field values separated by '|'.
     */
    public static String buildParamString(Object dto, Set<String> excludedFields) {
        if (dto == null) {
            throw new IllegalArgumentException("DTO cannot be null");
        }

        if (excludedFields == null) {
            excludedFields = new HashSet<>();
        }

        StringBuilder paramBuilder = new StringBuilder();

        try {
            // Get all fields of the class
            Field[] fields = dto.getClass().getDeclaredFields();

            for (Field field : fields) {
                // Make private fields accessible
                field.setAccessible(true);

                // Debugging line to see the field names
                System.out.println("Field name: " + field.getName());

                // Skip the field if it is in the excluded set
                if (excludedFields.contains(field.getName())) {
                    continue;  // Skip this field if it's excluded
                }

                // Get the field value
                Object value = field.get(dto);

                // Add value or "" if null
                if (value == null) {
                    paramBuilder.append("");
                } else {
                    paramBuilder.append(value.toString());
                }

                // Add the delimiter
                paramBuilder.append("|");
            }

            // Remove the last delimiter if exists
            if (paramBuilder.length() > 0) {
                paramBuilder.setLength(paramBuilder.length() - 1);
            }

        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error accessing fields of the DTO", e);
        }

        return paramBuilder.toString();
    }
}