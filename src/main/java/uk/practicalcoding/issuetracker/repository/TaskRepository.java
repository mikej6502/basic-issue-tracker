package uk.practicalcoding.issuetracker.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import uk.practicalcoding.issuetracker.model.Task;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long>
{
    Task findById( long id );

    Page<Task> findAll( Pageable paging );
}
