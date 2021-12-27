package br.com.surb.surb.modules.room.validator;

import static br.com.surb.surb.shared.enums.TypeStatus.ENABLED;
import static br.com.surb.surb.shared.util.ValidatorUtils.*;
import static br.com.surb.surb.shared.constants.ValidatorConstants.*;

import br.com.surb.surb.modules.room.dto.RoomDTO;
import br.com.surb.surb.modules.room.infra.jpa.repositories.RoomRepository;
import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import br.com.surb.surb.shared.validator.ValidationErrors;
import org.springframework.stereotype.Component;

@Component
public class RoomValidator {
  private final RoomRepository roomRepository;

  public RoomValidator(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  public void validate(RoomDTO roomDTO) {
    //  var validationErros = new ValidationErrors();
    ValidationErrors validationErrors = new ValidationErrors();
    if(
      validateName(roomDTO.getName(), validationErrors) &&
      validateSeats(roomDTO.getSeats(), validationErrors)
    ) {
      validateNameDuplicate(roomDTO.getName());
    }

    throwOnError(validationErrors);
  }

  private boolean validateName(String name, ValidationErrors validationErrors) {
    //Room name
    return validateRequired(name, ROOM_NAME, validationErrors) &&
    validateMaxLength(name, ROOM_NAME, ROOM_NAME_MAX_LENGTH, validationErrors);
  }

  private boolean validateSeats(Integer seats, ValidationErrors validationErrors) {
    //Room seats
    return validateRequired(seats, ROOM_SEATS, validationErrors) &&
    validateMinValue(seats, ROOM_SEATS, ROOM_SEATS_MIN_VALUE, validationErrors) &&
    validateMaxValue(seats, ROOM_SEATS, ROOM_SEATS_MAX_VALUE, validationErrors);
  }

  private void validateNameDuplicate(String name) {
    roomRepository
      .findByNameAndStatus(name, ENABLED)
    .ifPresent(__ -> {
      throw new AppNotFoundException("error " + ROOM_NAME + " is already registered in our database");
    });
  }
}
