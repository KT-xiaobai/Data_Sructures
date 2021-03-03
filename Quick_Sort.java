package com.igeek.sort;

import com.igeek.pojo.Student_Node;

import java.util.ArrayList;

/**
 * @author 86183
 * @ClassName: IntelliJ IDEA
 * @Description:
 * @date 2021/3/1 14:36
 */
public class Quick_Sort {
    /**
     * 根据总成绩排序
     *
     * @param list
     * @param low
     * @param high
     */
    public void sortByAll(ArrayList<Student_Node> list, int low, int high) {
        int i, j;
        Student_Node student;
        double temp;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = list.get(low).getAll_grade();
        while (i < j) {
            //先看右边，依次往左递减
            while (temp >= list.get(j).getAll_grade() && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp <= list.get(i).getAll_grade() && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                student = list.get(j);
                list.set(j, list.get(i));
                list.set(i, student);
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        student = list.get(low);
        list.set(low, list.get(i));
        list.set(i, student);
        //递归调用左半数组
        sortByAll(list, low, j - 1);
        //递归调用右半数组
        sortByAll(list, j + 1, high);
        for (Student_Node s : list) {
            s.setSort(list.indexOf(s) + 1);
        }
    }
}
