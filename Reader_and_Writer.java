package com.igeek.data;

import java.io.*;
import java.util.ArrayList;

/**
 * @author 86183
 * @ClassName: IntelliJ IDEA
 * @Description:
 * @date 2021/3/2 15:30
 */
public class Reader_and_Writer {
    public BufferedReader br;
    public BufferedWriter bw;
    public File file = new File("E:\\work\\idea project\\Data_Sructures\\Project_1\\src\\student");

    public Reader_and_Writer() {
    }

    public ArrayList<String> reader() {
        ArrayList<String> list = new ArrayList<>();
        //创建字符缓冲输入流
        try {
            br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file)));
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean writer(ArrayList<String> list) {
        try {
            bw = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(file)));
            for (String s : list) {
                bw.write(s);
                bw.newLine();
            }
            bw.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
