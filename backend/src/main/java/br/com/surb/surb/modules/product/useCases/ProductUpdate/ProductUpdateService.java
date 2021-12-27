package br.com.surb.surb.modules.product.useCases.ProductUpdate;

import br.com.surb.surb.modules.category.infra.jpa.repositories.CategoryRepository;
import br.com.surb.surb.modules.product.dto.ProductUpdateDTO;
import br.com.surb.surb.modules.product.factory.ProductUpdateFactory;
import br.com.surb.surb.modules.product.infra.jpa.entities.Product;
import br.com.surb.surb.modules.product.infra.jpa.repositories.ProductRepository;
import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class ProductUpdateService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Transactional
  public ProductUpdateDTO execute(Long id, ProductUpdateDTO productUpdateDTO){
    try{
      Product product = productRepository.getById(id);
//      copyDtoToProduct(productUpdateDTO, product);
      ProductUpdateFactory.copyDtoToProduct(productUpdateDTO, product);
      product = productRepository.save(product);
      return new ProductUpdateDTO(product);
    }catch (EntityNotFoundException e){
      throw new AppNotFoundException("ID not found " + id);
    }
  }

//  private void copyDtoToProduct(ProductUpdateDTO productUpdateDTO, Product product) {
//    product.setName(productUpdateDTO.getName());
//    product.setDescription(productUpdateDTO.getDescription());
//    product.setPrice(productUpdateDTO.getPrice());
//    product.setImgUrl(productUpdateDTO.getImgUrl());
//
//    product.getCategories().clear();
//    for (CategoryDTO categoryDTO : productUpdateDTO.getCategories()) {
//      Category category = categoryRepository.getById(categoryDTO.getId());
//      product.getCategories().add(category);
//    }
//  }

}
