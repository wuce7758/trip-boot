package com.trip.web;

import com.trip.base.RestError;
import com.trip.base.RestResponse;
import com.trip.multipart.FileUploadProgressListener;
import com.trip.multipart.Progress;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
@RequestMapping("upload")
public class UploadController {

    /**
     * 简单上传页面
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String uploadPage() {
        return "upload";
    }

    /**
     * 简单上传
     *
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<String> uploadFile(HttpServletRequest request) {

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            // Inform user about invalid request
            return new RestResponse<>(RestError.me("Not a common request."));
        }

        RestResponse<String> restResponse = new RestResponse<>();
        // Create a new file upload handler
        try {

            ServletFileUpload upload = new ServletFileUpload();

            // Parse the request
            FileItemIterator iter = upload.getItemIterator(request);
            while (iter.hasNext()) {
                FileItemStream item = iter.next();
                String name = item.getFieldName();
                InputStream stream = item.openStream();
                if (!item.isFormField()) {
                    String filename = item.getName();
                    // Process the input stream
                    OutputStream out = new FileOutputStream(filename);
                    IOUtils.copy(stream, out);
                    stream.close();
                    out.close();
                }
            }
            restResponse.setSuccess(true);
        } catch (FileUploadException e) {
            restResponse.setError(RestError.me("File upload error:" + e.toString()));
        } catch (IOException e) {
            restResponse.setError(RestError.me("Internal server IO error:" + e.toString()));
        }
        return restResponse;
    }

    /*@RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<String> uploadFile(@RequestParam("upfile") MultipartFile file) {
        RestResponse<String> restResponse = new RestResponse<>();
        if (null !=file && !file.isEmpty()) {
            try {
                String path = UploadController.class.getResource("/").getPath();

                File targetFile = new File(path + "/upload/" + file.getOriginalFilename());

                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(targetFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                restResponse.setError(RestError.me("上传失败，" + e.getMessage()));
            } catch (IOException e) {
                e.printStackTrace();
                restResponse.setError(RestError.me("上传失败，" + e.getMessage()));
            }
            restResponse.setSuccess(true);
        } else {
            restResponse.setError(RestError.me("上传失败，因为文件是空的"));
        }
        return restResponse;
    }
    */

    /**
     * 上传进度
     *
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "upfile/progress", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Progress uploadStatus(HttpSession httpSession) {
        Object object = httpSession.getAttribute(FileUploadProgressListener.UP_PROGRESS_FEIED);
        if(null == object){
            return new Progress();
        }
        Progress status = (Progress) object;
        return status;
    }

}
