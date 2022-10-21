package com.controller;

import com.entity.Area;
import com.entity.User;
import com.service.Impl.ManagerServiceImpl;
import com.service.Impl.PostServiceImpl;
import com.util.JsonGet;
import com.util.Message;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping(value="/admin",produces = {"text/plain;charset=UTF-8"})
public class ManagerController {
    public static Log log = LogFactory.getLog(ManagerController.class);
    @PostMapping("/allUsers")
    public void allUsers(@RequestBody User user, HttpServletResponse response) throws IOException, SQLException {
        ManagerServiceImpl msi=new ManagerServiceImpl();
        Map map = new HashMap();
        if(msi.judgeM(user.getTel(),user.getPwd())!=null)
        {
            List<User> list =msi.allUsers();
            map.put("list", list);
            map.put("status",Message.allUser(list));
        }
        JsonGet.backString(map,response);
    }
    @GetMapping("/banUser")
    public void banUser(@RequestParam("id")int id,HttpServletResponse response)throws IOException{
        ManagerServiceImpl msi=new ManagerServiceImpl();
        Map map=new HashMap();
        int status=msi.banUser(id);
        map.put("status",Message.banUser(status));
        map.put("status_code",status);
        JsonGet.backString(map,response);
    }
    @GetMapping("/release")
    public void release(@RequestParam("id")int id,HttpServletResponse response)throws IOException{
        ManagerServiceImpl msi=new ManagerServiceImpl();
        Map map=new HashMap();
        int status=msi.release(id);
        map.put("status",Message.banUser(status));
        map.put("status_code",status);
        JsonGet.backString(map,response);
    }
    @GetMapping("/addType")
    public void addType(@RequestParam("name")String name,HttpServletResponse response)throws IOException{
        ManagerServiceImpl msi=new ManagerServiceImpl();
        Map map=new HashMap();
        int status=msi.addType(name);
        map.put("status",status);
        JsonGet.backString(map,response);
    }
    @GetMapping("/deleteType")
    public void deleteType(@RequestParam("name")String name,HttpServletResponse response)throws IOException{
        ManagerServiceImpl msi=new ManagerServiceImpl();
        PostServiceImpl psi=new PostServiceImpl();
        int id=psi.getTid(name);
        Map map=new HashMap();
        int status=msi.deleteType(name,id);
        map.put("status",status);
        JsonGet.backString(map,response);
    }
    @GetMapping("setPoster")
    public void setPoster(@RequestParam("id")int id, @RequestParam("uid")int uid, HttpServletResponse response)throws IOException{
        ManagerServiceImpl msi=new ManagerServiceImpl();
        int status=msi.setPoster(uid,id);
        Map map=new HashMap();
        map.put("status",Message.banUser(status));
        map.put("status_code",status);
        JsonGet.backString(map,response);
    }
}
