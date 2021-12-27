package br.com.surb.surb.modules.category.infra.jpa.repositories;

import br.com.surb.surb.modules.category.infra.jpa.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

//  Optional<Category> findByIdAndActive(Long id, Boolean active);
//
//  Optional<Category> findByNameAndActive(Long id, Boolean active);

//  @Modifying(clearAutomatically = true, flushAutomatically = true)
//  @Query("UPDATE tb_category category SET category.active = false WHERE category.id = :id")
//  void deactivate(@Param("id") Long id);
}
