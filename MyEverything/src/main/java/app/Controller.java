package app;

import dao.FileOperateDAO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;
import task.DBInit;
import task.FileOperateTask;
import task.FileScanCallback;
import task.FileScanTask;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private GridPane rootPane;

    @FXML
    private TextField searchField;

    @FXML
    private TableView<FileMeta> fileTable;

    @FXML
    private Label srcDirectory;

    Thread t=null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        创建数据库
        DBInit.init();
        // 添加搜索框监听器，内容改变时执行监听事件
        searchField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//                搜索框发生变化时,刷新表格数据
                freshTable();
            }
        });
    }

    public void choose(Event event) {
        // 选择文件目录
        DirectoryChooser directoryChooser=new DirectoryChooser();
        Window window = rootPane.getScene().getWindow();
        File file = directoryChooser.showDialog(window);

        if(file == null) {
            return;
        }
        // 获取选择的目录路径，并显示
        String path = file.getPath();
        srcDirectory.setText(path);

        if (t!=null) {
            t.interrupt();
        }
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                FileScanCallback callback = new FileOperateTask();
//                FileScanCallback 是 FileScanTask的一个属性
//                 FileOperateTask implements FileScanCallback
                FileScanTask task = new FileScanTask(callback);
                task.startScan(file);
                //等待task结束
                try {
                    task.waitFinish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行完毕");
                freshTable();
            }
        });
        t.start();
    }

    // 刷新表格数据
    private void freshTable(){
        ObservableList<FileMeta> metas = fileTable.getItems();
        metas.clear();
//        搜索文件夹
        List<FileMeta> datas = FileOperateDAO.search(srcDirectory.getText(),
                searchField.getText());//根据文本框和选择框搜索
        metas.addAll(datas);
    }
}