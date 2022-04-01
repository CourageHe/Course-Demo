package observer;

/**
 * @Author CourageHe
 * @Date 2022/3/27 19:14
 */
public class Client {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Tom");
        Dog dog = new Dog("Dog");
        Mouse mouse = new Mouse("Jerry");
        Mouse mouse2 = new Mouse("Jerry2");

        cat1.RegistObserver(dog);
        cat1.RegistObserver(mouse);
        cat1.RegistObserver(mouse2);
        cat1.cry();

        System.out.println("==========移除Jerry2==========");
        cat1.RemoveObserver(mouse2);
        cat1.cry();


    }
}
