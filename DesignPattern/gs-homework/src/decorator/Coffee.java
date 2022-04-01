package decorator;

import sun.security.krb5.internal.crypto.Des;

/**
 * @Author CourageHe
 * @Date 2022/3/28 20:52
 */
public class Coffee extends Beverage{//咖啡

    public Coffee() {
        this.Description = "Coffee";
    }

    @Override
    public double Cost(){
        return 10.0;
    }//一杯咖啡的单价 $ 10.0

}
