package com.igeek.sort;

import com.igeek.pojo.Student_Node;

import java.util.ArrayList;

/**
 * @author 86183
 * @ClassName: IntelliJ IDEA
 * @Description:
 * @date 2021/3/1 14:23
 */
public class Shell_Sort {
    /**
     * 根据总成绩排序
     *
     * @param list
     */
    public void sortByAll(ArrayList<Student_Node> list) {
        for (int gap = (int) Math.floor((list.size()) / 2); gap > 0; gap = (int) Math.floor(gap / 2)) {
            for (int i = gap; i < list.size(); i++) {
                int j = i;
                double value = list.get(i).getAll_grade();
                Student_Node student = list.get(i);
                while (j - gap >= 0 && value > list.get(j - gap).getAll_grade()) {
                    list.set(j, (list.get(j - gap)));
                    j = j - gap;
                }
                list.set(j, student);
            }
        }
        for (Student_Node s : list) {
            s.setSort(list.indexOf(s) + 1);
        }
    }
}
