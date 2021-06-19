package uk.practicalcoding.issuetracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uk.practicalcoding.issuetracker.model.Task;

public interface TaskRepository extends MongoRepository<Task, String>
{

}
