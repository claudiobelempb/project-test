package br.com.surb.surb.modules.category.dto;

import br.com.surb.surb.modules.category.infra.jpa.entities.Category;
import br.com.surb.surb.modules.product.dto.ProductDTO;
import br.com.surb.surb.modules.product.infra.jpa.entities.Product;
import br.com.surb.surb.shared.enums.TypeStatus;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  private Instant createdAt;
  private Instant updatedAt;
  private TypeStatus status;

  private final List<ProductDTO> products = new ArrayList<>();

  public CategoryDTO(){}

  public CategoryDTO(Long id, String name, Instant createdAt, Instant updatedAt, TypeStatus status) {
    this.id = id;
    this.name = name;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.status = status;
  }

  public CategoryDTO(Category category){
    id = category.getId();
    name = category.getName();
    createdAt = category.getCreatedAt();
    updatedAt = category.getUpdatedAt();
    status = category.getStatus();
  }

  public CategoryDTO(Category category, Set<Product> products) {
    this(category);
    products.forEach(product -> this.products.add(new ProductDTO(product)));
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

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public TypeStatus getStatus() {
    return status;
  }

  public void setStatus(TypeStatus status) {
    this.status = status;
  }

  public List<ProductDTO> getProducts() {
    return products;
  }

  @Override
  public String toString() {
    return "CategoryDTO{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", createdAt=" + createdAt +
      ", updatedAt=" + updatedAt +
      ", status=" + status +
      ", products=" + products +
      '}';
  }
}
