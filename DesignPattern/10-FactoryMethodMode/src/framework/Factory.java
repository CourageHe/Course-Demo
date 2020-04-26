package framework;

/**
 * @PackageName:framework
 * @ClassName:Factory
 * @Description:父类决定实例的生成方式，但并不决定所要生成的具体的类，具体的处理全部交给子类
 * @Autor:CourageHe
 * @Date: 2020/2/22 20:35
 */
public abstract class Factory {
    /**
     * final final函数，则继承的子类无法重写，用于决定实例的生成方式
     * @param owner
     * @return
     */
    public final Product create(String owner){
        Product product = createProduct(owner);
        registerProduct(product);
        return product;
    }

    /**
     *虚函数，由子类重写，实现具体的业务
     * @param owner
     * @return
     */
    public abstract Product createProduct(String owner);

    public abstract void registerProduct(Product product);

}
