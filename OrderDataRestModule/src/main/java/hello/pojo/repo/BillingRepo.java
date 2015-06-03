package hello.pojo.repo;

import hello.pojo.Billing;

import org.springframework.data.repository.PagingAndSortingRepository;
/**
 * A repository to manage {@link Billing} instances.
 * @author ifaturoti_adeyemi
 *
 */
public interface BillingRepo extends PagingAndSortingRepository<Billing, Long> {

}
