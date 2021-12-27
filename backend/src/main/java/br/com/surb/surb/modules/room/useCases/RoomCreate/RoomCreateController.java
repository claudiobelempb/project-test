package br.com.surb.surb.modules.room.useCases.RoomCreate;

import br.com.surb.surb.modules.room.dto.RoomDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/rooms")
public class RoomCreateController {

  private final RoomCreateService roomCreateService;

  public RoomCreateController(RoomCreateService roomCreateService){
    this.roomCreateService = roomCreateService;
  }

  @PostMapping
  public ResponseEntity<RoomDTO> handle(@RequestBody RoomDTO roomDTO){
    roomDTO = roomCreateService.execute(roomDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(roomDTO.getId()).toUri();
    return ResponseEntity.created(uri).body(roomDTO);
  }
}
