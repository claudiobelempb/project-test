package br.com.surb.surb.shared.exeptions.controllers;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandarError {

  private static final long serialVersionUID = 1L;

  private final List<FieldMessage> errors = new ArrayList<>();

  public List<FieldMessage> getErrors() {
    return errors;
  }

  public void addError(String fieldName, String message) {
    errors.add(new FieldMessage(fieldName, message));
  }

}