package com.ramo.blog.util.factory;

import com.ramo.blog.util.GenericResponse;
import org.springframework.stereotype.Component;

@Component
public class GenericResponseFactoryImpl<T> implements GenericResponseFactory<T> {

    @Override
    public GenericResponse<T> createResponse(boolean success, String message, T data) {
        return new GenericResponse<>(success, message, data);
    }

    @Override
    public GenericResponse<T> createSuccessResponse(T data) {
        return createResponse(true, "Success", data);
    }

    @Override
    public GenericResponse<T> createErrorResponse(String message) {
        return createResponse(false, message, null);
    }
}
