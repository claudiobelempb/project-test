package br.com.surb.surb.modules.product.infra.jpa.repositories;

import br.com.surb.surb.modules.product.infra.jpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
