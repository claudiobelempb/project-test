package br.com.surb.surb.modules.user.useCases.UserFindById;

import br.com.surb.surb.modules.user.dto.UserDTO;
import br.com.surb.surb.modules.user.infra.jps.entities.User;
import br.com.surb.surb.modules.user.infra.jps.repositories.UserRepository;
import br.com.surb.surb.shared.constants.MessageConstants;
import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserFindByIdService {

  @Autowired
  private UserRepository userRepository;

  @Transactional(readOnly = true)
  public UserDTO execute(Long id){
    Optional<User> obj = userRepository.findById(id);
    User user = obj.orElseThrow(() -> new AppNotFoundException(MessageConstants.ENTITY_NOT_FOUND + id));
    return new UserDTO(user);
  }

}
