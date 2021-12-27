package br.com.surb.surb.modules.product.useCases.ProductStatus;

import br.com.surb.surb.modules.product.dto.ProductDTO;
import br.com.surb.surb.modules.product.infra.jpa.entities.Product;
import br.com.surb.surb.modules.product.infra.jpa.repositories.ProductRepository;
import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class ProductStatusService {

  @Autowired
  private ProductRepository iProductRepository;

  @Transactional
  public void execute(Long id, ProductDTO dto) {
    try {
      Product product = iProductRepository.getById(id);
      product.setStatus(dto.getStatus());
      iProductRepository.save(product);
    } catch (EntityNotFoundException e){
      throw new AppNotFoundException("Id not found " + id);
    }
  }
}
