package br.com.surb.surb.modules.category.useCases.CategoryCreate;

import br.com.surb.surb.modules.category.dto.CategoryDTO;
import br.com.surb.surb.modules.category.infra.jpa.entities.Category;
import br.com.surb.surb.modules.category.infra.jpa.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryCreateService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Transactional
  public CategoryDTO execute(CategoryDTO categoryDTO) {
    Category category = new Category();
    category.setName(categoryDTO.getName());
    category = categoryRepository.save(category);
    return new CategoryDTO(category);
  }

}
