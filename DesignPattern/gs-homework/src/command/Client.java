package command;

/**
 * @Author CourageHe
 * @Date 2022/3/28 20:31
 */
public class Client {
    public static void main(String[] args) {
        Light light1 = new Light("Living Room");//Living Room 的灯对象

        LightOnCommand lightOnCommand = new LightOnCommand(light1);//Living Room 的开灯命令
        light1.setCommand(lightOnCommand);//遥控器按钮设为 Living Room 开灯
        light1.buttonWasPressed();//按钮按下：开灯
        LightOffCommand lightOffCommand = new LightOffCommand(light1);//Living Room 的关灯命令
        light1.setCommand(lightOffCommand);//遥控器按钮设为 Living Room 关灯
        light1.buttonWasPressed();//按钮按下：关灯
    }
}
