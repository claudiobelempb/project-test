package br.com.surb.surb.modules.category.useCases.CayegoryDelete;

import br.com.surb.surb.modules.category.infra.jpa.repositories.CategoryRepository;
import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import br.com.surb.surb.shared.exeptions.services.DataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CategoryDeleteService {

  @Autowired
  private CategoryRepository iCategoryRepository;

  public void execute(Long id) {
    try {
      iCategoryRepository.deleteById(id);
    } catch (EmptyResultDataAccessException e){
      throw new AppNotFoundException("Id not found" + id);
    } catch (DataIntegrityViolationException e) {
      throw new DataBaseException("Integrity violation");
    }
  }

}
