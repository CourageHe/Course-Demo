package decorator;

/**
 * @Author CourageHe
 * @Date 2022/3/28 20:53
 */
public class SugarDecorator extends CondimentDecorator{//sugar(糖)
    public SugarDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {//加了糖后的饮料名称
        return super.getDescription() + ",sugar";
    }

    @Override
    public double Cost() {
        return super.Cost() + 0.5;
    }//糖单价：0.2$/份
}
