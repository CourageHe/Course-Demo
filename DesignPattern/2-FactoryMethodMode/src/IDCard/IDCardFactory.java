package IDCard;

import framework.Factory;
import framework.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName:IDCard
 * @ClassName:IDCardFactory
 * @Description:
 * @Autor:CourageHe
 * @Date: 2020/2/22 21:03
 */
public class IDCardFactory extends Factory {
    private List<String> owners = new ArrayList<>();

    @Override
    public Product createProduct(String owner) {

        System.out.println("创建身份证！！！");
        return  new IDCardProduct(owner);
    }

    public List<String> getOwners() {
        return owners;
    }

    @Override
    public void registerProduct(Product product) {
        owners.add(((IDCardProduct)product).getOwner());
        System.out.println("注册身份证！！！");
    }
}
