package org.devajayantha.springform.models.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="answers")
public class Answer {    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    @Column(name="response", nullable = false)
    private String response;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "form_id", referencedColumnName = "id", nullable = false)
    private Form form;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "created_id", referencedColumnName = "id", nullable = false)
    private User createdBy;

    @Column(name="created_at", nullable = false, updatable = false)
    private Date createdAt;

    public Answer() {}

    public Answer(String response, Form form, User createdBy) {
        this.response = response;
        this.form = form;
        this.createdBy = createdBy;
        this.createdAt = new Date();
    }
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
