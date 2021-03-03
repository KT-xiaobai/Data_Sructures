package com.igeek.data;

import com.igeek.pojo.Student_Node;

import java.util.ArrayList;

/**
 * @author 86183
 * @ClassName: IntelliJ IDEA
 * @Description:
 * @date 2021/3/2 16:05
 */
public class Database {
    public Reader_and_Writer rw = new Reader_and_Writer();
    public ArrayList<Student_Node> list = new ArrayList<>();

    public Database() {
        ArrayList<String> list1 = rw.reader();
        for (String s : list1) {
            String student[] = s.split(" ");
            list.add(new Student_Node(Integer.parseInt(student[0]), student[1], student[2],
                    Double.parseDouble(student[3]), Double.parseDouble(student[4]),
                    Double.parseDouble(student[5]), Double.parseDouble(student[6]),
                    Double.parseDouble(student[7]), Integer.parseInt(student[8])));
        }
    }

    public Database(ArrayList<Student_Node> list){
        this.list=list;
    }

    /**
     * 保存信息
     */
    public void save() {
        ArrayList<String> list1 = new ArrayList<>();
        for (Student_Node s : list) {
            String s1 = s.getId() + " " + s.getName() + " " + s.getMajor() + " " + s.getMath_grade() + " " +
                    s.getEnglish_grade() + " " + s.getJava_grade() + " " + s.getCpp_grade() + " " +
                    s.getAll_grade() + " " + s.getSort();
            list1.add(s1);
        }
        rw.writer(list1);
    }
}
