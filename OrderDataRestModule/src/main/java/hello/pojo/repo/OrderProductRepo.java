package hello.pojo.repo;

import hello.pojo.OrderProduct;

import org.springframework.data.repository.PagingAndSortingRepository;
/**
 * A repository to manage {@link OrderProduct} instances.
 * @author ifaturoti_adeyemi
 *
 */
public interface OrderProductRepo extends PagingAndSortingRepository<OrderProduct, Long> {

}
