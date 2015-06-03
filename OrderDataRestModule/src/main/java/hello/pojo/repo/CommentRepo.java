package hello.pojo.repo;

import hello.pojo.Comment;

import org.springframework.data.repository.PagingAndSortingRepository;
/**
 * A repository to manage {@link Comment} instances.
 * @author ifaturoti_adeyemi
 *
 */
public interface CommentRepo extends PagingAndSortingRepository<Comment, Long> {

}
