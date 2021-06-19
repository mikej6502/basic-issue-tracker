package uk.practicalcoding.issuetracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uk.practicalcoding.issuetracker.model.Project;

public interface ProjectRepository extends MongoRepository<Project, String>
{

}
