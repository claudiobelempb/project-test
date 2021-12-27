package br.com.surb.surb.modules.product.useCases.ProductUpdate;

import br.com.surb.surb.modules.product.dto.ProductDTO;
import br.com.surb.surb.modules.product.dto.ProductUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/products")
public class ProductUpdateController {

  @Autowired
  private ProductUpdateService productUpdateService;

  @PutMapping(value = "/{id}")
  public ResponseEntity<ProductUpdateDTO> handle(@PathVariable Long id, @RequestBody ProductUpdateDTO productUpdateDTO){
    productUpdateDTO = productUpdateService.execute(id, productUpdateDTO);
    return ResponseEntity.ok().body(productUpdateDTO);
  }

}
