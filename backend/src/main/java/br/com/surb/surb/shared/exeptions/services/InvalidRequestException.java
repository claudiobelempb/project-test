package br.com.surb.surb.shared.exeptions.services;

import br.com.surb.surb.shared.validator.ValidationErrors;

public class InvalidRequestException extends RuntimeException {

  private final ValidationErrors validationErrors;

  public InvalidRequestException(ValidationErrors validationErrors) {
    super(validationErrors.toString());
    this.validationErrors = validationErrors;
  }

  public ValidationErrors getValidationErrors() {
    return validationErrors;
  }
}
