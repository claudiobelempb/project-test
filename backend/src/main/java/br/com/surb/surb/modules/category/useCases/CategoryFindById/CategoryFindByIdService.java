package br.com.surb.surb.modules.category.useCases.CategoryFindById;

import br.com.surb.surb.modules.category.dto.CategoryDTO;
import br.com.surb.surb.modules.category.infra.jpa.entities.Category;
import br.com.surb.surb.modules.category.infra.jpa.repositories.CategoryRepository;
import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CategoryFindByIdService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Transactional(readOnly = true)
  public CategoryDTO execute(Long id) {

    Optional<Category> obj = categoryRepository.findById(id);
    Category category = obj.orElseThrow(() -> new AppNotFoundException("Entity not found"));
    return new CategoryDTO(category, category.getProducts());
  }

}
