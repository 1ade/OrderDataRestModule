package hello.pojo.repo;

import hello.pojo.Order;

import org.springframework.data.repository.PagingAndSortingRepository;
/**
 * A repository to manage {@link Order} instances.
 * @author ifaturoti_adeyemi
 *
 */
public interface OrderRepo extends PagingAndSortingRepository<Order, Long> {

}
