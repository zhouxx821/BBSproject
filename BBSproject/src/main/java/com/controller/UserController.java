package com.controller;

import com.entity.Comment;
import com.entity.Post;
import com.entity.User;
import com.service.Impl.PostServiceImpl;
import com.service.Impl.UserServiceImpl;
import com.util.JsonGet;
import com.util.Message;
import com.util.NumberUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@CrossOrigin
@RequestMapping(value="/user",produces = {"text/plain;charset=UTF-8"})
public class UserController {
    public static Log log = LogFactory.getLog(ManagerController.class);
    @PostMapping("/register")
    @ResponseBody
        public void register(@RequestBody User user,HttpServletResponse response) throws SQLException, IOException {
         UserServiceImpl usi=new UserServiceImpl();
         Map map = new HashMap();
         int status=usi.register(user);
         map.put("msg",Message.addUser01(status));
         map.put("status",Message.addUser02(status));
        JsonGet.backString(map,response);
        }
    @PostMapping("/login")
    public void login(@RequestBody User user, HttpServletResponse response) throws IOException, SQLException {
        Map map = new HashMap();
        UserServiceImpl usi=new UserServiceImpl();
        PostServiceImpl psi=new PostServiceImpl();
        List<Integer> list=usi.login(user);
        if(list.size()==1)
            map.put("msg",Message.login(-1));
        else
        {
            map.put("msg",Message.login(list.get(1)));
            map.put("utype",list.get(0));
            if(list.get(0)==2) {
                map.put("areaName", psi.getName(list.get(3)));
                map.put("areaId",list.get(3));
            }
            map.put("id",list.get(1));
            map.put("status code",list.get(2));
            map.put("status",Message.status(list.get(2)));
        }
        JsonGet.backString(map,response);
    }
    @PostMapping("/retainLogin")
    public void retainLogin(@RequestBody User user, HttpServletResponse response) throws IOException, SQLException {
        Map map=new HashMap();
        UserServiceImpl usi=new UserServiceImpl();
        NumberUtil nu=new NumberUtil();
        Date d=new Date();
        SimpleDateFormat sbf=new SimpleDateFormat("dd");
        String ct=sbf.format(d);
        String token=nu.getNewToken(ct,user.getUid());
        int status=usi.updateToken(user.getUid(),token);
        map.put("token",token);
        map.put("status",status);
        JsonGet.backString(map,response);
    }
    @GetMapping("/getInfo")
    public void getInfo(@RequestParam("id")int id, HttpServletResponse response) throws IOException {
        UserServiceImpl usi=new UserServiceImpl();
        Map map=new HashMap();
        User user=usi.getInfo(id);
        map.put("info",user);
        map.put("status_message",Message.allUser(user));
        JsonGet.backString(map,response);
    }
    @PostMapping("/modify")
    public void modify(@RequestBody User user, HttpServletResponse response) throws IOException {
        UserServiceImpl usi=new UserServiceImpl();
        Map map = new HashMap();
        int status=usi.modify(user);
        map.put("msg",Message.post(status));
        map.put("status",status);
        JsonGet.backString(map,response);
    }
    @PostMapping("/post")
    public void post(@RequestBody Post post, HttpServletResponse response) throws IOException {
        Map map = new HashMap();
        Date d=new Date();
        SimpleDateFormat sbf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTimeString=sbf.format(d);
        post.setPubtime(currentTimeString);
        UserServiceImpl usi=new UserServiceImpl();
        PostServiceImpl psi=new PostServiceImpl();
        int tid=psi.getTid(post.getName());
        post.setTid(tid);
        int status=usi.addPost(post);
        map.put("msg",Message.post(status));
        map.put("status",status);
        JsonGet.backString(map,response);
    }
    @GetMapping("/allMyPost")
    public void allPost(@RequestParam("id")int id, HttpServletResponse response) throws IOException {
        UserServiceImpl usi=new UserServiceImpl();
        Map map=new HashMap();
        List<Post> list=usi.allMyPost(id);
        map.put("post_list",list);
        map.put("status",Message.allUser(list));
        JsonGet.backString(map,response);
    }
    @GetMapping("/deletePost")
    public void deletePost(@RequestParam("id")int id, HttpServletResponse response) throws IOException {
        UserServiceImpl usi=new UserServiceImpl();
        Map map=new HashMap();
        int status=usi.deletePost(id);
        map.put("msg",Message.banUser(status));
        map.put("status",status);
        JsonGet.backString(map,response);
    }
    @PostMapping("/addComment")
    public void addComment(@RequestBody Comment comment, HttpServletResponse response) throws IOException {
        Date d=new Date();
        SimpleDateFormat sbf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTimeString=sbf.format(d);
        comment.setPubtime(currentTimeString);
        UserServiceImpl usi=new UserServiceImpl();
        PostServiceImpl psi=new PostServiceImpl();
        int status=usi.addComment(comment);
        psi.addLikes(comment.getPid());
        Map map=new HashMap();
        map.put("msg",Message.banUser(status));
        map.put("status",status);
        JsonGet.backString(map,response);
    }
    @GetMapping("getMyComments")
    public void getMyComments(@RequestParam("id")int id, HttpServletResponse response) throws IOException {
        UserServiceImpl usi=new UserServiceImpl();
        Map map = new HashMap();
        map.put("comment", usi.getMyComment(id));
        JsonGet.backString(map,response);
    }
}
