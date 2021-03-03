package com.igeek.Service;

import com.igeek.dao.StudentDao;
import com.igeek.data.Database;
import com.igeek.pojo.Student_Node;
import com.igeek.sort.Bidirectional_bubble_Sort;
import com.igeek.sort.Heap_Sort;
import com.igeek.sort.Quick_Sort;
import com.igeek.sort.Shell_Sort;
import com.igeek.tools.Compare;

import java.util.Collections;
import java.util.Scanner;

/**
 * @author 86183
 * @ClassName: IntelliJ IDEA
 * @Description:
 * @date 2021/3/2 19:17
 */
public class StudentService {
    private Scanner key = new Scanner(System.in);
    private StudentDao studentDao;
    private Bidirectional_bubble_Sort bidirectional_bubble_sort = new Bidirectional_bubble_Sort();
    private Heap_Sort heap_sort = new Heap_Sort();
    private Quick_Sort quick_sort = new Quick_Sort();
    private Shell_Sort shell_sort = new Shell_Sort();

    public StudentService(Database database) {
        studentDao = new StudentDao(database);
    }

    /**
     * 起始菜单
     */
    public void start() {
        System.out.println("欢迎使用学生档案管理系统");
        mean();
    }

    public void mean(){
        System.out.println("主菜单");
        System.out.println("1.浏览学生信息");
        System.out.println("2.新增学生信息");
        System.out.println("3.查找学生信息");
        System.out.println("4.保存学生信息");
        System.out.println("5.加载学生信息");
        System.out.println("6.退出系统");
        System.out.println("请选择：");
        int chooice = key.nextInt();
        switch (chooice) {
            case 1:
                browse();//浏览学生信息
                break;
            case 2:
                add();//新增学生信息
                break;
            case 3:
                find();//查找学生信息
                break;
            case 4:
                save();//保存学生信息
                break;
            case 5:
                load();//加载学生信息
                break;
            case 6:
                exit();//退出系统
                break;
            default:
                System.out.println("输入错误，请重新输入");
                mean();
        }
    }

    /**
     * 浏览学生信息
     */
    public void browse() {
        //bidirectional_bubble_sort.sortByAll(studentDao.getDatabase().list);
        //heap_sort.sortByAll(studentDao.getDatabase().list);
        quick_sort.sortByAll(studentDao.getDatabase().list, 0, studentDao.getDatabase().list.size() - 1);
        //shell_sort.sortByAll(studentDao.getDatabase().list);
        System.out.println("学号" + "\t" + "姓名" + "\t" + "专业" + "\t" + "数学成绩" + "\t" +
                "英语成绩" + "\t" + "Java成绩" + "\t" + "C++成绩" + "\t" + "总成绩" + "\t" + "排名");
        for (Student_Node s : studentDao.getDatabase().list) {
            System.out.println(s.toString());
        }
        // 下一步操作
        operation();
    }

    /**
     * 浏览学生信息的后续操作
     */
    public void operation() {
        System.out.println("请输入您的操作：");
        System.out.println("1.修改学生信息");
        System.out.println("2.删除学生信息");
        System.out.println("3.新增学生信息");
        System.out.println("4.返回主菜单");
        int chooice = key.nextInt();
        switch (chooice) {
            case 1:
                modification();//修改学生信息
                break;
            case 2:
                delete();//删除学生信息
                break;
            case 3:
                add();//新增学生信息
                break;
            case 4:
                mean();;//返回主菜单
                break;
            default:
                System.out.println("输入错误，请重新输入");
                operation();
        }
    }

    /**
     * 查找需要修改学生的信息
     */
    public void modification() {
        Student_Node student = new Student_Node();
        System.out.println("请输入您要修改的学生学号");
        int id = key.nextInt();
        student = serachById(id);
        if (student == null) {
            System.out.println("没有找到该学生，请重新输入");
            modification();
        } else {
            System.out.println("成功找到该学生信息，并为您成功打印");
            System.out.println("学号" + "\t" + "姓名" + "\t" + "专业" + "\t" + "数学成绩" + "\t" +
                    "英语成绩" + "\t" + "Java成绩" + "\t" + "C++成绩" + "\t" + "总成绩" + "\t" + "排名");
            System.out.println(student.toString());
            //修改学生信息
            modification2(student);
        }

    }

    /**
     * 确认是否修改
     *
     * @param student
     */
    public void modification2(Student_Node student) {
        System.out.println("请问是否确认修改该学生信息");
        System.out.println("确认请输入y，不确认请输入n");
        String chooice = key.next();
        if (chooice.equals("y")) {
            // 修改学生信息
            modification3(student);
        } else if (chooice.equals("n")) {
            System.out.println("为您返回学生信息");
            browse();
        } else {
            System.out.println("输入错误，请重新输入");
            modification2(student);
        }
    }

    /**
     * 修改学生信息
     *
     * @param student
     */
    public void modification3(Student_Node student) {
        System.out.println("请输入您要修改的项目");
        System.out.println("1.数学成绩");
        System.out.println("2.英语成绩");
        System.out.println("3.Java成绩");
        System.out.println("4.C++成绩");
        int chooice = key.nextInt();
        switch (chooice) {
            case 1:
                System.out.println("您要修改的项目为数学成绩");
                System.out.println("请输入修改后的值");
                double math_grade = key.nextDouble();
                student.setMath_grade(math_grade);
                student.setAll_grade();
                break;
            case 2:
                System.out.println("您要修改的项目为英语成绩");
                System.out.println("请输入修改后的值");
                double english_grade = key.nextDouble();
                student.setEnglish_grade(english_grade);
                student.setAll_grade();
                break;
            case 3:
                System.out.println("您要修改的项目为Java成绩");
                System.out.println("请输入修改后的值");
                double java_grade = key.nextDouble();
                student.setJava_grade(java_grade);
                student.setAll_grade();
                break;
            case 4:
                System.out.println("您要修改的项目为C++成绩");
                System.out.println("请输入修改后的值");
                double cpp_grade = key.nextDouble();
                student.setCpp_grade(cpp_grade);
                student.setAll_grade();
                break;
            default:
                System.out.println("输入错误，请重新输入");
                modification3(student);
        }
        modification4(student);

    }

    /**
     * 是否要继续修改
     *
     * @param student
     */
    public void modification4(Student_Node student) {
        System.out.println("修改成功，请问是否要继续修改");
        System.out.println("是请输入y，否请输入n");
        String chooice = key.next();
        if (chooice.equals("y")) {
            // 修改学生信息
            modification3(student);
        } else if (chooice.equals("n")) {
            System.out.println("为您返回学生信息");
            browse();
        } else {
            System.out.println("输入错误，请重新输入");
            modification4(student);
        }
    }

    /**
     * 查找需要删除学生的信息
     */
    public void delete() {
        Student_Node student = null;
        System.out.println("请输入您要删除的学生学号");
        int id = key.nextInt();
        student = serachById(id);
        if (student == null) {
            System.out.println("没有找到该学生，请重新输入");
            delete();
        } else {
            System.out.println("成功找到该学生信息，并为您成功打印");
            System.out.println("学号" + "\t" + "姓名" + "\t" + "专业" + "\t" + "数学成绩" + "\t" +
                    "英语成绩" + "\t" + "Java成绩" + "\t" + "C++成绩" + "\t" + "总成绩" + "\t" + "排名");
            System.out.println(student.toString());
            //删除学生信息
            delete2(student);
        }
    }

    /**
     * 确认是否删除
     *
     * @param student
     */
    public void delete2(Student_Node student) {
        System.out.println("请问是否确认删除该学生信息");
        System.out.println("确认请输入y，不确认请输入n");
        String chooice = key.next();
        if (chooice.equals("y")) {
            // 删除学生信息
            delete3(student);
        } else if (chooice.equals("n")) {
            System.out.println("为您返回学生信息");
            browse();
        } else {
            System.out.println("输入错误，请重新输入");
            delete2(student);
        }
    }

    /**
     * 删除学生信息
     *
     * @param student
     */
    public void delete3(Student_Node student) {
        studentDao.getDatabase().list.remove(student);
        delete4();
    }

    /**
     * 是否要继续删除
     */
    public void delete4() {
        System.out.println("删除成功，请问是否要继续删除");
        System.out.println("是请输入y，否请输入n");
        String chooice = key.next();
        if (chooice.equals("y")) {
            // 删除学生信息
            delete();
        } else if (chooice.equals("n")) {
            System.out.println("为您返回学生信息");
            browse();
        } else {
            System.out.println("输入错误，请重新输入");
            delete4();
        }
    }

    /**
     * 新增学生信息
     */
    public void add() {
        System.out.println("请输入学号");
        int id = key.nextInt();
        //检查学号是否与库中重复
        if (inspect(id)) {
            //若重复，重新输入
            System.out.println("学号重复，请重新输入");
            add();
        } else {
            //不重复，继续录入其他信息
            System.out.println("请输入姓名");
            String name = key.next();
            System.out.println("请输入专业");
            String major = key.next();
            System.out.println("请输入数学成绩");
            double math_grade = key.nextDouble();
            System.out.println("请输入英语成绩");
            double english_grade = key.nextDouble();
            System.out.println("请输入Java成绩");
            double java_grade = key.nextDouble();
            System.out.println("请输入C++成绩");
            double cpp_grade = key.nextDouble();
            double all_grade = math_grade + english_grade + java_grade + cpp_grade;
            int sort = studentDao.getDatabase().list.size() + 2;
            Student_Node student = new Student_Node(id, name, major, math_grade, english_grade,
                    java_grade, cpp_grade, all_grade, sort);
            studentDao.getDatabase().list.add(student);
            System.out.println("添加成功，为您返回主菜单");
            mean();;
        }
    }

    /**
     * 检查学号是否与库中重复
     * 重复返回true，不重复返回false
     *
     * @param id
     * @return
     */
    public boolean inspect(int id) {
        for (Student_Node s : studentDao.getDatabase().list) {
            if (s.getId() == id)
                return true;
        }
        return false;
    }

    /**
     * 查找学生信息
     */
    public void find() {
        System.out.println("请选择您要查找的方式");
        System.out.println("1.学号");
        System.out.println("2.姓名");
        int chooice = key.nextInt();
        switch (chooice) {
            case 1:
                //学号查找
                serachById();
                break;
            case 2:
                //姓名查找
                serachByName();
                break;
            default:
                System.out.println("输入错误，请重新输入");
                find();
        }

    }

    /**
     * 使用学号查找学生信息
     *
     * @return
     */
    public void serachById() {
        Student_Node student = null;
        System.out.println("请输入您要查找学生的学号");
        int id = key.nextInt();
        for (Student_Node s : studentDao.getDatabase().list) {
            if (s.getId() == id) {
                student = s;
            }
        }
        if (student == null) {
            System.out.println("抱歉，没有找到该学号的学生");
            nextBySerachById();
        } else {
            System.out.println("成功查找到学生信息，为您打印该学生的信息");
            System.out.println("学号" + "\t" + "姓名" + "\t" + "专业" + "\t" + "数学成绩" + "\t" +
                    "英语成绩" + "\t" + "Java成绩" + "\t" + "C++成绩" + "\t" + "总成绩" + "\t" + "排名");
            System.out.println(student.toString());
            nextBySerach(student);
        }
    }

    /**
     * 使用学号查找学生信息（以删除修改信息为目的）
     *
     * @return
     */
    public Student_Node serachById(int id) {
        Student_Node student = null;
        for (Student_Node s : studentDao.getDatabase().list) {
            if (s.getId() == id) {
                student = s;
            }
        }
        return student;
    }

    /**
     * 使用学号查找失败后的下一步操作
     */
    public void nextBySerachById() {
        System.out.println("请您选择接下来的步骤");
        System.out.println("1.重新输入学号");
        System.out.println("2.使用姓名查找");
        System.out.println("3.返回初始菜单");
        int chooice = key.nextInt();
        switch (chooice) {
            case 1:
                serachById();
                break;
            case 2:
                serachByName();
                break;
            case 3:
                mean();
                break;
            default:
                System.out.println("输入错误，请重新输入");
                nextBySerachById();
        }
    }

    /**
     * 查找成功后的下一步操作
     */
    public void nextBySerach(Student_Node student) {
        System.out.println("请输入接下来的步骤");
        System.out.println("1.修改学生信息");
        System.out.println("2.删除学生信息");
        System.out.println("3.返回初始菜单");
        int chooice = key.nextInt();
        switch (chooice) {
            case 1:
                modification3(student);
                break;
            case 2:
                delete3(student);
                break;
            case 3:
                mean();
                break;
            default:
                System.out.println("输入错误，请重新输入");
                nextBySerachById();
        }
    }

    /**
     * 使用姓名查找学生信息
     *
     * @return
     */
    public void serachByName() {
        Student_Node student = null;
        System.out.println("请输入您要查找学生的姓名");
        String name = key.next();
        for (Student_Node s : studentDao.getDatabase().list) {
            if (s.getName().equals(name)) {
                student = s;
            }
        }
        if (student == null) {
            System.out.println("抱歉，没有找到该姓名的学生");
            nextBySerachByName();
        } else {
            System.out.println("成功查找到学生信息，为您打印学生的信息");
            System.out.println("学号" + "\t" + "姓名" + "\t" + "专业" + "\t" + "数学成绩" + "\t" +
                    "英语成绩" + "\t" + "Java成绩" + "\t" + "C++成绩" + "\t" + "总成绩" + "\t" + "排名");
            System.out.println(student.toString());
            nextBySerach(student);
        }
    }

    /**
     * 使用姓名查找失败后的下一步操作
     */
    public void nextBySerachByName() {
        System.out.println("请您选择接下来的步骤");
        System.out.println("1.重新输入姓名");
        System.out.println("2.使用学号查找");
        System.out.println("3.返回初始菜单");
        int chooice = key.nextInt();
        switch (chooice) {
            case 1:
                serachByName();
                break;
            case 2:
                serachById();
                break;
            case 3:
                mean();
                break;
            default:
                System.out.println("输入错误，请重新输入");
                nextBySerachById();
        }
    }

    /**
     * 保存学生信息
     */
    public void save() {
        Compare c = new Compare();
        Collections.sort(studentDao.getDatabase().list, c);
        studentDao.getDatabase().save();
        System.out.println("保存成功，为您返回主菜单");
        mean();
    }

    /**
     * 加载学生信息
     */
    public void load() {
        studentDao = new StudentDao(new Database());
        System.out.println("加载成功，为您返回主菜单");
        mean();
    }

    /**
     * 退出系统
     */
    public void exit() {
        System.out.println("请确认您是否在退出前保存了您修改的信息");
        System.out.println("确认请输入y，不确认请输入n");
        String chooice = key.next();
        if (chooice.equals("y")) {
            System.out.println("欢迎下次使用，再见");
        } else if (chooice.equals("n")) {
            exit2();
        } else {
            System.out.println("输入错误，请重新输入");
            exit();
        }
    }

    /**
     * 未保存信息退出
     */
    public void exit2() {
        System.out.println("请问是否需要保存此次修改");
        System.out.println("需要请输入y，不需要请输入n");
        String chooice1 = key.next();
        if (chooice1.equals("y")) {
            System.out.println("即将为您保存此次修改");
            save();
            System.out.println("保存成功，欢迎下次使用，再见");
        } else if (chooice1.equals("n")) {
            System.out.println("欢迎下次使用，再见");
        } else {
            System.out.println("输入错误，请重新输入");
            exit2();
        }
    }
}
