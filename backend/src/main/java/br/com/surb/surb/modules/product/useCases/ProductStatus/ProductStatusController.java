package br.com.surb.surb.modules.product.useCases.ProductStatus;

import br.com.surb.surb.modules.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/products")
public class ProductStatusController {

  @Autowired
  private ProductStatusService productStatusService;

  @PatchMapping(value = "/status/{id}")
  public ResponseEntity<Void> handle(@PathVariable Long id, @RequestBody ProductDTO dto){
    productStatusService.execute(id, dto);
    return ResponseEntity.noContent().build();
  }
}
