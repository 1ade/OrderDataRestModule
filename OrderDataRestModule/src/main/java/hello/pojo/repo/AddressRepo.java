/**
 * 
 */
package hello.pojo.repo;

import hello.pojo.Address;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * A repository to manage {@link Address} instances.
 * @author ifaturoti_adeyemi
 *
 */
public interface AddressRepo extends PagingAndSortingRepository<Address, Long> {

}
