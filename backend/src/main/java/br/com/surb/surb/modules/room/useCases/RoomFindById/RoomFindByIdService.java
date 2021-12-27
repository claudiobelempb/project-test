package br.com.surb.surb.modules.room.useCases.RoomFindById;

import br.com.surb.surb.modules.room.dto.RoomDTO;
import br.com.surb.surb.modules.room.infra.jpa.entities.Room;
import br.com.surb.surb.modules.room.infra.jpa.repositories.RoomRepository;
import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class RoomFindByIdService {

  private final RoomRepository roomRepository;

  public RoomFindByIdService(RoomRepository roomRepository){
    this.roomRepository = roomRepository;
  }

  @Transactional(readOnly = true)
  public RoomDTO execute(Long id){
    Objects.requireNonNull(id);
    Optional<Room> optional = roomRepository.findById(id);
    Room room = optional.orElseThrow(() -> new AppNotFoundException("Entity not found"));
    return new RoomDTO(room);
  }
}
