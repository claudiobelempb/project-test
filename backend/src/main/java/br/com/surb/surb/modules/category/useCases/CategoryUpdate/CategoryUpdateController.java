package br.com.surb.surb.modules.category.useCases.CategoryUpdate;

import br.com.surb.surb.modules.category.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryUpdateController {

  @Autowired
  private CategoryUpdateService categoryUpdateService;

  @PutMapping(value = "/{id}")
  public ResponseEntity<CategoryDTO> handle(@PathVariable Long id, @RequestBody CategoryDTO dto){
    dto = categoryUpdateService.execute(id, dto);
    return ResponseEntity.ok().body(dto);
  }

}
