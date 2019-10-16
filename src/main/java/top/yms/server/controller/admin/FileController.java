package top.yms.server.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.yms.server.utils.IdGenerator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;


@RequestMapping("/file")
@RestController
public class FileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);
    private static String path = "/home/yms/tmp/upload/";

    @PostMapping("/upload/img")
    @ResponseBody
    public Map<String,Object> upload(@RequestParam("editormd-image-file") MultipartFile file ) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        if (file.isEmpty()) {
            resultMap.put("success",0);
            LOGGER.info( "上传失败，请选择文件");

            return resultMap;
        }


        String fileName = IdGenerator.randomImageName()+file.getOriginalFilename();
        String filePath = path;
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            String fileUrl="http://localhost:8080/file/image?img="+fileName;
            LOGGER.info("upload image url="+fileUrl);
            LOGGER.info("上传成功");

            resultMap.put("success",1);
            resultMap.put("url",fileUrl);
            resultMap.put("message","上传成功");

            return resultMap;

        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
            LOGGER.info("上传失败！");
            resultMap.put("success",0);

            return resultMap;
        }
    }

    /***
     * 向客户端响应图片
     * @param req
     * @param res
     * @throws IOException
     */
    @RequestMapping(value = "/image")
    public void queryPic(@RequestParam("img") String img, HttpServletRequest req, HttpServletResponse res) throws IOException {

        LOGGER.info("request image url="+img);
        res.setContentType("image/jpeg");
        FileInputStream is = new FileInputStream(path+img);

        if (is != null){
            int i = is.available(); // 得到文件大小
            byte data[] = new byte[i];
            is.read(data); // 读数据
            is.close();
            res.setContentType("image/jpeg");  // 设置返回的文件类型
            OutputStream toClient = res.getOutputStream(); // 得到向客户端输出二进制数据的对象
            toClient.write(data); // 输出数据
            toClient.close();
        }
    }

}
