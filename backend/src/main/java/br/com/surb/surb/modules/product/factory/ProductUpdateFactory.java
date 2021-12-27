package br.com.surb.surb.modules.product.factory;

import br.com.surb.surb.modules.category.dto.CategoryDTO;
import br.com.surb.surb.modules.category.infra.jpa.entities.Category;
import br.com.surb.surb.modules.category.infra.jpa.repositories.CategoryRepository;
import br.com.surb.surb.modules.product.dto.ProductUpdateDTO;
import br.com.surb.surb.modules.product.infra.jpa.entities.Product;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ProductUpdateFactory implements Serializable {

  private static final long serialVersionUID = 1L;

  private static CategoryRepository categoryRepository;

  public ProductUpdateFactory(CategoryRepository categoryRepository){
    ProductUpdateFactory.categoryRepository = categoryRepository;
  }

  public static void copyDtoToProduct(ProductUpdateDTO productUpdateDTO, Product product) {
    product.setName(productUpdateDTO.getName());
    product.setDescription(productUpdateDTO.getDescription());
    product.setPrice(productUpdateDTO.getPrice());
    product.setImgUrl(productUpdateDTO.getImgUrl());

    product.getCategories().clear();
    for (CategoryDTO categoryDTO : productUpdateDTO.getCategories()) {
      Category category = categoryRepository.getById(categoryDTO.getId());
      product.getCategories().add(category);
    }
  }

}
