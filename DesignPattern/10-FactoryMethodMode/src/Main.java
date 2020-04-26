import IDCard.IDCardFactory;
import IDCard.IDCardProduct;
import framework.Factory;
import framework.Product;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Main
 * @Description:
 * @Autor:CourageHe
 * @Date: 2020/2/22 22:59
 */
public class Main {
    public static void main(String[]args){
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("张三");
        Product card2 = factory.create("李四");
        Product card3 = factory.create("王五");

        card1.use();
        card2.use();
        card3.use();
    }
}
