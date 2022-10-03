package com.vvvital.model;

import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class Competition {
    private Integer id;
    private String name;
    private Date date;
    @MappedCollection(idColumn = "compt_id")
    private List<User> members;
    private String description;

    public Competition(Integer id, String name, Date date, List<User> membersScore, String description) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
    }

    public Competition() {
    }

    public void addMember(User user){
        members.add(user);
    }

    public void deleteMember(User user){
        members.remove(user);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public List<User> getMembers() {
        return members;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
