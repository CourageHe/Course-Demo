package command;

/**
 * @Author CourageHe
 * @Date 2022/3/28 20:26
 */
public class SimpleRemoteControl {
    private ICommand commandSlot;//只有一个命令插槽（一个按钮）的简单遥控器；如果改成集合类，遥控器就具有多个按钮了
    public void setCommand(ICommand command){
        this.commandSlot = command;
    }
    public void buttonWasPressed(){
        commandSlot.execute();
    }
}
