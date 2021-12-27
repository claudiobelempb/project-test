package br.com.surb.surb.modules.category.factory;

import br.com.surb.surb.modules.category.dto.CategoryDTO;
import br.com.surb.surb.modules.category.infra.jpa.entities.Category;
import br.com.surb.surb.modules.category.infra.jpa.repositories.CategoryRepository;
import org.springframework.transaction.annotation.Transactional;

public class CategoryFactory {

  @Transactional
  public static CategoryDTO execute(CategoryRepository iCategoryRepository, CategoryDTO dto) {
    Category category = new Category();
    category.setName(dto.getName());
    category = iCategoryRepository.save(category);
    return new CategoryDTO(category);
  }

}
