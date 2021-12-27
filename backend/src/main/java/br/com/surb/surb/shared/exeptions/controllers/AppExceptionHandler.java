package br.com.surb.surb.shared.exeptions.controllers;

import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import br.com.surb.surb.shared.exeptions.services.DataBaseException;
import br.com.surb.surb.shared.exeptions.services.ForbiddenException;
import br.com.surb.surb.shared.exeptions.services.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.time.Instant;

@ControllerAdvice
public class AppExceptionHandler implements Serializable {
  private static final long serialVersionUID = 1L;
  private final StandarError error = new StandarError();

  @ExceptionHandler(AppNotFoundException.class)
  public ResponseEntity<StandarError> entityNotFound(
    AppNotFoundException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandarError err = new StandarError();
    err.setTimestamp(Instant.now());
    err.setStatus(status.value());
    err.setError("Resource not found");
    err.setMessage(e.getMessage());
    err.setPath(request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(DataBaseException.class)
  public ResponseEntity<StandarError> database(DataBaseException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    StandarError err = new StandarError();
    err.setTimestamp(Instant.now());
    err.setStatus(status.value());
    err.setError("Database exception");
    err.setMessage(e.getMessage());
    err.setPath(request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ValidationError> validation(
    MethodArgumentNotValidException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
    ValidationError err = new ValidationError();
    err.setTimestamp(Instant.now());
    err.setStatus(status.value());
    err.setError("Validation exception");
    err.setMessage(e.getMessage());
    err.setPath(request.getRequestURI());

    for (FieldError field : e.getBindingResult().getFieldErrors()) {
      err.addError(field.getField(), field.getDefaultMessage());
    }

    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(ForbiddenException.class)
  public ResponseEntity<OAuthCustomError> forbidden(ForbiddenException e, HttpServletRequest request) {
    OAuthCustomError customError = new OAuthCustomError("Forbidden", e.getMessage());
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(customError);
  }

  @ExceptionHandler(UnauthorizedException.class)
  public ResponseEntity<OAuthCustomError> unauthorized(UnauthorizedException e, HttpServletRequest request) {
    OAuthCustomError customError = new OAuthCustomError("Unauthorized", e.getMessage());
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(customError);
  }



}
