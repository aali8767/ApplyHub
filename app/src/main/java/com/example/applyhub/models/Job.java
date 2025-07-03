package com.example.applyhub.models;

import java.util.List;

public class Job {
    private int id;
    private String title;
    private String employment_type;
    private String employee_no;
    private int work_field_id;
    private String work_place;
    private Country country_of_employment;
    private String salary;
    private int salary_show;
    private int work_experience;
    private String job_valid_unite;
    private String summary;
    private Country nationality_prefrence;
    private Country country_of_residence;
    private String gender_perfrence;
    private int request_vedio;
    private String question;
    private int status;
    private int business_man_id;
    private int currency_id;
    private int pay_status;
    private int education_level_id;
    private int education_feild_id;
    private int certification_id;
    private String file_description;
    private String country_of_graduation;
    private String create_time;
    private int expire_date;
    private int applicants;
    private List<Object> invited;
    private int watches_count;
    private boolean is_favorite;
    private boolean is_applied;
    private List<Watch> watches;
    private Education education_level;
    private Education education_feild;
    private Certification certification;
    private ExperienceYear experience_year;
    private BusinessMan business_man;
    private Currency currency;
    private List<Skill> skills;
    private WorkField work_field;

    public Job(int id, String title, String employment_type, String employee_no, int work_field_id, String work_place, Country country_of_employment, String salary, int salary_show, int work_experience, String job_valid_unite, String summary, Country nationality_prefrence, Country country_of_residence, String gender_perfrence, int request_vedio, String question, int status, int business_man_id, int currency_id, int pay_status, int education_level_id, int education_feild_id, int certification_id, String file_description, String country_of_graduation, String create_time, int expire_date, int applicants, List<Object> invited, int watches_count, boolean is_favorite, boolean is_applied, List<Watch> watches, Education education_level, Education education_feild, Certification certification, ExperienceYear experience_year, BusinessMan business_man, Currency currency, List<Skill> skills, WorkField work_field) {
        this.id = id;
        this.title = title;
        this.employment_type = employment_type;
        this.employee_no = employee_no;
        this.work_field_id = work_field_id;
        this.work_place = work_place;
        this.country_of_employment = country_of_employment;
        this.salary = salary;
        this.salary_show = salary_show;
        this.work_experience = work_experience;
        this.job_valid_unite = job_valid_unite;
        this.summary = summary;
        this.nationality_prefrence = nationality_prefrence;
        this.country_of_residence = country_of_residence;
        this.gender_perfrence = gender_perfrence;
        this.request_vedio = request_vedio;
        this.question = question;
        this.status = status;
        this.business_man_id = business_man_id;
        this.currency_id = currency_id;
        this.pay_status = pay_status;
        this.education_level_id = education_level_id;
        this.education_feild_id = education_feild_id;
        this.certification_id = certification_id;
        this.file_description = file_description;
        this.country_of_graduation = country_of_graduation;
        this.create_time = create_time;
        this.expire_date = expire_date;
        this.applicants = applicants;
        this.invited = invited;
        this.watches_count = watches_count;
        this.is_favorite = is_favorite;
        this.is_applied = is_applied;
        this.watches = watches;
        this.education_level = education_level;
        this.education_feild = education_feild;
        this.certification = certification;
        this.experience_year = experience_year;
        this.business_man = business_man;
        this.currency = currency;
        this.skills = skills;
        this.work_field = work_field;
    }

    public String getEmployee_no() {
        return employee_no;
    }

    public void setEmployee_no(String employee_no) {
        this.employee_no = employee_no;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmployment_type() {
        return employment_type;
    }

    public void setEmployment_type(String employment_type) {
        this.employment_type = employment_type;
    }

    public int getWork_field_id() {
        return work_field_id;
    }

    public void setWork_field_id(int work_field_id) {
        this.work_field_id = work_field_id;
    }

    public String getWork_place() {
        return work_place;
    }

    public void setWork_place(String work_place) {
        this.work_place = work_place;
    }

    public Country getCountry_of_employment() {
        return country_of_employment;
    }

    public void setCountry_of_employment(Country country_of_employment) {
        this.country_of_employment = country_of_employment;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getSalary_show() {
        return salary_show;
    }

    public void setSalary_show(int salary_show) {
        this.salary_show = salary_show;
    }

    public int getWork_experience() {
        return work_experience;
    }

    public void setWork_experience(int work_experience) {
        this.work_experience = work_experience;
    }

    public String getJob_valid_unite() {
        return job_valid_unite;
    }

    public void setJob_valid_unite(String job_valid_unite) {
        this.job_valid_unite = job_valid_unite;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Country getNationality_prefrence() {
        return nationality_prefrence;
    }

    public void setNationality_prefrence(Country nationality_prefrence) {
        this.nationality_prefrence = nationality_prefrence;
    }

    public Country getCountry_of_residence() {
        return country_of_residence;
    }

    public void setCountry_of_residence(Country country_of_residence) {
        this.country_of_residence = country_of_residence;
    }

    public String getGender_perfrence() {
        return gender_perfrence;
    }

    public void setGender_perfrence(String gender_perfrence) {
        this.gender_perfrence = gender_perfrence;
    }

    public int getRequest_vedio() {
        return request_vedio;
    }

    public void setRequest_vedio(int request_vedio) {
        this.request_vedio = request_vedio;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBusiness_man_id() {
        return business_man_id;
    }

    public void setBusiness_man_id(int business_man_id) {
        this.business_man_id = business_man_id;
    }

    public int getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(int currency_id) {
        this.currency_id = currency_id;
    }

    public int getPay_status() {
        return pay_status;
    }

    public void setPay_status(int pay_status) {
        this.pay_status = pay_status;
    }

    public int getEducation_level_id() {
        return education_level_id;
    }

    public void setEducation_level_id(int education_level_id) {
        this.education_level_id = education_level_id;
    }

    public int getEducation_feild_id() {
        return education_feild_id;
    }

    public void setEducation_feild_id(int education_feild_id) {
        this.education_feild_id = education_feild_id;
    }

    public int getCertification_id() {
        return certification_id;
    }

    public void setCertification_id(int certification_id) {
        this.certification_id = certification_id;
    }

    public String getFile_description() {
        return file_description;
    }

    public void setFile_description(String file_description) {
        this.file_description = file_description;
    }

    public String getCountry_of_graduation() {
        return country_of_graduation;
    }

    public void setCountry_of_graduation(String country_of_graduation) {
        this.country_of_graduation = country_of_graduation;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(int expire_date) {
        this.expire_date = expire_date;
    }

    public int getApplicants() {
        return applicants;
    }

    public void setApplicants(int applicants) {
        this.applicants = applicants;
    }

    public List<Object> getInvited() {
        return invited;
    }

    public void setInvited(List<Object> invited) {
        this.invited = invited;
    }

    public int getWatches_count() {
        return watches_count;
    }

    public void setWatches_count(int watches_count) {
        this.watches_count = watches_count;
    }

    public boolean isIs_favorite() {
        return is_favorite;
    }

    public void setIs_favorite(boolean is_favorite) {
        this.is_favorite = is_favorite;
    }

    public boolean isIs_applied() {
        return is_applied;
    }

    public void setIs_applied(boolean is_applied) {
        this.is_applied = is_applied;
    }

    public List<Watch> getWatches() {
        return watches;
    }

    public void setWatches(List<Watch> watches) {
        this.watches = watches;
    }

    public Education getEducation_level() {
        return education_level;
    }

    public void setEducation_level(Education education_level) {
        this.education_level = education_level;
    }

    public Education getEducation_feild() {
        return education_feild;
    }

    public void setEducation_feild(Education education_feild) {
        this.education_feild = education_feild;
    }

    public Certification getCertification() {
        return certification;
    }

    public void setCertification(Certification certification) {
        this.certification = certification;
    }

    public ExperienceYear getExperience_year() {
        return experience_year;
    }

    public void setExperience_year(ExperienceYear experience_year) {
        this.experience_year = experience_year;
    }

    public BusinessMan getBusiness_man() {
        return business_man;
    }

    public void setBusiness_man(BusinessMan business_man) {
        this.business_man = business_man;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public WorkField getWork_field() {
        return work_field;
    }

    public void setWork_field(WorkField work_field) {
        this.work_field = work_field;
    }
}
