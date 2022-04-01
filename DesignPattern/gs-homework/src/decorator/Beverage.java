package decorator;

/**
 * @Author CourageHe
 * @Date 2022/3/28 20:51
 */
public abstract class Beverage {//Beverage(饮料) -- 抽象类
    protected String Description = "unKnown Beverage";

    public String getDescription() {
        return Description;
    }//饮料名称
    public abstract double Cost();//饮料价格
}
