package uk.practicalcoding.issuetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.practicalcoding.issuetracker.repository.ProjectRepository;

@RestController
public class HealthController
{
    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/healthcheck")
    public ResponseEntity<String> healthCheck()
    {
        return new ResponseEntity<>( "ok", HttpStatus.OK );
    }
}
