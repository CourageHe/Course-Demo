package decorator;

/**
 * @Author CourageHe
 * @Date 2022/3/28 20:52
 */
public class MilkDecorator extends CondimentDecorator{// milk 牛奶
    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {//加了牛奶后的饮料名称
        return super.getDescription() + ",milk";
    }

    @Override
    public double Cost() {
        return super.Cost() + 0.2;
    }//牛奶单价：0.2$/份
}
