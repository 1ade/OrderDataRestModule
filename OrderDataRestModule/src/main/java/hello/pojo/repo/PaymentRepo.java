package hello.pojo.repo;

import hello.pojo.Payment;

import org.springframework.data.repository.PagingAndSortingRepository;
/**
 * A repository to manage {@link Payment} instances.
 * @author ifaturoti_adeyemi
 *
 */
public interface PaymentRepo extends PagingAndSortingRepository<Payment, Long> {

}
