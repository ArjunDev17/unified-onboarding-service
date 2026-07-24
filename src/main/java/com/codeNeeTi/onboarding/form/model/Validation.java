package com.codeNeeTi.onboarding.form.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Validation {

    /**
     * Minimum length.
     */
    private Integer minLength;

    /**
     * Maximum length.
     */
    private Integer maxLength;

    /**
     * Minimum numeric value.
     */
    private Integer minValue;

    /**
     * Maximum numeric value.
     */
    private Integer maxValue;

    /**
     * Regular expression.
     */
    private String regex;

    /**
     * Validation message.
     */
    private String message;

}