package br.com.surb.surb.modules.category.useCases.CategoryFindAll;

import br.com.surb.surb.modules.category.dto.CategoryDTO;
import br.com.surb.surb.modules.category.infra.jpa.entities.Category;
import br.com.surb.surb.modules.category.infra.jpa.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryFindAllService {

  @Autowired
  private CategoryRepository iCategoryRepository;

  @Transactional(readOnly = true)
  public Page<CategoryDTO> execute(Pageable pageable){
    Page<Category> categories = iCategoryRepository.findAll(pageable);
    return categories.map(category -> new CategoryDTO(category));
  }

//  @Transactional(readOnly = true)
//  public Page<CategoryDTO> execute(PageRequest pageRequest){
//    Page<Category> categories = iCategoryRepository.findAll(pageRequest);
//    return categories.map(category -> new CategoryDTO(category));
//  }

//  @Transactional(readOnly = true)
//  public List<CategoryDTO> executeMap(){
//    List<Category> categories = repository.findAll();
//    return categories.stream().map(category -> new CategoryDTO(category)).collect(Collectors.toList());
//  }
//
//  @Transactional(readOnly = true)
//  public List<CategoryDTO> executeList(){
//    List<Category> categories = repository.findAll();
//
//    List<CategoryDTO> dtos = new ArrayList<>();
//    for (Category category : categories) {
//      dtos.add(new CategoryDTO(category));
//    }
//    return dtos;
//  }

}
