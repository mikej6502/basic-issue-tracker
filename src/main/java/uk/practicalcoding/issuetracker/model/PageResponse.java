package uk.practicalcoding.issuetracker.model;

import org.springframework.data.domain.Page;

public class PageResponse
{
    private final long totalItems;
    private final int currentPage;
    private final int totalPages;

    public PageResponse( Page page )
    {
        this.totalItems = page.getTotalElements();
        this.currentPage = page.getNumber();
        this.totalPages = page.getTotalPages();
    }

    public long getTotalItems()
    {
        return totalItems;
    }

    public int getCurrentPage()
    {
        return currentPage;
    }

    public int getTotalPages()
    {
        return totalPages;
    }
}
