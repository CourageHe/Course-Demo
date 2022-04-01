package observer;

/**
 * @Author CourageHe
 * @Date 2022/3/27 19:06
 */
public class Dog implements IObserver{
    public String name;

    public Dog() {
        this.name = "unKnown";
    }

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println("名为"+this.name +"的小狗来找猫玩啦！！！");

    }
}
