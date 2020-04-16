package TextParser.Composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Department {
    private String filename;
    private List<Department> childDepartments;

    public Composite() {
        this.childDepartments = new ArrayList<>();
    }

    public void DPCmethod() {
        childDepartments.forEach(Department::DPCmethod);
    }

    @Override
    public String[][] sort() {
        childDepartments.forEach(Department::sort);


        return new String[0][];
    }


    public void addDepartment(Department department) {
        childDepartments.add(department);
    }

    public void removeDepartment(Department department) {
        childDepartments.remove(department);
    }



}