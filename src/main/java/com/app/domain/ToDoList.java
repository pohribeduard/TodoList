package com.app.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.app.json.JsonDateSerializer;

@Entity
public class ToDoList {

    @Id @GeneratedValue
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String slug;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat ( pattern="M/dd/yyyy hh:mm:ss a")
    private Date postedOn;

    private Boolean active;

    @NotNull
    @ManyToOne
    private User user;

    @Size(min=1)
    @ElementCollection
    private List<String> todos;

    public ToDoList(){
        this.postedOn = new Date();
        this.active = true;
    }

    public ToDoList(String title){
        this.setTitle(title);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTodos() {
        return todos;
    }

    public void setTodos(List<String> todos) {
        this.todos = todos;
    }

    @JsonSerialize(using=JsonDateSerializer.class)
    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User u) {
        this.user = user;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Post [title=" + title + "]";
    }


}
