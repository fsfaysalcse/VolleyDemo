package com.example.volleyrecycler;

public class PostModel {
    int id;
    String name, email, mobile_number, father_name, mother_name, blood_group, nationality, orga, present_address, member_type, designation;


    public PostModel(int id, String name, String email, String mobile_number, String father_name, String mother_name, String blood_group, String nationality, String orga, String present_address, String member_type, String designation) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile_number = mobile_number;
        this.father_name = father_name;
        this.mother_name = mother_name;
        this.blood_group = blood_group;
        this.nationality = nationality;
        this.orga = orga;
        this.present_address = present_address;
        this.member_type = member_type;
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getOrga() {
        return orga;
    }

    public void setOrga(String orga) {
        this.orga = orga;
    }

    public String getPresent_address() {
        return present_address;
    }

    public void setPresent_address(String present_address) {
        this.present_address = present_address;
    }

    public String getMember_type() {
        return member_type;
    }

    public void setMember_type(String member_type) {
        this.member_type = member_type;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
