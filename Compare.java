package com.igeek.tools;

import com.igeek.pojo.Student_Node;

import java.util.Comparator;

/**
 * @author 86183
 * @ClassName: IntelliJ IDEA
 * @Description:
 * @date 2021/3/2 22:30
 */
public class Compare implements Comparator<Student_Node> {
    @Override
    public int compare(Student_Node o1, Student_Node o2) {
        if (o1.getId() > o2.getId())
            return 1;
        else
            return -1;
    }
}

