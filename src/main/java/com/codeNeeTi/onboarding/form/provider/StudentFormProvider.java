package com.codeNeeTi.onboarding.form.provider;

import com.codeNeeTi.onboarding.form.model.FieldType;
import com.codeNeeTi.onboarding.form.model.FormConfig;
import com.codeNeeTi.onboarding.form.model.FormField;
import com.codeNeeTi.onboarding.form.model.Option;
import com.codeNeeTi.onboarding.form.model.Validation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentFormProvider implements FormProvider {

    @Override
    public boolean supports(String entityType) {
        return "student".equalsIgnoreCase(entityType);
    }

    @Override
    public FormConfig getFormConfiguration() {

        return FormConfig.builder()
                .formId("student-registration")
                .title("Student Registration")
                .description("Please fill the below details to complete student registration.")
                .fields(List.of(

                        FormField.builder()
                                .name("firstName")
                                .label("First Name")
                                .placeholder("Enter First Name")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .validation(
                                        Validation.builder()
                                                .minLength(2)
                                                .maxLength(50)
                                                .build()
                                )
                                .build(),

                        FormField.builder()
                                .name("lastName")
                                .label("Last Name")
                                .placeholder("Enter Last Name")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .validation(
                                        Validation.builder()
                                                .minLength(2)
                                                .maxLength(50)
                                                .build()
                                )
                                .build(),

                        FormField.builder()
                                .name("email")
                                .label("Email")
                                .placeholder("Enter Email")
                                .type(FieldType.EMAIL)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .validation(
                                        Validation.builder()
                                                .regex("^[A-Za-z0-9+_.-]+@(.+)$")
                                                .build()
                                )
                                .build(),

                        FormField.builder()
                                .name("mobile")
                                .label("Mobile Number")
                                .placeholder("Enter Mobile Number")
                                .type(FieldType.MOBILE)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .validation(
                                        Validation.builder()
                                                .regex("^[6-9][0-9]{9}$")
                                                .build()
                                )
                                .build(),

                        FormField.builder()
                                .name("dateOfBirth")
                                .label("Date Of Birth")
                                .placeholder("Select Date Of Birth")
                                .type(FieldType.DATE)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .build(),

                        FormField.builder()
                                .name("gender")
                                .label("Gender")
                                .type(FieldType.DROPDOWN)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .options(List.of(
                                        new Option("MALE", "Male"),
                                        new Option("FEMALE", "Female"),
                                        new Option("OTHER", "Other")
                                ))
                                .build(),

                        FormField.builder()
                                .name("course")
                                .label("Course")
                                .type(FieldType.DROPDOWN)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .options(List.of(
                                        new Option("BCA", "BCA"),
                                        new Option("BTECH", "B.Tech"),
                                        new Option("MCA", "MCA"),
                                        new Option("MBA", "MBA")
                                ))
                                .build(),

                        FormField.builder()
                                .name("semester")
                                .label("Semester")
                                .type(FieldType.DROPDOWN)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .options(List.of(
                                        new Option("1", "Semester 1"),
                                        new Option("2", "Semester 2"),
                                        new Option("3", "Semester 3"),
                                        new Option("4", "Semester 4"),
                                        new Option("5", "Semester 5"),
                                        new Option("6", "Semester 6"),
                                        new Option("7", "Semester 7"),
                                        new Option("8", "Semester 8")
                                ))
                                .build()

                ))
                .build();
    }
}