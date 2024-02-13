package com.ramo.blog.util.factory;

import com.ramo.blog.util.GenericResponse;

public interface GenericResponseFactory<T> {
    GenericResponse<T> createResponse(boolean success, String message, T data);
    GenericResponse<T> createSuccessResponse(T data);
    GenericResponse<T> createErrorResponse(String message);
}