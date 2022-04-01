package polymorphic;

/**
 * @Author CourageHe
 * @Date 2022/3/27 16:49
 */
public class Person {
    public String name;
    public String sex;
    public Person() {
        this.name = "unKnown";
        this.sex = "unKnown";
    }
    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
    protected String GetString(){
        return "Name："+this.name+";Sex："+ this.sex+";";
    }
    public void Show(){
        System.out.println("Person："+this.GetString());
    }
}
