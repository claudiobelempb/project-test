package br.com.surb.surb.modules.product.useCases.ProductFindById;

import br.com.surb.surb.modules.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/products")
public class ProductFindByIdController {

  @Autowired
  private ProductFindByIdService productFindByIdService;

  @GetMapping(value = "/{id}")
  public ResponseEntity<ProductDTO> handle(@PathVariable Long id) {
    ProductDTO dto = productFindByIdService.execute(id);
    return ResponseEntity.ok().body(dto);
  }

}
