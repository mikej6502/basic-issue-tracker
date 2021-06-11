package uk.practicalcoding.issuetracker.model;

import org.springframework.data.annotation.Id;

public class Project
{
    @Id
    private String id;
    private String key;
    private String title;
    private String description;

    public Project()
    {
        this( "", "", "", "" );
    }

    public Project( String id, String key, String title, String description )
    {
        this.id = id;
        this.key = key;
        this.title = title;
        this.description = description;
    }

    public String getId()
    {
        return id;
    }

    public void setId( String id )
    {
        this.id = id;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey( String key )
    {
        this.key = key;
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
}
