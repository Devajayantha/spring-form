package org.devajayantha.springform.models.entities;

import jakarta.persistence.*;
import org.devajayantha.springform.models.enums.TypeChoice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name="questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "choice_type", nullable = false)
    private TypeChoice choiceType;

    @Column(name = "is_required", nullable = false)
    private Boolean isRequired;

    @Column(name = "choices", nullable = true, length = 255)
    private String choices;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "form_id", referencedColumnName = "id", nullable = false)
    private Form form;

    public Question() {}

    public Question(String name, TypeChoice choiceType, Boolean isRequired,  Form form) {
        this.name = name;
        this.choiceType = choiceType;
        this.isRequired = isRequired;
        this.form = form;
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

    public TypeChoice getChoiceType() {
        return choiceType;
    }

    public void setChoiceType(TypeChoice choiceType) {
        this.choiceType = choiceType;
    }

    public Boolean getRequired() {
        return isRequired;
    }

    public void setRequired(Boolean required) {
        isRequired = required;
    }

    public List<String> getChoices() {
        if (choices == null || choices.isEmpty()) {
            return new ArrayList<>();
        }
        return Arrays.asList(choices.split(","));
    }

    public void setChoices(List<String> choicesList) {
        if (choicesList == null || choicesList.isEmpty()) {
            this.choices = null;
        } else {
            this.choices = String.join(",", choicesList);
        }
    }

    public Form getForm() {return form;}

    public void setForm(Form form) {this.form = form;}
}
