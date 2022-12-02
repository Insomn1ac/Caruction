package org.intensive.caruction.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
public class LoginRequest {

    @NotBlank
    @Size(min = 2, max = 128)
    private String name;

    @NotBlank
    @Size(min = 4, max = 128)
    private String password;
}
