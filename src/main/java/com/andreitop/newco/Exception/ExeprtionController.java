package com.andreitop.newco.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExeprtionController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException exception,
                                                                  final HttpHeaders headers, final HttpStatus status, final WebRequest request) {

        List<String> errors = new ArrayList();
        exception.getBindingResult().getFieldErrors().stream()
                .forEach((p) -> errors.add(p.getField() + ": " + p.getDefaultMessage()));
        exception.getBindingResult().getGlobalErrors().stream()
                .forEach((p) -> errors.add(p.getObjectName() + ": " + p.getDefaultMessage()));

        final ApiError dtoApiError = new ApiError(HttpStatus.BAD_REQUEST, exception.getLocalizedMessage(), errors + " Some of data are not valid");
        return handleExceptionInternal(exception, dtoApiError, headers, dtoApiError.getStatus(), request);
    }

       @Override
    public ResponseEntity<Object> handleMissingServletRequestParameter(final MissingServletRequestParameterException exception,
                                                                       final HttpHeaders headers, final HttpStatus status, final WebRequest request) {

        String error = exception.getParameterName() + " you are missing parametr";
        final ApiError dtoApiError = new ApiError(HttpStatus.BAD_REQUEST, exception.getLocalizedMessage(), error);
        return new ResponseEntity<>(dtoApiError, new HttpHeaders(), dtoApiError.getStatus());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> ArgumentTypeMismatch(MethodArgumentTypeMismatchException exception) {
        String error = exception.getName() + " not the valid type. It should be " + exception.getRequiredType().getName();

        final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, exception.getLocalizedMessage(), error);
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @Override
    public ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException exception,
                                                               final HttpHeaders headers, final HttpStatus status, final WebRequest request) {

        String error = "Method is fail";
        final ApiError dtoApiError = new ApiError(HttpStatus.BAD_REQUEST, exception.getLocalizedMessage(), error);
        return new ResponseEntity<>(dtoApiError, headers, dtoApiError.getStatus());
    }

    @Override
    public ResponseEntity<Object> handleNoHandlerFoundException(final NoHandlerFoundException exception,
                                                                final HttpHeaders headers, final HttpStatus status, final WebRequest request) {

        final String error = "No handler found for " + exception.getHttpMethod() + " " + exception.getRequestURL();
        final ApiError dtoApiError = new ApiError(HttpStatus.NOT_FOUND, exception.getLocalizedMessage(), error);
        return new ResponseEntity<>(dtoApiError, new HttpHeaders(), dtoApiError.getStatus());
    }

    @Override
    public ResponseEntity<Object> handleHttpRequestMethodNotSupported(final HttpRequestMethodNotSupportedException exception,
                                                                      final HttpHeaders headers, final HttpStatus status, final WebRequest request) {

        StringBuilder error = new StringBuilder();
        error.append(exception.getMethod());
        error.append(" method is not supported for this request. Supported methods are ");
        exception.getSupportedHttpMethods().forEach(t -> error.append(t + " "));

        final ApiError dtoApiError = new ApiError(HttpStatus.METHOD_NOT_ALLOWED, exception.getLocalizedMessage(), error.toString());
        return new ResponseEntity<>(dtoApiError, new HttpHeaders(), dtoApiError.getStatus());
    }

}
