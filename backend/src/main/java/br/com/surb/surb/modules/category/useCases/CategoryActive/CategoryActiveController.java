package br.com.surb.surb.modules.category.useCases.CategoryActive;

import br.com.surb.surb.modules.category.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryActiveController {

  @Autowired
  private CategoryActiveService categoryActiveService;


  @PatchMapping(value = "/active/{id}")
  public ResponseEntity<Void> handle(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO){
    categoryActiveService.execute(id, categoryDTO);
    return ResponseEntity.noContent().build();
  }
}
