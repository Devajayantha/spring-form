package org.devajayantha.springform.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name="allowed_domains")
public class AllowedDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "form_id", referencedColumnName = "id", nullable = false)
    private Form form;

    public AllowedDomain() {}

    public AllowedDomain(String name, Form form) {
        this.name = name;
        this.form = form;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
