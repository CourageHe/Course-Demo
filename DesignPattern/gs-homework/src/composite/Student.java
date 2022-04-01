package composite;

/**
 * @Author CourageHe
 * @Date 2022/3/27 16:49
 */
public class Student extends Person {
    public String studentNo;
    public String className;

    public Student() {
        super("unKnown", "unKnown");
        this.studentNo = "unKnown";
        this.className = "unKnown";
    }

    public Student(String name, String sex, String studentNo, String className) {
        super(name, sex);
        this.studentNo = studentNo;
        this.className = className;
    }
    @Override
    protected String GetString(){
        return super.GetString()+"StudentNo："+this.studentNo+";ClassName："+ this.className+";";
    }
    @Override
    public void Show(){
        System.out.println("Student："+this.GetString());
    }
}
