package ru.practucum.explore.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.practucum.explore.exception.model.ApiError;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidationException(final ValidationException e) {
        log.error("{}.", e.getMessage());
        return new ApiError(
                List.of(),
                e.getMessage(),
                "Ошибка валидации",
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleArgumentException(final Exception e) {
        log.error("{}.", e.getMessage());
        return new ApiError(
                List.of(),
                e.getMessage(),
                "Ошибка валидации",
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleModelNotFoundException(final UserNotFoundException e) {
        log.error("{}.", e.getMessage());
        return new ApiError(
                List.of(),
                e.getMessage(),
                "Объект не найден",
                HttpStatus.NOT_FOUND,
                LocalDateTime.now()
        );
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidParam(ConstraintViolationException e) {
        log.error("{}.", e.getMessage());
        return new ApiError(
                List.of(),
                e.getMessage(),
                "Неверное param",
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );
    }



    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleDuplicateEmailException(final DuplicateEmailException e) {
        log.error("{}.", e.getMessage());
        return new ApiError(
                List.of(),
                e.getMessage(),
                "",
                HttpStatus.CONFLICT,
                LocalDateTime.now()
        );
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleConflictException(final ConflictException e) {
        log.error("{}.", e.getMessage());
        return new ApiError(
                List.of(),
                e.getMessage(),
                "",
                HttpStatus.CONFLICT,
                LocalDateTime.now()
        );
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleMethodArgumentNotValidException(final DateException e) {
        log.error("{}.", e.getMessage());
        return new ApiError(
                List.of(),
                e.getMessage(),
                "Переданы невалидные поля",
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        log.error("{}.", e.getMessage());
        return new ApiError(
                List.of(),
                e.getMessage(),
                "Переданы невалидные агрументы",
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );
    }




    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleThrowable(final Throwable e) {
        log.error("{}.", e.getMessage());
        return new ApiError(
                List.of(),
                e.getMessage(),
                "",
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now()
        );
    }


}
