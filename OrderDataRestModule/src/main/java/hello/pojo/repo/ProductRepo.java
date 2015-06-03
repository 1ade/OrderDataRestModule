package hello.pojo.repo;

import hello.pojo.Product;

import org.springframework.data.repository.PagingAndSortingRepository;
/**
 * A repository to manage {@link Product} instances.
 * @author ifaturoti_adeyemi
 *
 */
public interface ProductRepo extends PagingAndSortingRepository<Product, Long> {

}
