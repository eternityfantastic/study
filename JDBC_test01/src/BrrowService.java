import com.mysql.jdbc.Connection;
import com.yang.DBUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BrrowService {
    public static void querByBookName() {
        Connection collection = null;
        PreparedStatement preparedStatement = null;

        collection = DBUtil.getCollection();
        String sql = "";
        try {
            preparedStatement = collection.prepareStatement(sql);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
