package com.codeNeeTi.onboarding.form.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormField {

    /**
     * Unique field name.
     * Example: firstName
     */
    private String name;

    /**
     * Label displayed on UI.
     */
    private String label;

    /**
     * Placeholder text.
     */
    private String placeholder;

    /**
     * UI Component Type.
     */
    private FieldType type;

    /**
     * Whether field is mandatory.
     */
    @Builder.Default
    private Boolean required = false;

    /**
     * Whether field is visible.
     */
    @Builder.Default
    private Boolean visible = true;

    /**
     * Whether field is editable.
     */
    @Builder.Default
    private Boolean readOnly = false;

    /**
     * Default value.
     */
    private Object defaultValue;

    /**
     * Display order.
     */
    private Integer order;

    /**
     * Validation rules.
     */
    private Validation validation;

    /**
     * Used only for Dropdown,
     * Radio,
     * Checkbox etc.
     */
    private List<Option> options;

}