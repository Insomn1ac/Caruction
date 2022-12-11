package org.intensive.caruction.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class UserDTO {

    private int id;

    @NotBlank
    @Size(min = 2, max = 128)
    private String name;

    @NotBlank
    @Size(min = 4, max = 128)
    @JsonIgnore
    private String password;

    @Email
    @NotEmpty
    @Size(max = 128)
    private String email;
}
