package com.pyramidbuildersemployment.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleDTO {
    private Long id;
    private String name;

    public RoleDTO(Long id, String roleName) {
        this.id = id;
        this.name = roleName;
    }

    public String getRoleName() {
        return name;
    }


}
