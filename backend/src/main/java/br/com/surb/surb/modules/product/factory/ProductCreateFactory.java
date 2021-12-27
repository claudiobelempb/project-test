package br.com.surb.surb.modules.product.factory;

import br.com.surb.surb.modules.category.dto.CategoryDTO;
import br.com.surb.surb.modules.category.infra.jpa.entities.Category;
import br.com.surb.surb.modules.category.infra.jpa.repositories.CategoryRepository;
import br.com.surb.surb.modules.product.dto.ProductCreateDTO;
import br.com.surb.surb.modules.product.infra.jpa.entities.Product;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ProductCreateFactory implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private static CategoryRepository categoryRepository;
  
  public ProductCreateFactory(CategoryRepository categoryRepository){
    ProductCreateFactory.categoryRepository = categoryRepository;
  }

  public static void copyDtoToProduct(ProductCreateDTO productCreateDTO, Product product) {
    product.setName(productCreateDTO.getName());
    product.setDescription(productCreateDTO.getDescription());
    product.setPrice(productCreateDTO.getPrice());
    product.setImgUrl(productCreateDTO.getImgUrl());

    product.getCategories().clear();
    for (CategoryDTO categoryDTO : productCreateDTO.getCategories()) {
      Category category = categoryRepository.getById(categoryDTO.getId());
      product.getCategories().add(category);
    }
  }

}
