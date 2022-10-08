package com.vvvital.model;

import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Component
public class Competition {
    private Integer id;
    private String name;
    private LocalDateTime date;
    @MappedCollection(idColumn = "compt_id")
    private List<User> members;
    private String description;

    public Competition(String name, LocalDateTime date, String description) {
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

    public LocalDateTime getDate() {
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

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", members=" + members +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competition that = (Competition) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(date, that.date)  && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, members, description);
    }
}
