package com.codeNeeTi.onboarding.form.provider;

import com.codeNeeTi.onboarding.form.model.FieldType;
import com.codeNeeTi.onboarding.form.model.FormConfig;
import com.codeNeeTi.onboarding.form.model.FormField;
import com.codeNeeTi.onboarding.form.model.Option;
import com.codeNeeTi.onboarding.form.model.Validation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeacherFormProvider implements FormProvider {

    @Override
    public boolean supports(String entityType) {
        return "teacher".equalsIgnoreCase(entityType);
    }

    @Override
    public FormConfig getFormConfiguration() {

        return FormConfig.builder()
                .formId("teacher-registration")
                .title("Teacher Registration")
                .description("Please fill the details to complete teacher registration.")
                .version(1)
                .active(true)
                .fields(List.of(

                        FormField.builder()
                                .name("firstName")
                                .label("First Name")
                                .placeholder("Enter First Name")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(1)
                                .validation(
                                        Validation.builder()
                                                .minLength(2)
                                                .maxLength(50)
                                                .build())
                                .build(),

                        FormField.builder()
                                .name("lastName")
                                .label("Last Name")
                                .placeholder("Enter Last Name")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(2)
                                .validation(
                                        Validation.builder()
                                                .minLength(2)
                                                .maxLength(50)
                                                .build())
                                .build(),

                        FormField.builder()
                                .name("email")
                                .label("Email")
                                .placeholder("Enter Email")
                                .type(FieldType.EMAIL)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(3)
                                .validation(
                                        Validation.builder()
                                                .regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
                                                .build())
                                .build(),

                        FormField.builder()
                                .name("mobile")
                                .label("Mobile Number")
                                .placeholder("Enter Mobile Number")
                                .type(FieldType.PHONE)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(4)
                                .validation(
                                        Validation.builder()
                                                .regex("^[6-9]\\d{9}$")
                                                .build())
                                .build(),

                        FormField.builder()
                                .name("employeeId")
                                .label("Employee ID")
                                .placeholder("Enter Employee ID")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(5)
                                .build(),

                        FormField.builder()
                                .name("department")
                                .label("Department")
                                .placeholder("Select Department")
                                .type(FieldType.DROPDOWN)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(6)
                                .options(List.of(
                                        Option.builder().label("Computer Science").value("CSE").build(),
                                        Option.builder().label("Information Technology").value("IT").build(),
                                        Option.builder().label("Electronics").value("ECE").build(),
                                        Option.builder().label("Mechanical").value("ME").build(),
                                        Option.builder().label("Civil").value("CE").build()
                                ))
                                .build(),

                        FormField.builder()
                                .name("designation")
                                .label("Designation")
                                .placeholder("Select Designation")
                                .type(FieldType.DROPDOWN)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(7)
                                .options(List.of(
                                        Option.builder().label("Assistant Professor").value("ASSISTANT_PROFESSOR").build(),
                                        Option.builder().label("Associate Professor").value("ASSOCIATE_PROFESSOR").build(),
                                        Option.builder().label("Professor").value("PROFESSOR").build(),
                                        Option.builder().label("HOD").value("HOD").build()
                                ))
                                .build(),

                        FormField.builder()
                                .name("experience")
                                .label("Experience (Years)")
                                .placeholder("Enter Experience")
                                .type(FieldType.NUMBER)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(8)
                                .validation(
                                        Validation.builder()
                                                .minValue(0)
                                                .maxValue(50)
                                                .build())
                                .build(),

                        FormField.builder()
                                .name("highestQualification")
                                .label("Highest Qualification")
                                .placeholder("Select Qualification")
                                .type(FieldType.DROPDOWN)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(9)
                                .options(List.of(
                                        Option.builder().label("B.Tech").value("BTECH").build(),
                                        Option.builder().label("M.Tech").value("MTECH").build(),
                                        Option.builder().label("PhD").value("PHD").build()
                                ))
                                .build(),

                        FormField.builder()
                                .name("joiningDate")
                                .label("Joining Date")
                                .placeholder("Select Joining Date")
                                .type(FieldType.DATE)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(10)
                                .build()

                ))
                .build();
    }
}