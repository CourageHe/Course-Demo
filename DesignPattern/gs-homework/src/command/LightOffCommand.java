package command;

/**
 * @Author CourageHe
 * @Date 2022/3/28 20:26
 */
public class LightOffCommand implements ICommand{
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.Off();
    }//执行关灯命令
}
