package pers.liam.composite;

public class Application {
    public static void main(String[] args) {
        MilitaryPersonOfficer 连长 = new MilitaryPersonOfficer("连长", 5000);
        MilitaryPersonOfficer 排长1 = new MilitaryPersonOfficer("一排长", 4000);
        MilitaryPersonOfficer 排长2 = new MilitaryPersonOfficer("二排长", 4000);
        MilitaryPersonOfficer 班长11 = new MilitaryPersonOfficer("一班长", 2000);
        MilitaryPersonOfficer 班长12 = new MilitaryPersonOfficer("二班长", 2000);
        MilitaryPersonOfficer 班长13 = new MilitaryPersonOfficer("三班长", 2000);
        MilitaryPersonOfficer 班长21 = new MilitaryPersonOfficer("一班长", 2000);
        MilitaryPersonOfficer 班长22 = new MilitaryPersonOfficer("二班长", 2000);
        MilitaryPersonOfficer 班长23 = new MilitaryPersonOfficer("三班长", 2000);
        MilitaryPersonOfficer 班长31 = new MilitaryPersonOfficer("一班长", 2000);
        MilitaryPersonOfficer 班长32 = new MilitaryPersonOfficer("二班长", 2000);
        MilitaryPersonOfficer 班长33 = new MilitaryPersonOfficer("三班长", 2000);
        MilitaryPerson[] 士兵 = new MilitarySoldier[90];
        for (int i = 0;i<士兵.length;i++){
            士兵[i] = new MilitarySoldier("小兵",1000);
        }
        连长.add(排长1);
        连长.add(排长2);
        排长1.add(班长11);
        排长1.add(班长12);
        排长1.add(班长13);
        排长2.add(班长21);
        排长2.add(班长22);
        排长2.add(班长23);
        for (int i = 0;i<=9;i++){
            班长11.add(士兵[i]);
            班长12.add(士兵[i+10]);
            班长13.add(士兵[i+20]);
            班长21.add(士兵[i+30]);
            班长22.add(士兵[i+40]);
            班长23.add(士兵[i+50]);
            班长31.add(士兵[i+60]);
            班长32.add(士兵[i+70]);
            班长33.add(士兵[i+80]);
        }
        System.out.println("一排的军饷："+ComputerSalary.computerSalary(排长1));
        System.out.println("一班的军饷："+ComputerSalary.computerSalary(班长11));
        System.out.println("全连的军饷："+ComputerSalary.computerSalary(连长));
    }
}
