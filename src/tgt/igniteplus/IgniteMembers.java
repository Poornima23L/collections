package tgt.igniteplus;

import java.util.Set;

public class IgniteMembers {
    private String name,college,dept;
    private int age;
    private Set<String> skillSet;
    public IgniteMembers(String name,String college,String dept,int age,Set<String> skillSet){
        this.name = name;
        this.college = college;
        this.dept = dept;
        this.age = age;
        this.skillSet = skillSet;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name ;
    }
    public String getCollege(){
        return college ;
    }
    public void setCollege(String college ){
        this.college = college  ;
    }
    public String getDept(){
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    public Set<String> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(Set<String> skillSet) {
        this.skillSet = skillSet;
    }

    @Override
    public String toString(){
        return
                "name='" +name+ '\'' +
                "college = '" + college + '\'' +
                ", age=" +age +
                ", skillSet = '" +skillSet + '\'';
    }
}
