package dao;

import util.JDBCDao;

public class goodsDao {
    //增删改
    public static boolean update(String sql, Object... obj) {
        return JDBCDao.update(sql, obj);
    }

}
