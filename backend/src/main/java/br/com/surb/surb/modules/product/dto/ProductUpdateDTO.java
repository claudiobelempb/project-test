package br.com.surb.surb.modules.product.dto;

import br.com.surb.surb.modules.category.dto.CategoryDTO;
import br.com.surb.surb.modules.category.infra.jpa.entities.Category;
import br.com.surb.surb.modules.product.infra.jpa.entities.Product;
import br.com.surb.surb.shared.enums.TypeStatus;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductUpdateDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  private String description;
  private Double price;
  private String imgUrl;
  private TypeStatus status;
  private Instant createdAt;
  private Instant updatedAt;

  private final List<CategoryDTO> categories = new ArrayList<>();

  public ProductUpdateDTO(){}

  public ProductUpdateDTO(Long id, String name, String description, Double price, String imgUrl, TypeStatus status,
                          Instant createdAt, Instant updatedAt) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.imgUrl = imgUrl;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public ProductUpdateDTO(Product product){
    id = product.getId();
    name = product.getName();
    description = product.getDescription();
    price = product.getPrice();
    imgUrl = product.getImgUrl();
    status = product.getStatus();
    createdAt = product.getCreatedAt();
    updatedAt = product.getUpdatedAt();
  }

  public ProductUpdateDTO(Product product, Set<Category> categories) {
    this(product);
    categories.forEach(category -> this.categories.add(new CategoryDTO(category)));
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public TypeStatus getStatus() {
    return status;
  }

  public void setStatus(TypeStatus status) {
    this.status = status;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public List<CategoryDTO> getCategories() {
    return categories;
  }

}
