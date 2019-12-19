package per.liam.stumanager.utils;

import javafx.beans.property.StringProperty;

/**
 * @author liam
 * @date 19-12-18 下午8:13
 */
public class SearchCondition {
    private String snoCondition;
    private String nameCondition;
    private String sexCondition;
    private String instituteCondition;
    private String majorCondition;
    private String yearCondition;

    public SearchCondition(String snoCondition, String nameCondition, String sexCondition, String instituteCondition,
                           String majorCondition, String yearCondition){
        if ("".equals(snoCondition)){
            this.snoCondition = "%";
        }else {
            this.snoCondition = snoCondition;
        }
        if ("".equals(nameCondition)){
            this.nameCondition = "%";
        }else {
            this.nameCondition = nameCondition;
        }
        if (sexCondition == null){
            this.sexCondition = "%";
        }else {
            this.sexCondition = sexCondition;
        }
        if (instituteCondition == null){
            this.instituteCondition = "%";
        }else {
            this.instituteCondition = instituteCondition;
        }
        if (majorCondition == null){
            this.majorCondition = "%";
        }else {
            this.majorCondition = majorCondition;
        }
        if (yearCondition == null){
            this.yearCondition = "%";
        }else {
            this.yearCondition = yearCondition;
        }
    }

    public String getSnoCondition() {
        return snoCondition;
    }

    public void setSnoCondition(String snoCondition) {
        this.snoCondition = snoCondition;
    }

    public String getNameCondition() {
        return nameCondition;
    }

    public void setNameCondition(String nameCondition) {
        this.nameCondition = nameCondition;
    }

    public String getSexCondition() {
        return sexCondition;
    }

    public void setSexCondition(String sexCondition) {
        this.sexCondition = sexCondition;
    }

    public String getInstituteCondition() {
        return instituteCondition;
    }

    public void setInstituteCondition(String instituteCondition) {
        this.instituteCondition = instituteCondition;
    }

    public String getMajorCondition() {
        return majorCondition;
    }

    public void setMajorCondition(String majorCondition) {
        this.majorCondition = majorCondition;
    }

    public String getYearCondition() {
        return yearCondition;
    }

    public void setYearCondition(String yearCondition) {
        this.yearCondition = yearCondition;
    }
}
