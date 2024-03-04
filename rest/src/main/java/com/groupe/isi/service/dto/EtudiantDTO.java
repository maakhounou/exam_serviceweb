package com.groupe.isi.service.dto;

public class EtudiantDTO {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String phone;

    public EtudiantDTO() {
    }

    public EtudiantDTO(Long id, String name, String lastname, String email, String phone) {
        this.id = id;
        this.lastname = lastname;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
