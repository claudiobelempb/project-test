package br.com.surb.surb.modules.category.useCases.CategoryUpdate;

import br.com.surb.surb.modules.category.dto.CategoryDTO;
import br.com.surb.surb.modules.category.infra.jpa.entities.Category;
import br.com.surb.surb.modules.category.infra.jpa.repositories.CategoryRepository;
import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class CategoryUpdateService {

  @Autowired
  private CategoryRepository iCategoryRepository;

  @Transactional
  public CategoryDTO execute(Long id, CategoryDTO dto) {
    try {
      Category category = iCategoryRepository.getById(id);
      category.setName(dto.getName());
      category = iCategoryRepository.save(category);
      return new CategoryDTO(category);
    } catch (EntityNotFoundException e){
      throw new AppNotFoundException("Id not found" + id);
    }
  }

}
