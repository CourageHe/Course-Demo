package decorator;

/**
 * @Author CourageHe
 * @Date 2022/4/1 19:38
 */
public class Client {
    public static void main(String[] args) {
        Beverage beverage1 = new Coffee();//咖啡一杯
        System.out.println(beverage1.getDescription()+":  $"+beverage1.Cost());

        Beverage beverage2 = new Coffee();//咖啡一杯
        beverage2 = new SugarDecorator(beverage2);//加一份糖
        beverage2 = new SugarDecorator(beverage2);//加一份糖
        beverage2 = new MilkDecorator(beverage2);//加一份奶
        System.out.println(beverage2.getDescription()+":  $"+beverage2.Cost());
        //注意：上面创建了4个新对象，被beverage2一层层的封装了起来
        //最终是加了两份糖和一份奶的一杯咖啡

        Beverage beverage3 = new Tea();//茶一杯
        beverage3 = new MilkDecorator(beverage3);//加一份奶
        beverage3 = new MilkDecorator(beverage3);//加一份奶
        beverage3 = new SugarDecorator(beverage3);//加一份糖
        System.out.println(beverage3.getDescription()+":  $"+beverage3.Cost());
    }
}
