package strategy;

import java.util.Collections;
import java.util.List;

/**
 * @Author CourageHe
 * @Date 2022/4/1 20:11
 */
public class ShellSort extends SortStrategy{
    @Override
    public void Sort(List<String> list) {
        Collections.sort(list);//实现Shell（希尔）排序
        System.out.println("Shell sort.. ok!");
    }
}
