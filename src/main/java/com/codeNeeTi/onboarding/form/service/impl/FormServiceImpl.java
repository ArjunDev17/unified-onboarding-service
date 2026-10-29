package com.codeNeeTi.onboarding.form.service.impl;

import com.codeNeeTi.onboarding.form.model.FormConfig;
import com.codeNeeTi.onboarding.form.provider.FormProvider;
import com.codeNeeTi.onboarding.form.service.FormService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FormServiceImpl implements FormService {

  private final List<FormProvider> formProviders;

  public FormServiceImpl(List<FormProvider> formProviders) {
    this.formProviders = formProviders;
  }

  @Override
  public FormConfig getFormConfiguration(String entityType) {

    log.info("Fetching form configuration for entity type: {}", entityType);

    return formProviders.stream()
        .filter(provider -> provider.supports(entityType))
        .findFirst()
        .map(FormProvider::getFormConfiguration)
        .orElseThrow(
            () ->
                new IllegalArgumentException(
                    String.format("No form configuration found for entity type: %s", entityType)));
  }
}
