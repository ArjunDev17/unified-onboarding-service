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
public class FormConfig {

    /**
     * Unique identifier of the form.
     * Example: student-registration
     */
    private String formId;

    /**
     * Form title displayed on UI.
     */
    private String title;

    /**
     * Small description shown below the title.
     */
    private String description;

    /**
     * Version of the form.
     * Useful when forms evolve over time.
     */
    @Builder.Default
    private Integer version = 1;

    /**
     * Whether the form is active.
     */
    @Builder.Default
    private Boolean active = true;

    /**
     * List of fields to render.
     */
    private List<FormField> fields;

}