package decorator;

/**
 * @Author CourageHe
 * @Date 2022/4/1 19:28
 */
public class CondimentDecorator extends Beverage{//Condiment（调料）
    protected Beverage beverage;//将饮料包装起来

    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
    @Override
    public String getDescription(){//加调料后的饮料名称
        return beverage.getDescription();
    }

    @Override
    public double Cost() {//加调料后的饮料价格
        return beverage.Cost();
    }
}
