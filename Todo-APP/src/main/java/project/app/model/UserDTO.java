package project.app.model;

import lombok.Builder;
import lombok.Data;
import project.app.entity.Address;


public class UserDTO {

    private String name;
    private String phone;
    private Address address;


    public UserDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
