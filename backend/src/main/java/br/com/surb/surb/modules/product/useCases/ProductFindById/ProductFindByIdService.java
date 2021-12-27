package br.com.surb.surb.modules.product.useCases.ProductFindById;

import br.com.surb.surb.modules.product.dto.ProductDTO;
import br.com.surb.surb.modules.product.infra.jpa.entities.Product;
import br.com.surb.surb.modules.product.infra.jpa.repositories.ProductRepository;
import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductFindByIdService {

  @Autowired
  private ProductRepository iProductRepository;

  @Transactional(readOnly = true)
  public ProductDTO execute(Long id) {
    Optional<Product> obj = iProductRepository.findById(id);
    Product product = obj.orElseThrow(() -> new AppNotFoundException("Entity not found"));
    return new ProductDTO(product, product.getCategories());
  }

}
