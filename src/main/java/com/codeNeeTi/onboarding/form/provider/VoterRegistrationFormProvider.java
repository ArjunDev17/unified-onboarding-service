package com.codeNeeTi.onboarding.form.provider;

import com.codeNeeTi.onboarding.form.model.FieldType;
import com.codeNeeTi.onboarding.form.model.FormConfig;
import com.codeNeeTi.onboarding.form.model.FormField;
import com.codeNeeTi.onboarding.form.model.Option;
import com.codeNeeTi.onboarding.form.model.Validation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VoterRegistrationFormProvider implements FormProvider {

    @Override
    public boolean supports(String entityType) {
        return "voter".equalsIgnoreCase(entityType);
    }

    @Override
    public FormConfig getFormConfiguration() {

        return FormConfig.builder()
                .formId("voter-registration")
                .title("Voter Registration")
                .description("Complete the voter registration form.")
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
                                .name("fatherName")
                                .label("Father's Name")
                                .placeholder("Enter Father's Name")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(3)
                                .build(),

                        FormField.builder()
                                .name("motherName")
                                .label("Mother's Name")
                                .placeholder("Enter Mother's Name")
                                .type(FieldType.TEXT)
                                .required(false)
                                .visible(true)
                                .readOnly(false)
                                .order(4)
                                .build(),

                        FormField.builder()
                                .name("dateOfBirth")
                                .label("Date Of Birth")
                                .placeholder("Select DOB")
                                .type(FieldType.DATE)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(5)
                                .build(),

                        FormField.builder()
                                .name("gender")
                                .label("Gender")
                                .placeholder("Select Gender")
                                .type(FieldType.DROPDOWN)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(6)
                                .options(List.of(
                                        Option.builder().label("Male").value("MALE").build(),
                                        Option.builder().label("Female").value("FEMALE").build(),
                                        Option.builder().label("Other").value("OTHER").build()
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
                                .order(7)
                                .validation(Validation.builder()
                                        .regex("^[6-9]\\d{9}$")
                                        .build())
                                .build(),

                        FormField.builder()
                                .name("email")
                                .label("Email Address")
                                .placeholder("Enter Email")
                                .type(FieldType.EMAIL)
                                .required(false)
                                .visible(true)
                                .readOnly(false)
                                .order(8)
                                .validation(Validation.builder()
                                        .regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
                                        .build())
                                .build(),

                        FormField.builder()
                                .name("aadhaarNumber")
                                .label("Aadhaar Number")
                                .placeholder("Enter Aadhaar Number")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(9)
                                .validation(Validation.builder()
                                        .regex("^\\d{12}$")
                                        .build())
                                .build(),

                        FormField.builder()
                                .name("nationality")
                                .label("Nationality")
                                .placeholder("Enter Nationality")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(10)
                                .build(),

                        FormField.builder()
                                .name("state")
                                .label("State")
                                .placeholder("Select State")
                                .type(FieldType.DROPDOWN)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(11)
                                .options(List.of(
                                        Option.builder().label("Karnataka").value("KA").build(),
                                        Option.builder().label("Maharashtra").value("MH").build(),
                                        Option.builder().label("Delhi").value("DL").build(),
                                        Option.builder().label("Tamil Nadu").value("TN").build(),
                                        Option.builder().label("Uttar Pradesh").value("UP").build()
                                ))
                                .build(),

                        FormField.builder()
                                .name("district")
                                .label("District")
                                .placeholder("Enter District")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(12)
                                .build(),

                        FormField.builder()
                                .name("assemblyConstituency")
                                .label("Assembly Constituency")
                                .placeholder("Enter Assembly Constituency")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(13)
                                .build(),

                        FormField.builder()
                                .name("address")
                                .label("Residential Address")
                                .placeholder("Enter Address")
                                .type(FieldType.TEXTAREA)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(14)
                                .build(),

                        FormField.builder()
                                .name("city")
                                .label("City")
                                .placeholder("Enter City")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(15)
                                .build(),

                        FormField.builder()
                                .name("pincode")
                                .label("PIN Code")
                                .placeholder("Enter PIN Code")
                                .type(FieldType.NUMBER)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(16)
                                .validation(Validation.builder()
                                        .regex("^\\d{6}$")
                                        .build())
                                .build(),

                        FormField.builder()
                                .name("epicNumber")
                                .label("EPIC Number (If Available)")
                                .placeholder("Enter EPIC Number")
                                .type(FieldType.TEXT)
                                .required(false)
                                .visible(true)
                                .readOnly(false)
                                .order(17)
                                .build(),

                        FormField.builder()
                                .name("proofOfResidence")
                                .label("Proof Of Residence")
                                .placeholder("Upload Address Proof")
                                .type(FieldType.FILE)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(18)
                                .build(),

                        FormField.builder()
                                .name("photo")
                                .label("Passport Size Photograph")
                                .placeholder("Upload Photo")
                                .type(FieldType.IMAGE)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(19)
                                .build()

                ))
                .build();
    }
}