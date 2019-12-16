package com.maxi.crud.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@ApiModel(description = "Details about the person")
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "per_id")
    private Long id;

    @ApiModelProperty(notes = "Name of the person")
    @NotBlank
    @Column(name = "name")
    private String name;

    @ApiModelProperty(notes = "Last name of the person")
    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @ApiModelProperty(notes = "Address of the person")
    @NotBlank
    @Column(name = "address")
    private String address;

    @ApiModelProperty(notes = "Phone number of the person")
    @NotBlank
    @Column(name = "phone")
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
