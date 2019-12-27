package per.liam.stumanager.controller;

import javafx.scene.control.TextField;
import per.liam.stumanager.model.Change;
import per.liam.stumanager.model.MainFrameInit;
import per.liam.stumanager.model.Search;
import per.liam.stumanager.utils.AlertDialog;
import per.liam.stumanager.utils.SearchCondition;
import per.liam.stumanager.utils.Student;

/**
 * @author liam
 * @date 19-12-19 下午1:06
 */
public class ChangeC {
    public TextField sno;
    public TextField name;
    public TextField sex;
    public TextField tel;
    public TextField birthday;
    public TextField address;
    public TextField institute;
    public TextField major;
    public TextField startYear;
    public TextField snoSearch;

    public void onClickSearch() {
        SearchCondition searchCondition = new SearchCondition(snoSearch.getText(),"",null,null,null,null);
        Search search = new Search(searchCondition);
        Student stu = search.check();
        sno.setText(stu.getSno());
        name.setText(stu.getName());
        sex.setText(stu.getSex());
        tel.setText(stu.getTel());
        birthday.setText(stu.getBirthday());
        address.setText(stu.getAddress());
        institute.setText(stu.getInstitute());
        major.setText(stu.getMajor());
        startYear.setText(stu.getStartYear());
    }

    public void onClickChange() {
        Student student = new Student(sno.getText(), name.getText(), sex.getText(), tel.getText(), birthday.getText(), address.getText(),
                MainFrameInit.instituteR.get(institute.getText()), MainFrameInit.majorR.get(major.getText()), startYear.getText());
        Change change = new Change();
        if (change.changeStuInfo(student) == 1){
            new AlertDialog().correctInformationDialog("修改成功！");
        }else {
            new AlertDialog().errorInformationDialog("修改失败！");
        }
    }
}
