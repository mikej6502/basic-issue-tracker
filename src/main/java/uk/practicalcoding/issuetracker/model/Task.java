package uk.practicalcoding.issuetracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String project;
    private TaskType type;
    private String title;
    private String description;
    private TaskStatus status;

    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public String getProject()
    {
        return project;
    }

    public void setProject( String projectKey )
    {
        this.project = projectKey;
    }

    public TaskType getType()
    {
        return type;
    }

    public void setType( TaskType type )
    {
        this.type = type;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle( String title )
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public TaskStatus getStatus()
    {
        return status;
    }

    public void setStatus( TaskStatus taskStatus )
    {
        this.status = taskStatus;
    }
}
