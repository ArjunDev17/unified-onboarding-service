package com.codeNeeTi.onboarding.form.service;

import com.codeNeeTi.onboarding.form.model.FormConfig;

/**
 * Service responsible for providing dynamic form configurations
 * for different entity types like Student, Teacher, Employee, etc.
 */
public interface FormService {

    /**
     * Returns the form configuration for the given entity type.
     *
     * Example:
     * student
     * teacher
     * employee
     * merchant
     *
     * @param entityType Entity for which form configuration is required.
     * @return Form configuration.
     */
    FormConfig getFormConfiguration(String entityType);
}