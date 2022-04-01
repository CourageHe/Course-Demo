package command;

/**
 * @Author CourageHe
 * @Date 2022/3/28 20:26
 */
public class LightOnCommand implements ICommand{
    public Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }//执行开灯命令
}
