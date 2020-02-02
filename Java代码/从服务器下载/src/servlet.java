import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
@WebServlet("/index")
public class servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");
//       将文件加载到内存；
//        1.获取文件的服务器路径

        ServletContext context= this.getServletContext();
        String path = context.getRealPath("/picture/"+filename);
        FileInputStream InputStream = new FileInputStream(path);
        //设置响应头
        String mimeType = context.getMimeType(filename);
        resp.setHeader("content-type",mimeType);
        resp.setHeader("content-disposition","attachment;filename"+filename);
        //将输入流的数据写入到resp输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] buff = new byte[1024*8];
        int len = 0;
        while((len = InputStream.read(buff))!=-1){
            outputStream.write(buff,0,len);
        }
        InputStream.close();
    }
}
