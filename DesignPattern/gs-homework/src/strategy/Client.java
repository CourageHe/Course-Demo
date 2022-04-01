package strategy;

/**
 * @Author CourageHe
 * @Date 2022/4/1 20:21
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("Test sort strategy");
        SortContext nameList = new SortContext();
        nameList.Add("Jack");
        nameList.Add("Mike");
        nameList.Add("Eleven");
        nameList.Add("CourageHe");
        nameList.SetSortStrategy(new QuickSort());//设置为快速排序
        nameList.Sort();
        nameList.Display();

        nameList.SetSortStrategy(new ShellSort());//设置为快速排序
        nameList.Sort();
        nameList.Display();

        nameList.SetSortStrategy(new MergeSort());//设置为快速排序
        nameList.Sort();
        nameList.Display();
    }
}
