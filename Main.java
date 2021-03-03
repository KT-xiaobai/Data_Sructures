package com.igeek.main;

import com.igeek.Service.StudentService;
import com.igeek.data.Database;

/**
 * @author 86183
 * @ClassName: IntelliJ IDEA
 * @Description:
 * @date 2021/3/2 22:15
 */
public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        StudentService studentService = new StudentService(database);
        studentService.start();
    }
}
