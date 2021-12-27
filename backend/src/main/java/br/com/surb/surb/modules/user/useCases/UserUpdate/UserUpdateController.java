package br.com.surb.surb.modules.user.useCases.UserUpdate;

import br.com.surb.surb.modules.user.dto.UserUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/users")
public class UserUpdateController {

  @Autowired
  private UserUpdateService userUpdateService;

  @PutMapping(value = "/{id}")
  public ResponseEntity<UserUpdateDTO> handle(@PathVariable Long id, @RequestBody UserUpdateDTO userUpdateDTO) {
    userUpdateDTO = userUpdateService.execute(id, userUpdateDTO);
    return ResponseEntity.ok().body(userUpdateDTO);
  }
}
