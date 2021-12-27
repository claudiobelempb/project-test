package br.com.surb.surb.modules.category.useCases.CategoryFindById;

import br.com.surb.surb.modules.category.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryFindByIdController {

  @Autowired
  private CategoryFindByIdService categoryFindByIdService;

  @GetMapping(value = "/{id}")
  public ResponseEntity<CategoryDTO> handle(@PathVariable Long id){
    CategoryDTO dto = categoryFindByIdService.execute(id);
    return ResponseEntity.ok().body(dto);
  }

}
