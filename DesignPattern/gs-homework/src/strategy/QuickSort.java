package strategy;

import java.util.Collections;
import java.util.List;

/**
 * @Author CourageHe
 * @Date 2022/4/1 20:11
 */
public class QuickSort extends SortStrategy{
    @Override
    public void Sort(List<String> list) {
        Collections.sort(list);//实现Quick（快速）排序
        System.out.println("Quick sort.. ok!");
    }
}
