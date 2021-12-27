package br.com.surb.surb.modules.category.useCases.CategoryActive;

import br.com.surb.surb.modules.category.dto.CategoryDTO;
import br.com.surb.surb.modules.category.infra.jpa.entities.Category;
import br.com.surb.surb.modules.category.infra.jpa.repositories.CategoryRepository;
import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;

@Service
public class CategoryActiveService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Transactional
  public void execute(Long id, CategoryDTO categoryDTO){
    try {
      Objects.requireNonNull(id);
      Category category = categoryRepository.getById(id);
      category.setStatus(categoryDTO.getStatus());
      categoryRepository.save(category);
    } catch (EntityNotFoundException e) {
      throw new AppNotFoundException("Id not found " + id);
    }
  }
}
