package strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author CourageHe
 * @Date 2022/4/1 20:05
 */
public class SortContext {//排序算法策略的应用环境类
    private List<String> list = new ArrayList<>();
    private SortStrategy sortStrategy;//聚合一个排序算法对象

    public SortContext() {
    }
    public void Add(String str){
        list.add(str);
    }
    public void Display(){
        for(int i = 0;i<list.size();i++){
            System.out.print(list.get(i));
            if(i != list.size()-1){
                System.out.print(',');
            }
        }
        System.out.println();
    }
    public void SetSortStrategy(SortStrategy sortStrategy) {//设置排序策略
        this.sortStrategy = sortStrategy;
    }

    public void Sort(){//使用指定的排序算法
        sortStrategy.Sort(list);
    }

}
