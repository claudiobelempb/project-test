package br.com.surb.surb.modules.room.useCases.RoomCreate;

import br.com.surb.surb.modules.room.dto.RoomDTO;
import br.com.surb.surb.modules.room.infra.jpa.entities.Room;
import br.com.surb.surb.modules.room.infra.jpa.repositories.RoomRepository;
import br.com.surb.surb.modules.room.validator.RoomValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomCreateService {

  private final RoomRepository roomRepository;
  private final RoomValidator roomValidator;

  public RoomCreateService(RoomRepository roomRepository, RoomValidator roomValidator) {
    this.roomRepository = roomRepository;
    this.roomValidator = roomValidator;
  }

  @Transactional
  public RoomDTO execute(RoomDTO roomDTO){
    roomValidator.validate(roomDTO);
    Room room = Room.newBuilder()
      .name(roomDTO.getName())
      .seats(roomDTO.getSeats())
      .build();
    roomRepository.save(room);
    return new RoomDTO(room);
  }
}
