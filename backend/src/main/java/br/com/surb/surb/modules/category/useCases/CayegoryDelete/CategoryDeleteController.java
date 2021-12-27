package br.com.surb.surb.modules.category.useCases.CayegoryDelete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryDeleteController {

  @Autowired
  private CategoryDeleteService categoryDeleteService;

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> handle(@PathVariable Long id){
    categoryDeleteService.execute(id);
    return ResponseEntity.noContent().build();
  }
}
