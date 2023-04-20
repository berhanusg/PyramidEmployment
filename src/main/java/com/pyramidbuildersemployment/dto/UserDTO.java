package com.pyramidbuildersemployment.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty(message = "Email should not be empty or null")
    @Email
    private String email;

    @NotEmpty(message = "Password should not be empty")
    private String password;

    private Long id;
    private String username;
    //private String password;
    private String rolename;

    public UserDTO(Long id, String email) {
    }


        public UserDTO(Long id, String username, String firstName, String lastName, String email, String role) {
            this.id = id;
            this.username = username;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.rolename = role;
        }

    // private String email;
}
