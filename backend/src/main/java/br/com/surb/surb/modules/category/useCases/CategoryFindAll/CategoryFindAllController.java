package br.com.surb.surb.modules.category.useCases.CategoryFindAll;

import br.com.surb.surb.modules.category.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryFindAllController {

  @Autowired
  private CategoryFindAllService categoryFindAllService;

  @GetMapping
  public ResponseEntity<Page<CategoryDTO>> handle(Pageable pageable)
  {
    /*PARAMETRISE: page, size, sort*/
    Page<CategoryDTO> dto = categoryFindAllService.execute(pageable);
    return ResponseEntity.ok().body(dto);
  }

}
