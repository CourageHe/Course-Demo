package strategy;

import java.util.Collections;
import java.util.List;

/**
 * @Author CourageHe
 * @Date 2022/4/1 20:11
 */
public class MergeSort extends SortStrategy{
    @Override
    public void Sort(List<String> list) {
        Collections.sort(list);//实现Merge（归并）排序
        System.out.println("Merge sort.. ok!");
    }
}
