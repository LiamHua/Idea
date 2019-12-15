package pers.liam.composite;

import java.util.Iterator;

public class ComputerSalary {
    public static double computerSalary(MilitaryPerson person){
        double sum = 0;
        if (person.isLeaf()){
            sum = sum + person.getSalary();
        }
        if (!person.isLeaf()){
            sum = sum + person.getSalary();
            Iterator<MilitaryPerson> iterator = person.getAllChildren();
            while (iterator.hasNext()){
                MilitaryPerson p = iterator.next();
                sum = sum + computerSalary(p);
            }
        }
        return sum;
    }
}
