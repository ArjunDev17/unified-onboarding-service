package com.codeNeeTi.onboarding.form.provider;

import com.codeNeeTi.onboarding.form.model.FormConfig;

public interface FormProvider {

    /**
     * Returns true if this provider supports the given entity type.
     *
     * Example:
     * student
     * teacher
     * employee
     */
    boolean supports(String entityType);

    /**
     * Returns complete form configuration.
     */
    FormConfig getFormConfiguration();
}