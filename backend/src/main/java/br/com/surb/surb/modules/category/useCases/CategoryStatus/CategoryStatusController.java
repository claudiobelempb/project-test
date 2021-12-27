package br.com.surb.surb.modules.category.useCases.CategoryStatus;

import br.com.surb.surb.modules.category.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryStatusController {

  @Autowired
  private CategoryStatusService categoryStatusService;


  @PatchMapping(value = "/status/{id}")
  public ResponseEntity<Void> handle(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO){
    categoryStatusService.execute(id, categoryDTO);
    return ResponseEntity.noContent().build();
  }


}
