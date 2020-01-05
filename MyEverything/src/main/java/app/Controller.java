package app;
import dao.FileOperateDao;
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
import task.FileScanCallback;
import task.FileScanner;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller implements Initializable {

    @FXML
    private GridPane rootPane;

    @FXML
    private TextField searchField;

    @FXML
    private TableView<FileMeta> fileTable;

    @FXML
    private Label srcDirectory;
    private Thread t;


    public void initialize(URL location, ResourceBundle resources) {
        // 添加搜索框监听器，内容改变时执行监听事件
        searchField.textProperty().addListener(new ChangeListener<String>() {


            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                freshTable();
            }
        });
    }

    public void choose(Event event) {
        // 选择文件目录
        DirectoryChooser directoryChooser=new DirectoryChooser();
        Window window = rootPane.getScene().getWindow();
        File file = directoryChooser.showDialog(window);
        if(file == null){
            return;
        }
        // 获取选择的目录路径，并显示
        String path = file.getPath();
        srcDirectory.setText(path);
        if(t == null){
            t.interrupt();
        }
        t = new Thread(new Runnable() {
            @Override
            public void run() {
//                创建fileScanner 执行start方法扫描根目录
                FileScanCallback callback = new FileOperateDao();
                FileScanner task = new FileScanner(callback);
//                如果扫描结果是目录还会继续创建线程进行扫描，等到全部文件扫描完成进行刷新表格
                task.startScan(new File("D:\\Study\\TCP\\src"));
                task.waitFinish();
//                freshTable();
            }
        });
        t.start();
    }

    // 刷新表格数据
    private void freshTable(){
//
        ObservableList<FileMeta> metas = fileTable.getItems();
        metas.clear();
        List<FileMeta> datas = new ArrayList<>();
        datas.add(new FileMeta("A","D:/",1323,new Date().getTime(),true));
        metas.addAll();

    }
}