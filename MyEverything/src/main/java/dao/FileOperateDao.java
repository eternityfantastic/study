package dao;

import app.FileMeta;
import util.DBUtil;
import util.Pinyin4Util;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperateDAO {
//查询
    public static List<FileMeta> query(String dirPath) {
        Connection connection = null;
        PreparedStatement statement =null;
        ResultSet resultSet = null;
        List<FileMeta> metas = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            String sql = "select name, path, size, last_modifile, is_directory"
                    +" from file_mate where path=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,dirPath);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String path = resultSet.getString("path");
                long size = resultSet.getLong("size");
                long last_modified = resultSet.getLong("last_modifile");
                boolean is_directory = resultSet.getBoolean("is_directory");
                FileMeta meta = new FileMeta(name,path,size,last_modified,is_directory);
                metas.add(meta);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return metas;
    }
//    插入
    public static void insert(FileMeta localMeta) {
        Connection connection = null;
        PreparedStatement statement =null;
        try {
            try {
                //获取链接
                connection = DBUtil.getConnection();
                String sql = "insert into file_mate"+"(name, path, size, last_modifile, pinyin, pinyin_first, is_directory) VALUES (?,?,?,?,?,?,?)";
                //获取操作命令对象
                statement = connection.prepareStatement(sql);
                //填充占位符
                statement.setString(1,localMeta.getName());
                statement.setString(2,localMeta.getPath());
                statement.setLong(3,localMeta.getSize());
                statement.setTimestamp(4,new Timestamp(localMeta.getLastModified()));
                String pinyin = null;
                String pinyin_first = null;
                //包含中文字符需要保存全屏和拼音首字母
                if (Pinyin4Util.containChinese(localMeta.getName())){
                    String[] pinyins = Pinyin4Util.get(localMeta.getName());
                    pinyin = pinyins[0];
                    pinyin_first = pinyins[1];
                }
                statement.setString(5,pinyin);
                statement.setString(6,pinyin_first);
                statement.setBoolean(7,localMeta.getDirectory());
                //执行SQL语句
                System.out.println("insert into file_mate");
                statement.executeUpdate();
            } finally {
                DBUtil.close(connection,statement);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void delete(FileMeta meta) {
        Connection connection = null;
        PreparedStatement statement =null;
        try {
            try {
                //获取链接
                connection = DBUtil.getConnection();
                connection.setAutoCommit(false);
                String sql = "delete from file_mate where name=? and path=? and is_directory=?";

                //获取操作命令对象
                statement = connection.prepareStatement(sql);
                //填充占位符
                statement.setString(1,meta.getName());
                statement.setString(2,meta.getPath());
                statement.setBoolean(3,meta.getDirectory());
                //执行SQL语句
                statement.executeUpdate();
                //删除子文件 子文件夹
                if (meta.getDirectory()){
                    sql = "delete from file_mate where path=? or path like ?";
                    statement = connection.prepareStatement(sql);
                    String path = meta.getPath()+File.separator+meta.getName();
                    statement.setString(1,path);
                    statement.setString(2,path+File.separator+"%");
                    statement.executeUpdate();
                }
                connection.commit();
        }catch (SQLException e){
            e.printStackTrace();
                try {
                    if (connection!=null) {
                        connection.rollback();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
        DBUtil.close(connection,statement);
        }
    }
//根据选择框和输入框
    public static List<FileMeta> search(String dir,String text) {
        Connection connection = null;
        PreparedStatement statement =null;
        ResultSet resultSet = null;
        List<FileMeta> metas = new ArrayList<>();
        try {
            boolean empty = dir==null || dir.trim().length()==0;
            connection = DBUtil.getConnection();
            String sql = "select name, path, size, last_modifile, is_directory"
                    +" from file_mate where name like ? or pinyin like ?"+
                    "or pinyin_first like ?"+
                    (empty? "":"and(path=? or path like ?)");
            statement = connection.prepareStatement(sql);
            statement.setString(1,"%"+text+"%");
            statement.setString(2,"%"+text+"%");
            statement.setString(3,"%"+text+"%");
            if(!empty){
                statement.setString(4,dir);
                statement.setString(5,dir+File.separator+"%");
            }
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String path = resultSet.getString("path");
                long size = resultSet.getLong("size");
                long last_modified = resultSet.getLong("last_modifile");
                boolean is_directory = resultSet.getBoolean("is_directory");

                FileMeta meta = new FileMeta(name,path,size,last_modified,is_directory);
                metas.add(meta);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return metas;

    }
}

