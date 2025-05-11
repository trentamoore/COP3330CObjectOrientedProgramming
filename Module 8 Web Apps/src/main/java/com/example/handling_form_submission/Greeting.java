package com.example.handling_form_submission;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Represents a greeting message with an id, some content, and a date.
 */
public class Greeting {

    private long id;
    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    /**
     * Returns the id of the greeting.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the id of the greeting.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Returns the date of the greeting.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the greeting.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Returns the content of the greeting.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the greeting.
     */
    public void setContent(String content) {
        this.content = content;
    }
}