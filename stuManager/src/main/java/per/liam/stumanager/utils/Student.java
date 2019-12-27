package per.liam.stumanager.utils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 学生实体
 * @author liam
 * @date 19-12-18 下午5:49
 */
public class Student {
    private StringProperty sno;
    private StringProperty name;
    private StringProperty sex;
    private StringProperty tel;
    private StringProperty birthday;
    private StringProperty address;
    private StringProperty institute;
    private StringProperty major;
    private StringProperty startYear;

    public Student(String sno, String name, String sex, String tel, String birthday, String address,
                   String institute, String major, String startYear){
        this.sno = new SimpleStringProperty(sno);
        this.name = new SimpleStringProperty(name);
        this.sex = new SimpleStringProperty(sex);
        this.tel = new SimpleStringProperty(tel);
        this.birthday = new SimpleStringProperty(birthday);
        this.address = new SimpleStringProperty(address);
        this.institute = new SimpleStringProperty(institute);
        this.major = new SimpleStringProperty(major);
        this.startYear = new SimpleStringProperty(startYear);
    }

    public String getSno() {
        return sno.get();
    }

    public void setSno(String sno) {
        this.sno.set(sno);
    }

    public StringProperty snoProperty(){
        return sno;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty(){
        return name;
    }

    public String getSex() {
        return sex.get();
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }

    public StringProperty sexProperty(){
        return sex;
    }

    public String getTel() {
        return tel.get();
    }

    public void setTel(String tel) {
        this.tel.set(tel);
    }

    public StringProperty telProperty(){
        return tel;
    }

    public String getBirthday() {
        return birthday.get();
    }

    public void setBirthday(String birthday) {
        this.birthday.set(birthday);
    }

    public StringProperty birthdayProperty(){
        return birthday;
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public StringProperty addressProperty(){
        return address;
    }

    public String getInstitute() {
        return institute.get();
    }

    public void setInstitute(String institute) {
        this.institute.set(institute);
    }

    public StringProperty instituteProperty(){
        return institute;
    }

    public String getMajor() {
        return major.get();
    }

    public void setMajor(String major) {
        this.major.set(major);
    }

    public StringProperty majorProperty(){
        return major;
    }

    public String getStartYear() {
        return startYear.get();
    }

    public void setStartYear(String startYear) {
        this.startYear.set(startYear);
    }

    public StringProperty startYearProperty(){
        return startYear;
    }
}
