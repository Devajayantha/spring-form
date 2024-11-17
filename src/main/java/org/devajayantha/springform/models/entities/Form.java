package org.devajayantha.springform.models.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name="forms")
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "slug", nullable = false, length = 100, unique = true)
    private String slug;

    @Column(name= "description", nullable = false, length = 255)
    private String description;

    @Column(name= "is_one_response")
    private Boolean isOneResponse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "created_id", referencedColumnName = "id", nullable = false)
    private User createdBy;

    public Form() {}

    public Form(String name, String slug, String description, Boolean isOneResponse, User createdBy) {
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.isOneResponse = isOneResponse;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getOneResponse() {
        return isOneResponse;
    }

    public void setOneResponse(Boolean oneResponse) {
        isOneResponse = oneResponse;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
