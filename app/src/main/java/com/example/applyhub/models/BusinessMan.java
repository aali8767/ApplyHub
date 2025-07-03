package com.example.applyhub.models;

import java.io.Serializable;

public class BusinessMan implements Serializable {
    private int id;
    private String business_name;
    private String email;
    private String phone;
    private String intro_phone;
    private String telephone;
    private String intro_telephone;
    private String employee_no;
    private int role_id;
    private int type_business;
    private String created_at;
    private String updated_at;
    private int active_status;
    private int complete_status;
    private String website;
    private int contact_privacy;
    private String bio;
    private int is_from_socialite;
    private int active_socialite;
    private String image_url;
    private String cover_url;
    private String experience_years;
    private int number_experience_years;

    public BusinessMan(int id, String business_name, String email, String phone, String intro_phone, String telephone, String intro_telephone, String employee_no, int role_id, int type_business, String created_at, String updated_at, int active_status, int complete_status, String website, int contact_privacy, String bio, int is_from_socialite, int active_socialite, String image_url, String cover_url, String experience_years, int number_experience_years) {
        this.id = id;
        this.business_name = business_name;
        this.email = email;
        this.phone = phone;
        this.intro_phone = intro_phone;
        this.telephone = telephone;
        this.intro_telephone = intro_telephone;
        this.employee_no = employee_no;
        this.role_id = role_id;
        this.type_business = type_business;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.active_status = active_status;
        this.complete_status = complete_status;
        this.website = website;
        this.contact_privacy = contact_privacy;
        this.bio = bio;
        this.is_from_socialite = is_from_socialite;
        this.active_socialite = active_socialite;
        this.image_url = image_url;
        this.cover_url = cover_url;
        this.experience_years = experience_years;
        this.number_experience_years = number_experience_years;
    }

    public String getEmployee_no() {
        return employee_no;
    }

    public void setEmployee_no(String employee_no) {
        this.employee_no = employee_no;
    }

    public int getType_business() {
        return type_business;
    }

    public void setType_business(int type_business) {
        this.type_business = type_business;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
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

    public String getIntro_phone() {
        return intro_phone;
    }

    public void setIntro_phone(String intro_phone) {
        this.intro_phone = intro_phone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIntro_telephone() {
        return intro_telephone;
    }

    public void setIntro_telephone(String intro_telephone) {
        this.intro_telephone = intro_telephone;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getActive_status() {
        return active_status;
    }

    public void setActive_status(int active_status) {
        this.active_status = active_status;
    }

    public int getComplete_status() {
        return complete_status;
    }

    public void setComplete_status(int complete_status) {
        this.complete_status = complete_status;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getContact_privacy() {
        return contact_privacy;
    }

    public void setContact_privacy(int contact_privacy) {
        this.contact_privacy = contact_privacy;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getIs_from_socialite() {
        return is_from_socialite;
    }

    public void setIs_from_socialite(int is_from_socialite) {
        this.is_from_socialite = is_from_socialite;
    }

    public int getActive_socialite() {
        return active_socialite;
    }

    public void setActive_socialite(int active_socialite) {
        this.active_socialite = active_socialite;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getCover_url() {
        return cover_url;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }

    public String getExperience_years() {
        return experience_years;
    }

    public void setExperience_years(String experience_years) {
        this.experience_years = experience_years;
    }

    public int getNumber_experience_years() {
        return number_experience_years;
    }

    public void setNumber_experience_years(int number_experience_years) {
        this.number_experience_years = number_experience_years;
    }

    @Override
    public String toString() {
        return "BusinessMan{" +
                "id=" + id +
                ", business_name='" + business_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", intro_phone='" + intro_phone + '\'' +
                ", telephone='" + telephone + '\'' +
                ", intro_telephone='" + intro_telephone + '\'' +
                ", role_id=" + role_id +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", active_status=" + active_status +
                ", complete_status=" + complete_status +
                ", website='" + website + '\'' +
                ", contact_privacy=" + contact_privacy +
                ", bio='" + bio + '\'' +
                ", is_from_socialite=" + is_from_socialite +
                ", active_socialite=" + active_socialite +
                ", image_url='" + image_url + '\'' +
                ", cover_url='" + cover_url + '\'' +
                ", experience_years='" + experience_years + '\'' +
                ", number_experience_years=" + number_experience_years +
                '}';
    }
}
