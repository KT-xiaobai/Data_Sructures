package com.igeek.dao;

import com.igeek.data.Database;

/**
 * @author 86183
 * @ClassName: IntelliJ IDEA
 * @Description:
 * @date 2021/3/2 16:04
 */
public class StudentDao {
    private Database database;

    public StudentDao(Database database) {
        this.database = database;
    }

    public Database getDatabase() {
        return database;
    }
}
