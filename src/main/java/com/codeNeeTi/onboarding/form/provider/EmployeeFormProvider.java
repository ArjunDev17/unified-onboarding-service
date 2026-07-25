package com.codeNeeTi.onboarding.form.provider;

import com.codeNeeTi.onboarding.form.model.FieldType;
import com.codeNeeTi.onboarding.form.model.FormConfig;
import com.codeNeeTi.onboarding.form.model.FormField;
import com.codeNeeTi.onboarding.form.model.Option;
import com.codeNeeTi.onboarding.form.model.Validation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeFormProvider implements FormProvider {

    @Override
    public boolean supports(String entityType) {
        return "employee".equalsIgnoreCase(entityType);
    }

    @Override
    public FormConfig getFormConfiguration() {

        return FormConfig.builder()
                .formId("employee-onboarding")
                .title("Employee Onboarding")
                .description("Complete the employee onboarding process.")
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
                                .label("Official Email")
                                .placeholder("Enter Official Email")
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
                                        Option.builder().label("Engineering").value("ENGINEERING").build(),
                                        Option.builder().label("Finance").value("FINANCE").build(),
                                        Option.builder().label("Human Resources").value("HR").build(),
                                        Option.builder().label("Sales").value("SALES").build(),
                                        Option.builder().label("Marketing").value("MARKETING").build(),
                                        Option.builder().label("Operations").value("OPERATIONS").build()
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
                                        Option.builder().label("Software Engineer").value("SOFTWARE_ENGINEER").build(),
                                        Option.builder().label("Senior Software Engineer").value("SENIOR_SOFTWARE_ENGINEER").build(),
                                        Option.builder().label("Lead Engineer").value("LEAD_ENGINEER").build(),
                                        Option.builder().label("Manager").value("MANAGER").build(),
                                        Option.builder().label("Director").value("DIRECTOR").build()
                                ))
                                .build(),

                        FormField.builder()
                                .name("manager")
                                .label("Reporting Manager")
                                .placeholder("Enter Reporting Manager")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(8)
                                .build(),

                        FormField.builder()
                                .name("joiningDate")
                                .label("Joining Date")
                                .placeholder("Select Joining Date")
                                .type(FieldType.DATE)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(9)
                                .build(),

                        FormField.builder()
                                .name("employmentType")
                                .label("Employment Type")
                                .placeholder("Select Employment Type")
                                .type(FieldType.DROPDOWN)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(10)
                                .options(List.of(
                                        Option.builder().label("Full Time").value("FULL_TIME").build(),
                                        Option.builder().label("Part Time").value("PART_TIME").build(),
                                        Option.builder().label("Contract").value("CONTRACT").build(),
                                        Option.builder().label("Intern").value("INTERN").build()
                                ))
                                .build(),

                        FormField.builder()
                                .name("workLocation")
                                .label("Work Location")
                                .placeholder("Enter Work Location")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(11)
                                .build(),

                        FormField.builder()
                                .name("salaryBand")
                                .label("Salary Band")
                                .placeholder("Select Salary Band")
                                .type(FieldType.DROPDOWN)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(12)
                                .options(List.of(
                                        Option.builder().label("Band A").value("A").build(),
                                        Option.builder().label("Band B").value("B").build(),
                                        Option.builder().label("Band C").value("C").build(),
                                        Option.builder().label("Band D").value("D").build()
                                ))
                                .build(),

                        FormField.builder()
                                .name("panNumber")
                                .label("PAN Number")
                                .placeholder("Enter PAN Number")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(13)
                                .validation(
                                        Validation.builder()
                                                .regex("^[A-Z]{5}[0-9]{4}[A-Z]{1}$")
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
                                .order(14)
                                .validation(
                                        Validation.builder()
                                                .regex("^\\d{12}$")
                                                .build())
                                .build(),

                        FormField.builder()
                                .name("bankAccountNumber")
                                .label("Bank Account Number")
                                .placeholder("Enter Bank Account Number")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(15)
                                .build(),

                        FormField.builder()
                                .name("ifscCode")
                                .label("IFSC Code")
                                .placeholder("Enter IFSC Code")
                                .type(FieldType.TEXT)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(16)
                                .validation(
                                        Validation.builder()
                                                .regex("^[A-Z]{4}0[A-Z0-9]{6}$")
                                                .build())
                                .build(),

                        FormField.builder()
                                .name("emergencyContact")
                                .label("Emergency Contact Number")
                                .placeholder("Enter Emergency Contact")
                                .type(FieldType.PHONE)
                                .required(true)
                                .visible(true)
                                .readOnly(false)
                                .order(17)
                                .validation(
                                        Validation.builder()
                                                .regex("^[6-9]\\d{9}$")
                                                .build())
                                .build()

                ))
                .build();
    }
}