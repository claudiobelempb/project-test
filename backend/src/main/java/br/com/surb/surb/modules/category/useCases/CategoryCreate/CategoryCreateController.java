package br.com.surb.surb.modules.category.useCases.CategoryCreate;

import br.com.surb.surb.modules.category.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryCreateController {

  @Autowired
  private CategoryCreateService categoryCreateService;

  @PostMapping
  public ResponseEntity<CategoryDTO> handle(@RequestBody CategoryDTO categoryDTO){
    System.out.println(categoryDTO);
    categoryDTO = categoryCreateService.execute(categoryDTO);
    System.out.println(categoryDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(categoryDTO.getId()).toUri();
    return ResponseEntity.created(uri).body(categoryDTO);

  }
}
