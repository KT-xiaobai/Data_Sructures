package com.igeek.sort;

import com.igeek.pojo.Student_Node;

import java.util.ArrayList;

/**
 * @author 86183
 * @ClassName: IntelliJ IDEA
 * @Description:
 * @date 2021/3/1 14:47
 */
public class Heap_Sort {
    /**
     * 堆排序
     * 根据总成绩排序
     */
    public void sortByAll(ArrayList<Student_Node> list) {
        //一次调整，最大值到了根节点
        for (int i = (list.size() - 1 - 1) / 2; i >= 0; i--) {//i相当于start
            adjust(list, i, list.size() - 1);
        }
        //最后一个值与根节点交换
        Student_Node student = new Student_Node();
        for (int j = 0; j < list.size() - 1; j++) {
            student = list.get(0);
            list.set(0, list.get(list.size() - 1 - j));
            list.set(list.size() - 1 - j, student);
            adjust(list, 0, list.size() - 1 - 1 - j);//调整最大的树
        }
        for (Student_Node s : list) {
            s.setSort(list.indexOf(s) + 1);
        }
    }

    public static void adjust(ArrayList<Student_Node> list, int start, int end) {

        Student_Node student = list.get(start);
        //一次调整过程
        for (int i = 2 * start + 1; i <= end; i = 2 * i + 1) {
            //找到左右孩子的最大值
            if (i < end && list.get(i).getAll_grade() > list.get(i + 1).getAll_grade()) {
                i++;  //最大值下标
            }
            if (list.get(i).getAll_grade() < student.getAll_grade()) {
                list.set(start, list.get(i));    //设置第start个位置元素的值
                start = i;
            }
            if (list.get(i).getAll_grade() > student.getAll_grade()) {
                break;
            }
        }
        list.set(start, student);
    }


}

