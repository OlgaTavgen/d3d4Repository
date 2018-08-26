package com.epam.podcast.beans;

import java.io.Serializable;
import java.util.Date;

public class Podcast implements Serializable
{
    private static final long serialVersionUID = -8039686696076337053L;
    private Long id;
    private String title;
    private String linkOnPodcastpedia;
    private String feed;
    private String description;
    private Date insertionDate;

    public Podcast(Long id, String title, String linkOnPodcastpedia, String feed,
        String description)
    {
        this.id = id;
        this.title = title;
        this.linkOnPodcastpedia = linkOnPodcastpedia;
        this.feed = feed;
        this.description = description;

    }

    public Podcast()
    {
    }

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getLinkOnPodcastpedia()
    {
        return linkOnPodcastpedia;
    }

    public void setLinkOnPodcastpedia(String linkOnPodcastpedia)
    {
        this.linkOnPodcastpedia = linkOnPodcastpedia;
    }

    public String getFeed()
    {
        return feed;
    }

    public void setFeed(String feed)
    {
        this.feed = feed;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getInsertionDate()
    {
        return insertionDate;
    }

    public void setInsertionDate(Date insertionDate)
    {
        this.insertionDate = insertionDate;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Podcast podcast = (Podcast) o;

        if (getId() != null ? !getId().equals(podcast.getId()) : podcast.getId() != null)
            return false;
        if (getTitle() != null ? !getTitle().equals(podcast.getTitle()) : podcast.getTitle() != null)
            return false;
        if (getLinkOnPodcastpedia() != null ?
            !getLinkOnPodcastpedia().equals(podcast.getLinkOnPodcastpedia()) :
            podcast.getLinkOnPodcastpedia() != null)
            return false;
        if (getFeed() != null ? !getFeed().equals(podcast.getFeed()) : podcast.getFeed() != null)
            return false;
        if (getDescription() != null ? !getDescription().equals(podcast.getDescription()) : podcast.getDescription() != null)
            return false;
        return getInsertionDate() != null ?
            getInsertionDate().equals(podcast.getInsertionDate()) :
            podcast.getInsertionDate() == null;
    }

    @Override
    public int hashCode()
    {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getLinkOnPodcastpedia() != null ? getLinkOnPodcastpedia().hashCode() : 0);
        result = 31 * result + (getFeed() != null ? getFeed().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getInsertionDate() != null ? getInsertionDate().hashCode() : 0);
        return result;
    }
}
