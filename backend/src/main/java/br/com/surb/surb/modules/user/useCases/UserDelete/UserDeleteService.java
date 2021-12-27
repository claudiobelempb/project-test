package br.com.surb.surb.modules.user.useCases.UserDelete;

import br.com.surb.surb.modules.user.infra.jps.repositories.UserRepository;
import br.com.surb.surb.shared.constants.MessageConstants;
import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import br.com.surb.surb.shared.exeptions.services.DataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserDeleteService {

  @Autowired
  private UserRepository userRepository;

  public void execute(Long id){
    try{
      userRepository.deleteById(id);
    }catch (EmptyResultDataAccessException e) {
      throw new AppNotFoundException(MessageConstants.ENTITY_NOT_FOUND + id);
    }catch (DataIntegrityViolationException e) {
      throw new DataBaseException(MessageConstants.INTEGRITY_VIOLATION);
    }
  }
}
