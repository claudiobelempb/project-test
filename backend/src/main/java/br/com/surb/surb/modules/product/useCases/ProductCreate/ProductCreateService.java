package br.com.surb.surb.modules.product.useCases.ProductCreate;

import br.com.surb.surb.modules.category.infra.jpa.repositories.CategoryRepository;
import br.com.surb.surb.modules.product.dto.ProductCreateDTO;
import br.com.surb.surb.modules.product.factory.ProductCreateFactory;
import br.com.surb.surb.modules.product.infra.jpa.entities.Product;
import br.com.surb.surb.modules.product.infra.jpa.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductCreateService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Transactional
  public ProductCreateDTO execute(ProductCreateDTO productCreateDTO){
    Product product = new Product();
//    copyDtoToProduct(dto, product);
    ProductCreateFactory.copyDtoToProduct(productCreateDTO, product);
    product = productRepository.save(product);
    return new ProductCreateDTO(product);
  }

//  private void copyDtoToProduct(ProductDTO productDTO, Product product) {
//    product.setName(productDTO.getName());
//    product.setDescription(productDTO.getDescription());
//    product.setPrice(productDTO.getPrice());
//    product.setImgUrl(productDTO.getImgUrl());
//
//    product.getCategories().clear();
//    for (CategoryDTO categoryDTO : productDTO.getCategories()) {
//      Category category = categoryRepository.getById(categoryDTO.getId());
//      product.getCategories().add(category);
//    }
//  }

}
