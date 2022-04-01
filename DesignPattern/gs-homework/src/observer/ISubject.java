package observer;

/**
 * @Author CourageHe
 * @Date 2022/3/27 19:06
 */
public interface ISubject {//目标（或发布者） ---接口
    void RegistObserver(IObserver obs);//注册
    void RemoveObserver(IObserver obs);//注销
    void NotiftObserver();//通知
}
