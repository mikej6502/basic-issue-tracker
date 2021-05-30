package uk.practicalcoding.issuetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import uk.practicalcoding.issuetracker.model.Task;
import uk.practicalcoding.issuetracker.repository.TaskRepository;

import java.util.List;

@RestController
public class TaskController
{
    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/task/{id}")
    public Task getTask( @PathVariable(value = "id") long id )
    {
        return taskRepository.findById( id );
    }

    @GetMapping("/task")
    public List<Task> getTask( @RequestParam(defaultValue = "0") Integer pageNo,
                               @RequestParam(defaultValue = "10") Integer pageSize,
                               @RequestParam(defaultValue = "id") String sortBy )
    {
        final Pageable paging = PageRequest.of( pageNo, pageSize, Sort.by( sortBy ) );
        final Page<Task> pagedResult = taskRepository.findAll( paging );

        return pagedResult.getContent();
    }

    @PostMapping("/task")
    public Task createTask( @RequestBody Task newTask )
    {
        return taskRepository.save( newTask );
    }

    @PutMapping("/task/{id}")
    Task replaceTask( @RequestBody Task newTask, @PathVariable Long id )
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
