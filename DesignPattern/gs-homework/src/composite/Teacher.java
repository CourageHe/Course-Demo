package composite;

/**
 * @Author CourageHe
 * @Date 2022/3/27 16:49
 */
public class Teacher extends Person {
    public String department;
    public String professionalTitle;

    public Teacher() {
        super("unKnown", "unKnown");
        this.department = "unKnown";
        this.professionalTitle = "unKnown";
    }

    public Teacher(String name, String sex, String department, String professionalTitle) {
        super(name, sex);
        this.department = department;
        this.professionalTitle = professionalTitle;
    }
    @Override
    protected String GetString(){
        return super.GetString()+"Department："+department+";ProfessionalTitle："+ professionalTitle+";";
    }
    @Override
    public void Show(){
        System.out.println("Teacher："+this.GetString());
    }
}
