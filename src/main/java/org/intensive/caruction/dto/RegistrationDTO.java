package org.intensive.caruction.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RegistrationDTO {

    @NotBlank
    @Size(min = 2, max = 128)
    private String name;

    @Email
    @NotEmpty
    @Size(max = 128)
    private String email;

    @NotBlank
    @Size(min = 4, max = 128)
    private String password;

}
