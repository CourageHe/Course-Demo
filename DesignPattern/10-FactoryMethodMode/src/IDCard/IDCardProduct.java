package IDCard;

import framework.Product;

/**
 * @PackageName:IDCard
 * @ClassName:IDCardProduct
 * @Description:
 * @Autor:CourageHe
 * @Date: 2020/2/22 21:11
 */
public class IDCardProduct extends Product {
    private String owner;

    public String getOwner() {
        return owner;
    }

    public IDCardProduct(String owner){
        this.owner = owner;

    }
    @Override
    public void use() {
        System.out.println(owner + "使用身份证！！！");

    }
}
