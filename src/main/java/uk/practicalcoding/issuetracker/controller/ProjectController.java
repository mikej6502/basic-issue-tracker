package uk.practicalcoding.issuetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.practicalcoding.issuetracker.model.PageResponse;
import uk.practicalcoding.issuetracker.model.Project;
import uk.practicalcoding.issuetracker.repository.ProjectRepository;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProjectController
{
    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/project")
    public ResponseEntity<Map<String, Object>> getTask( @RequestParam(defaultValue = "0") Integer pageNo,
                                                        @RequestParam(defaultValue = "5") Integer pageSize,
                                                        @RequestParam(defaultValue = "id") String sortBy )
    {
        final Pageable paging = PageRequest.of( pageNo, pageSize, Sort.by( sortBy ) );
        final Page<Project> page = projectRepository.findAll( paging );

        final Map<String, Object> response = new HashMap<>();
        response.put( "projects", page.getContent() );
        response.put( "pages", new PageResponse( page ) );

        return new ResponseEntity<>( response, HttpStatus.OK );
    }

    @PostMapping("/project")
    public Project createTask( @RequestBody Project newProject )
    {
        return projectRepository.save( newProject );
    }
}
