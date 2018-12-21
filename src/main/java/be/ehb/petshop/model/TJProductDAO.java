package be.ehb.petshop.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TJProductDAO extends CrudRepository<TJProduct, Integer> {

    List<TJProduct> findAllByCategory(String cat);

}
