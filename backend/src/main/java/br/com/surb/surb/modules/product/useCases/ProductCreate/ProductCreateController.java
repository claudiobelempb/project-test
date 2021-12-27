package br.com.surb.surb.modules.product.useCases.ProductCreate;

import br.com.surb.surb.modules.product.dto.ProductCreateDTO;
import br.com.surb.surb.modules.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/products")
public class ProductCreateController {

  @Autowired
  private ProductCreateService productCreateService;

  @PostMapping
  public ResponseEntity<ProductCreateDTO> handle(@RequestBody ProductCreateDTO productCreateDTO){
    productCreateDTO = productCreateService.execute(productCreateDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(productCreateDTO.getId()).toUri();
    return ResponseEntity.created(uri).body(productCreateDTO);
  }

}
