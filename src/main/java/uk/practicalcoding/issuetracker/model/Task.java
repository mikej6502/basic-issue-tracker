package uk.practicalcoding.issuetracker.model;

import org.springframework.data.annotation.Id;



public class Task
{
    @Id
    private String id;
    private String project;
    private TaskType type;
    private String title;
    private String description;
    private TaskStatus status;

    public String getId()
    {
        return id;
    }

    public void setId( String id )
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
