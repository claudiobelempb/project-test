package br.com.surb.surb.modules.room.useCases.RoomFindById;

import br.com.surb.surb.modules.room.dto.RoomDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/rooms")
public class RoomFindByIdController {

  private final RoomFindByIdService roomFindByIdService;

  public RoomFindByIdController(RoomFindByIdService roomFindByIdService){
    this.roomFindByIdService = roomFindByIdService;
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<RoomDTO> handle(@PathVariable Long id) {
    RoomDTO roomDTO = roomFindByIdService.execute(id);
    return ResponseEntity.ok().body(roomDTO);
  }
}
