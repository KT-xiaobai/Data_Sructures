package com.igeek.sort;

import com.igeek.pojo.Student_Node;

import java.util.ArrayList;

/**
 * @author 86183
 * @ClassName: IntelliJ IDEA
 * @Description:
 * @date 2021/3/1 11:14
 */
public class Bidirectional_bubble_Sort {
    /**
     * 根据总成绩排序
     *
     * @param list
     */
    public void sortByAll(ArrayList<Student_Node> list) {
        boolean needNextPass = true;
        for (int i = 0, j; i < list.size() / 2 && needNextPass; i++) {
            needNextPass = false;
            // 正向排序
            for (j = i; j < list.size() - 1 - i; j++) {
                if (list.get(j).getAll_grade() < list.get(j + 1).getAll_grade()) {
                    Student_Node student = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, student);
                    needNextPass = true;
                }
            }
            // 反向排序
            for (--j; j > i; j--) {
                if (list.get(j).getAll_grade() > list.get(j - 1).getAll_grade()) {
                    Student_Node student = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, student);
                    needNextPass = true;
                }
            }
        }
        for (Student_Node s : list) {
            s.setSort(list.indexOf(s) + 1);
        }
    }
}