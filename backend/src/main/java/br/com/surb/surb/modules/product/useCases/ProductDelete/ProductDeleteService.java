package br.com.surb.surb.modules.product.useCases.ProductDelete;

import br.com.surb.surb.modules.product.infra.jpa.repositories.ProductRepository;
import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import br.com.surb.surb.shared.exeptions.services.DataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ProductDeleteService {

  @Autowired
  private ProductRepository iProductRepository;

  public void execute(Long id) {
    try{
      iProductRepository.deleteById(id);
    }catch (EmptyResultDataAccessException e){
      throw new AppNotFoundException("ID not found " + id);
    }catch (DataIntegrityViolationException e){
      throw new DataBaseException("Integrity violation");
    }
  }

}
