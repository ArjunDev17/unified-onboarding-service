package com.codeNeeTi.onboarding.form.provider;

import com.codeNeeTi.onboarding.form.model.FieldType;
import com.codeNeeTi.onboarding.form.model.FormConfig;
import com.codeNeeTi.onboarding.form.model.FormField;
import com.codeNeeTi.onboarding.form.model.Option;
import com.codeNeeTi.onboarding.form.model.Validation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CitizenRegistrationFormProvider implements FormProvider {

    @Override
    public boolean supports(String entityType) {
        return "citizen".equalsIgnoreCase(entityType);
    }

    @Override
    public FormConfig getFormConfiguration() {

        return FormConfig.builder()
                .formId("citizen-registration")
                .title("Citizen Registration")
                .description("Register a citizen into the Unified Citizen Registry.")
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
                                .validation(Validation.builder()
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
                                .validation(Validation.builder()
                                        .minLength(2)
                                        .maxLength(50)
                                        .build())
                                .build(),

                        FormField.builder()
                                .name("dateOfBirth")
                                .label("Date Of Birth")
                                .placeholder("Select DOB")
                                .type(FieldType.DATE)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(3)
                                .build(),

                        FormField.builder()
                                .name("gender")
                                .label("Gender")
                                .placeholder("Select Gender")
                                .type(FieldType.DROPDOWN)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(4)
                                .options(List.of(
                                        Option.builder().label("Male").value("MALE").build(),
                                        Option.builder().label("Female").value("FEMALE").build(),
                                        Option.builder().label("Other").value("OTHER").build()
                                ))
                                .build(),

                        FormField.builder()
                                .name("maritalStatus")
                                .label("Marital Status")
                                .placeholder("Select Marital Status")
                                .type(FieldType.DROPDOWN)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(5)
                                .options(List.of(
                                        Option.builder().label("Single").value("SINGLE").build(),
                                        Option.builder().label("Married").value("MARRIED").build(),
                                        Option.builder().label("Divorced").value("DIVORCED").build(),
                                        Option.builder().label("Widowed").value("WIDOWED").build()
                                ))
                                .build(),

                        FormField.builder()
                                .name("mobile")
                                .label("Mobile Number")
                                .placeholder("Enter Mobile Number")
                                .type(FieldType.PHONE)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(6)
                                .validation(Validation.builder()
                                        .regex("^[6-9]\\d{9}$")
                                        .build())
                                .build(),

                        FormField.builder()
                                .name("email")
                                .label("Email")
                                .placeholder("Enter Email")
                                .type(FieldType.EMAIL)
                                .required(false)
                                .visible(true)
                                .readOnly(false)
                                .order(7)
                                .validation(Validation.builder()
                                        .regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
                                        .build())
                                .build(),

                        FormField.builder()
                                .name("occupation")
                                .label("Occupation")
                                .placeholder("Enter Occupation")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(8)
                                .build(),

                        FormField.builder()
                                .name("bloodGroup")
                                .label("Blood Group")
                                .placeholder("Select Blood Group")
                                .type(FieldType.DROPDOWN)
                                .required(false)
                                .visible(true)
                                .readOnly(false)
                                .order(9)
                                .options(List.of(
                                        Option.builder().label("A+").value("A+").build(),
                                        Option.builder().label("A-").value("A-").build(),
                                        Option.builder().label("B+").value("B+").build(),
                                        Option.builder().label("B-").value("B-").build(),
                                        Option.builder().label("AB+").value("AB+").build(),
                                        Option.builder().label("AB-").value("AB-").build(),
                                        Option.builder().label("O+").value("O+").build(),
                                        Option.builder().label("O-").value("O-").build()
                                ))
                                .build(),

                        FormField.builder()
                                .name("aadhaarNumber")
                                .label("Aadhaar Number")
                                .placeholder("Enter Aadhaar Number")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(10)
                                .validation(Validation.builder()
                                        .regex("^\\d{12}$")
                                        .build())
                                .build(),

                        FormField.builder()
                                .name("panNumber")
                                .label("PAN Number")
                                .placeholder("Enter PAN Number")
                                .type(FieldType.TEXT)
                                .required(false)
                                .visible(true)
                                .readOnly(false)
                                .order(11)
                                .validation(Validation.builder()
                                        .regex("^[A-Z]{5}[0-9]{4}[A-Z]$")
                                        .build())
                                .build(),

                        FormField.builder()
                                .name("passportNumber")
                                .label("Passport Number")
                                .placeholder("Enter Passport Number")
                                .type(FieldType.TEXT)
                                .required(false)
                                .visible(true)
                                .readOnly(false)
                                .order(12)
                                .build(),

                        FormField.builder()
                                .name("address")
                                .label("Current Address")
                                .placeholder("Enter Current Address")
                                .type(FieldType.TEXTAREA)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(13)
                                .build(),

                        FormField.builder()
                                .name("city")
                                .label("City")
                                .placeholder("Enter City")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(14)
                                .build(),

                        FormField.builder()
                                .name("district")
                                .label("District")
                                .placeholder("Enter District")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(15)
                                .build(),

                        FormField.builder()
                                .name("state")
                                .label("State")
                                .placeholder("Select State")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(16)
                                .build(),

                        FormField.builder()
                                .name("country")
                                .label("Country")
                                .placeholder("Enter Country")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(17)
                                .build(),

                        FormField.builder()
                                .name("pincode")
                                .label("PIN Code")
                                .placeholder("Enter PIN Code")
                                .type(FieldType.NUMBER)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(18)
                                .validation(Validation.builder()
                                        .regex("^\\d{6}$")
                                        .build())
                                .build(),

                        FormField.builder()
                                .name("emergencyContact")
                                .label("Emergency Contact Number")
                                .placeholder("Enter Emergency Contact")
                                .type(FieldType.PHONE)
                                .required(false)
                                .visible(true)
                                .readOnly(false)
                                .order(19)
                                .validation(Validation.builder()
                                        .regex("^[6-9]\\d{9}$")
                                        .build())
                                .build(),

                        FormField.builder()
                                .name("photo")
                                .label("Citizen Photograph")
                                .placeholder("Upload Photograph")
                                .type(FieldType.IMAGE)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(20)
                                .build()

                ))
                .build();
    }
}