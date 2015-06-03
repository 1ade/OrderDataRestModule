package hello.pojo.repo;

import hello.pojo.Customer;

import org.springframework.data.repository.PagingAndSortingRepository;
/**
 * A repository to manage {@link Customer} instances.
 * @author ifaturoti_adeyemi
 *
 */
public interface CustomerRepo extends PagingAndSortingRepository<Customer, Long> {

}
