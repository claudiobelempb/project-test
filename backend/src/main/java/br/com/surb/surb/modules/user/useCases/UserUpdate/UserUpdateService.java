package br.com.surb.surb.modules.user.useCases.UserUpdate;

import br.com.surb.surb.modules.user.dto.UserUpdateDTO;
import br.com.surb.surb.modules.user.infra.jps.entities.User;
import br.com.surb.surb.modules.user.infra.jps.repositories.UserRepository;
import br.com.surb.surb.shared.constants.MessageConstants;
import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class UserUpdateService {

  private final UserRepository userRepository;

  public UserUpdateService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @Transactional
  public UserUpdateDTO execute(Long id, UserUpdateDTO userUpdateDTO){
    try{
      User user = userRepository.getById(id);
      user.setFirstName(userUpdateDTO.getFirstName());
      user.setLastName(userUpdateDTO.getLastName());
      user.setEmail(userUpdateDTO.getEmail());
      user = userRepository.save(user);
      return new UserUpdateDTO(user);
    }catch (EntityNotFoundException e){
      throw new AppNotFoundException(MessageConstants.ENTITY_NOT_FOUND + id);
    }
  }
}
