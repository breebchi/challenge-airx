package com.airxelerate.challenge.datatransferobject;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class UserDTO
{
    @NotBlank
    @NotNull(message = "Username can not be null!")
    @ApiModelProperty(value = "Username of the user.")
    private String username;

    @NotBlank
    @NotNull(message = "Password can not be null!")
    @ApiModelProperty(value = "Password of the user.")
    private String password;

    @ApiModelProperty(value = "Roles of the user.")
    private Set<String> roles;

    @ApiModelProperty(value = "Token allocated to the user.")



    public String getUsername()
    {
        return username;
    }


    public void setUsername(String username)
    {
        this.username = username;
    }


    public String getPassword()
    {
        return password;
    }


    public void setPassword(String password)
    {
        this.password = password;
    }


    public Set<String> getRoles()
    {
        return roles;
    }


    public void setRoles(Set<String> roles)
    {
        this.roles = roles;
    }

}
