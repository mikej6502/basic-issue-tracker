package uk.practicalcoding.issuetracker.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskTest
{
    @Test
    public void shouldGetTitle()
    {
        Task task = new Task();
        task.setTitle( "Title" );

        assertEquals( "Title", task.getTitle() );
    }
}