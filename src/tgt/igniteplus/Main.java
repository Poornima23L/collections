package tgt.igniteplus;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    static Map<String, List<IgniteMembers>> members = new HashMap<>();
    static List<String> departments = new ArrayList<>();
    static Set<String> skillSet = new HashSet<String>();
    static List<IgniteMembers> members1 = new CopyOnWriteArrayList<>();

    public static void main(String[] args){

        Set<String> gautamSkillSet = new HashSet<>();
        gautamSkillSet.add("Java");
        gautamSkillSet.add("SQL");
        gautamSkillSet.add("DS");

        Set<String> divyaSkillSet = new HashSet<>();
        divyaSkillSet.add("Java");
        divyaSkillSet.add("NOSQL");
        divyaSkillSet.add("ML");

        Set<String> amitSkillSet = new HashSet<>();
        amitSkillSet.add("Linux");
        amitSkillSet.add("PSQL");
        amitSkillSet.add("Scripting");

        Set<String> naveenSkillSet = new HashSet<>();
        naveenSkillSet.add("Chef");
        naveenSkillSet.add("React");
        naveenSkillSet.add("AI");

        departments.add("Data Science");
        departments.add("Infrastructure");

        members1.add(new IgniteMembers("Gautam","VTU",departments.get(0),28, gautamSkillSet));
        members1.add(new IgniteMembers("Divya","TGT",departments.get(0),26,divyaSkillSet));
        members1.add(new IgniteMembers("Amit","TMT",departments.get(1),25,amitSkillSet));
        members1.add(new IgniteMembers("Naveen","DOJO",departments.get(1),22,naveenSkillSet));

        Scanner in= new Scanner(System.in);
        int choice,ans;
        do{
            System.out.println("Choose among the following options \n " +
                    "1:Creating a new department \n" +
                     "2:Deleting an existing department \n " +
                    "3:Display all departments \n" +
                     "4:Display all the members in the department \n " +
                    "5:Creating new member into an existing department\n" +
                     "6:Swap the department of the member");
            choice = in.nextInt();
            switch (choice){
                case 1 : addDept();
                         break;
                case 2 : deleteDept();
                         break;
                case 3 : displayDept();
                         break;
                case 4 : displayDeptMem();
                         break;
                case 5 : createMem();
                         break;
                case 6 : swapDep();
                         break;
                default:
                    System.out.println("Enter the valid number");
            }
            System.out.println("Do you want to continue? Press 1 to continue");
            ans= in.nextInt();
        }while (ans==1);
    }
    public static void displayDept(){
        if(departments.isEmpty())
            System.out.println("Department is empty");
        else {
            for(String dept: departments){
                System.out.println("Department name: "+ dept);
            }
        }
    }
    public static void addDept(){
        Scanner in= new Scanner(System.in);
        System.out.println("enter name of the department you want to add");
        String dept = in.nextLine();
        inner:
        if(departments.contains(dept)){
            System.out.println("Department already exists");
            return;
        }
        else{
            members.put(dept,null);
            departments.add(dept);
        }
    }
    public static void deleteDept(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of the department you want to delete");
        String dept = in.nextLine();
        if(departments.contains(dept)){
            departments.remove(dept);
            members.remove(dept);
        }
        else{
            System.out.println("Department does not exist");
        }
    }
    public static void displayDeptMem(){
        if(members1.isEmpty()){
            System.out.println("Members not found");
        }
        else {
            for (String dept: departments){
                System.out.println("Department name : " + dept);
                System.out.println("----------------------------------------------------");
                for (IgniteMembers mem :members1){
                    if(dept==mem.getDept())
                        System.out.println(mem.getName());
                }
                System.out.println("*****************************************************");
            }

        }
    }
    public static void createMem(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name :");
        String name = in.nextLine();
        for(IgniteMembers mem : members1){
            if(mem.getName().contains(name)){
                System.out.println("Name already exists");
                System.out.println("Enter a unique name");
                name = in.nextLine();
            }
        }
        System.out.println("Enter the college name:");
        String college = in.nextLine();
        System.out.println("Enter the age:");
        int age = in.nextInt();
        System.out.println("Enter the number of skill set");
        int count = in.nextInt();
        System.out.println("Enter the skills");
        for (int i=0;i<=count;i++){
            String skill = in.nextLine();
            skillSet.add(skill);
        }
        displayDept();
        System.out.println("Enter the department name to which the member should be added :");
        String dept = in.nextLine();
        List<IgniteMembers> deptMem = new ArrayList<>();
        deptMem.add(new IgniteMembers(name,college,dept,age,skillSet));
        if(departments.contains(dept))
            members.put(dept,deptMem);
        else
            System.out.println("Department does not exist");
        members1.add(new IgniteMembers(name,college,dept,age,skillSet));

    }
    public static void swapDep(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of the member you want to swap the department");
        String mem = in.nextLine();
        for (IgniteMembers memb:members1 ) {
            if(memb.getName().contains(mem)){
                System.out.println("Existing departments are as follows:");
                for (String dept:departments)
                    System.out.println(dept +  "\n");
                System.out.println("Enter the old department of the member ");
                String dep1 = in.nextLine();
                System.out.println("Enter the new department in which member wants to be added");
                String dep2 = in.nextLine();
                memb.setDept(dep2);
            }

        }
    }
}
