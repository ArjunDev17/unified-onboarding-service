package com.codeNeeTi.onboarding.form.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Option {

    /**
     * Value stored in database.
     */
    private String value;

    /**
     * Value displayed on UI.
     */
    private String label;

}