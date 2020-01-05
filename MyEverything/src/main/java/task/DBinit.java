package task;

import util.DBUtil;

import java.io.*;
import java.sql.Connection;
import java.sql.Statement;

public class DBinit {

    public static void init() {
//
        InputStream is = DBinit.class.getClassLoader().getResourceAsStream("init.sql");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int index = line.indexOf("--");
                if (index != -1) {
                    line = line.substring(0, index);
                }
                sb.append(line);
            }
            String[] split = sb.toString().split(";");
            Connection connection = null;
            Statement statement = null;
            try {
                for (String sql : split) {
                    connection = DBUtil.getConnection();
                    statement = connection.createStatement();
                    statement.executeUpdate(sql);
                }
            } finally {
                DBUtil.close(connection, statement);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        init();
    }
}
