package uk.practicalcoding.issuetracker.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import uk.practicalcoding.issuetracker.model.Project;
import uk.practicalcoding.issuetracker.model.Task;

public interface ProjectRepository extends MongoRepository<Project, String>
{
    Project findBy( String id );

    Project findByTitle( String title );

    Page<Project> findAll( Pageable paging );
}
