package command;

/**
 * @Author CourageHe
 * @Date 2022/3/28 20:27
 */
public class Light extends SimpleRemoteControl{
    public String name;

    public Light(String name) {
        this.name = name;
    }

    public void on(){
        System.out.println(this.name+"号灯开启啦！！！");
    }//开灯操作
    public void Off(){
        System.out.println(this.name+"号灯关闭啦！！！");
    }//关灯操作
}
