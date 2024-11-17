package org.devajayantha.springform.models.enums;

public enum TypeChoice {
    SHORT_ANSWER("Short Answer"),
    PARAGRAPH("Paragraph"),
    DATE("Date"),
    TIME("Time"),
    MULTIPLE_CHOICE("Multiple Choice"),
    DROPDOWN("Dropdown"),
    CHECKBOX("Checkbox");

    private final String label;


    TypeChoice(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
