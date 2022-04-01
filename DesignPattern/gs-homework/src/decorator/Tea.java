package decorator;

/**
 * @Author CourageHe
 * @Date 2022/3/28 20:52
 */
public class Tea extends Beverage{//Tea 茶

    public Tea() {
        this.Description = "Tea";
    }

    @Override
    public double Cost(){
        return 7.0;
    }//一杯茶的单价 $7.0
}
