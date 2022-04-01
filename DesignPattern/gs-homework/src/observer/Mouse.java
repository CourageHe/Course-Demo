package observer;

/**
 * @Author CourageHe
 * @Date 2022/3/27 19:06
 */
public class Mouse implements IObserver{//老鼠
    public String name;

    public Mouse() {
        this.name = "unKnown";
    }

    public Mouse(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println("名为"+this.name +"的小老鼠在跑路中！！！");

    }
}
