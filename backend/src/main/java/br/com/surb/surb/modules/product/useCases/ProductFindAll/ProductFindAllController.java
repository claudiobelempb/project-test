package br.com.surb.surb.modules.product.useCases.ProductFindAll;

import br.com.surb.surb.modules.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/products")
public class ProductFindAllController {

  @Autowired
  private ProductFindAllService productFindAllService;

  @GetMapping
  public ResponseEntity<Page<ProductDTO>> handle(Pageable pageable) {
    Page<ProductDTO> page = productFindAllService.execute(pageable);
    return ResponseEntity.ok().body(page);
  }


}
