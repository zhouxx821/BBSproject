package com.controller;

import com.util.JsonGet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping(value="/file",produces = {"text/plain;charset=UTF-8"})
public class FileUploadController {
    @RequestMapping(value = "/upload",headers = "content-type=multipart/*", method = RequestMethod.POST)
    public void upload(HttpServletRequest request, HttpServletResponse response, @RequestPart("uploadFile") MultipartFile file) throws Exception {
        Map map=new HashMap();
        if (!file.isEmpty()) {
            String path = request.getSession().getServletContext().getRealPath("upload");
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            file.transferTo(new File(path + File.separator + filename));
            map.put("file",path+File.separator+filename);
            JsonGet.backString(map,response);
        }
        else{
            map.put("error","未发送文件");
        }
    }
    @RequestMapping(value = "/uploads",headers = "content-type=multipart/*", method = RequestMethod.POST)
    public void uploads(HttpServletRequest request, HttpServletResponse response, @RequestPart("uploadFile") MultipartFile[] file) throws Exception {
        Map result = new HashMap();
        List<String> list=new ArrayList<>();
        for (MultipartFile multipartFile:file) {

            if (!multipartFile.isEmpty()) {
                String path = request.getSession().getServletContext().getRealPath("uploads");
                String filename = multipartFile.getOriginalFilename();
                File filepath = new File(path, filename);
                if (!filepath.getParentFile().exists()) {
                    filepath.getParentFile().mkdirs();
                }
                multipartFile.transferTo(new File(path + File.separator + filename));
                list.add(path+File.separator+filename);
            }

        }
        result.put("result",list);
        JsonGet.backString(result,response);
    }
}
