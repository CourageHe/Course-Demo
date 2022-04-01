package composite;

/**
 * @Author CourageHe
 * @Date 2022/3/27 19:52
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("======计科研QX211======");
        Team team = new Team("计科研QX211");//新建团队
        Student s1 = new Student("张三","男","2021710001","计科研QX211");
        team.Add(s1);
        Student s2 = new Student("张三2","男","2021710002","计科研QX211");
        team.Add(s2);
        team.Show();

        
        System.out.println("\n\n");
        System.out.println("======计科院团队======");
        Team team2 = new Team("计科院");//新建团队
        team2.Add(s1);//添加学生
        Teacher t1 = new Teacher("王五","女","计算机科学与技术","教授");
        team2.Add(t1);//添加老师

        Person person = new Person("李四","男");//外聘
        team2.Add(person);
        team2.Show();

    }
}
