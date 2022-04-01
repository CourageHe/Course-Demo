package polymorphic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author CourageHe
 * @Date 2022/3/27 17:00
 */
public class Client {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person p1 = new Person();
        personList.add(p1);
        Person p2 = new Person("张三","男");
        personList.add(p2);
        Student s1 = new Student("李四","男","2021710000","计科研QX211");
        personList.add(s1);
        Teacher t1 = new Teacher("王五","女","计算机科学与技术","教授");
        personList.add(t1);
        for(Person p : personList) {
            p.Show();
        }
    }
}
