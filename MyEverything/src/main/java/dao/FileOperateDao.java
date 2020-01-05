package dao;

import task.FileScanCallback;
import util.DBUtil;
import util.Pinyin4JUtil;

import java.io.File;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileOperateDao implements FileScanCallback {

    @Override
    public void executor(File dir) {
//
//      参数设置
        String sql = "INSERT into file_meta (name, path, is_directory, size, last_modified,pinyin, pinyin_first,) values (?,?,?,?,?,?,?)";
        Object[] objects =
                {dir.getName(),
                dir.getParent(),
                dir.isDirectory(),
                dir.length(),
                dir.lastModified(),
                null,null};
        if (Pinyin4JUtil.containsChinese(dir.getName())) {
            String[] pinyins = Pinyin4JUtil.get(dir.getName());
            objects[5] = pinyins[0];
            objects[6] = pinyins[1];
        }
//        执行sql和关闭资源
        update(sql, objects);
    }

    private boolean update(String sql, Object... obj) {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(sql);
//            给占位符传值；
            for (int i = 0; i < obj.length; i++) {
                pstm.setObject(i + 1, obj[i]);
            }
            result = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, pstm, null);

        }
        return result > 0 ? true : false;
    }


}
