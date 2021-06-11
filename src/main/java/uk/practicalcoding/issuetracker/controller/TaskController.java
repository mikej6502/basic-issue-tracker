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
import uk.practicalcoding.issuetracker.model.Task;
import uk.practicalcoding.issuetracker.repository.TaskRepository;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TaskController
{
    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/task/{id}")
    public Task getTask( @PathVariable(value = "id") String id )
    {
        return taskRepository.findById( id ).get();
    }

    @GetMapping("/task")
    public ResponseEntity<Map<String, Object>> getTask( @RequestParam(defaultValue = "0") Integer pageNo,
                                                        @RequestParam(defaultValue = "5") Integer pageSize,
                                                        @RequestParam(defaultValue = "id") String sortBy )
    {
        final Pageable paging = PageRequest.of( pageNo, pageSize, Sort.by( sortBy ) );
        final Page<Task> page = taskRepository.findAll( paging );

        final Map<String, Object> response = new HashMap<>();
        response.put( "tasks", page.getContent() );
        response.put( "pages", new PageResponse( page ) );

        return new ResponseEntity<>( response, HttpStatus.OK );
    }

    @PostMapping("/task")
    public Task createTask( @RequestBody Task newTask )
    {
        return taskRepository.save( newTask );
    }

    @PutMapping("/task/{id}")
    Task replaceTask( @RequestBody Task newTask, @PathVariable String id )
    {
        final Task updatedTask = taskRepository.findById( id )
                .map( task ->
                {
                    task.setTitle( newTask.getTitle() );
                    task.setDescription( newTask.getDescription() );
                    task.setStatus( newTask.getStatus() );
                    task.setProject( newTask.getProject() );
                    task.setType( newTask.getType() );

                    return taskRepository.save( task );
                } )
                .orElseGet( () ->
                {
                    newTask.setId( id );
                    return taskRepository.save( newTask );
                } );

        return updatedTask;
    }
}
