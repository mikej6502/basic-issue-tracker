package uk.practicalcoding.issuetracker.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import uk.practicalcoding.issuetracker.model.Task;

public interface TaskRepository extends MongoRepository<Task, String>
{
    Task findBy( String id );

    Page<Task> findAll( Pageable paging );
}
