package br.com.surb.surb.modules.product.useCases.ProductFindAll;

import br.com.surb.surb.modules.product.dto.ProductDTO;
import br.com.surb.surb.modules.product.infra.jpa.entities.Product;
import br.com.surb.surb.modules.product.infra.jpa.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductFindAllService {

  @Autowired
  private ProductRepository iProductRepository;

  @Transactional(readOnly = true)
  public Page<ProductDTO> execute(Pageable pageable) {
    Page<Product> products = iProductRepository.findAll(pageable);
    return products.map(product -> new ProductDTO(product));
  }


}
