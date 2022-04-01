package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author CourageHe
 * @Date 2022/3/27 19:06
 */
public class Cat implements ISubject{//猫
    public String name;
    public List<IObserver> obsList = new ArrayList<>();

    public Cat() {
        this.name = "unKnown";
    }

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void RegistObserver(IObserver obs) {
        obsList.add(obs);
    }

    @Override
    public void RemoveObserver(IObserver obs) {
        obsList.remove(obs);
    }

    public void cry(){
        System.out.println("名为"+this.name +"的小猫咪叫了！！！");
        NotiftObserver();
    }

    @Override
    public void NotiftObserver() {
        for(IObserver observer : obsList){
            observer.update();
        }
    }
}
