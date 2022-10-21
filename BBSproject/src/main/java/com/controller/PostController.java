package com.controller;

import com.entity.*;
import com.service.Impl.PostServiceImpl;
import com.util.JsonGet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping(value = "/post",produces = {"text/plain;charset=UTF-8"})
public class PostController {
    public static Log log = LogFactory.getLog(ManagerController.class);
    @PostMapping("/type")
    public void type(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PostServiceImpl psi=new PostServiceImpl();
        Map map = new HashMap();
        map.put("area_list", psi.type());
        JsonGet.backString(map,response);
    }
    @PostMapping("/getAllPosts")
    public void getAllPosts(@RequestBody Page page, HttpServletResponse response) throws IOException{
        PostServiceImpl psi=new PostServiceImpl();
        int rc=psi.getResultCount();
        page.setTotalRecord(rc);
        Map map = new HashMap();
        List<Post> list=psi.posts();
        map.put("resultCount",rc);
        map.put("totalPage", page.getTotalPage());
        map.put("startIndex",page.getStartIndex());
        map.put("post_list",list);
        JsonGet.backString(map,response);
    }
    @PostMapping("/getPosts")
    public void getPosts(@RequestBody Page page,HttpServletResponse response) throws IOException{
        PostServiceImpl psi=new PostServiceImpl();
        Map map = new HashMap();
        page.setTotalRecord(psi.getTypeResultCount(page.getId()));
        List<Post> list=psi.getPosts(page.getId());
        map.put("resultCount",psi.getTypeResultCount(page.getId()));
        map.put("totalPage", page.getTotalPage());
        map.put("startIndex",page.getStartIndex());
        map.put("post_list",list);
        map.put("name",psi.getName(page.getId()));
        JsonGet.backString(map,response);
    }
    @PostMapping("/getInfo")
    public void getInfo(@RequestBody Post post, HttpServletResponse response) throws IOException{
        PostServiceImpl psi=new PostServiceImpl();
        Map map = new HashMap();
        map.put("info", psi.getInfo(post.getId()));
        map.put("judge",psi.judgePost(post.getUid(),post.getId()));
        JsonGet.backString(map,response);
    }
    @GetMapping("/getComments")
    public void getComments(@RequestParam("id")int id, HttpServletResponse response) throws IOException{
        PostServiceImpl psi=new PostServiceImpl();
        Map map = new HashMap();
        map.put("comment", psi.getComments(id));
        JsonGet.backString(map,response);
    }
    @PostMapping("/deleteComments")
    public void deleteComments(@RequestBody Comment comment, HttpServletResponse response) throws IOException{
        PostServiceImpl psi=new PostServiceImpl();
        Map map = new HashMap();
        map.put("status",psi.deleteComment(comment.getId()));
        JsonGet.backString(map,response);
    }
    @GetMapping("/topPost")
    public void addPost(@RequestParam("id")int id, HttpServletResponse response) throws IOException{
        PostServiceImpl psi=new PostServiceImpl();
        Map map = new HashMap();
        map.put("status", psi.topPost(id));
        JsonGet.backString(map,response);
    }
    @GetMapping("/movePost")
    public void movePost(@RequestParam("id")int id,@RequestPart("tid")int tid,HttpServletResponse response) throws IOException{
        PostServiceImpl psi=new PostServiceImpl();
        Map map = new HashMap();
        int status=psi.movePost(id,tid);
        map.put("status", status);
        JsonGet.backString(map,response);
    }
    @PostMapping("/getHot")
    public void getHot(HttpServletResponse response) throws IOException{
        PostServiceImpl psi=new PostServiceImpl();
        Map map = new HashMap();
        List<Post> list=psi.getHot();
        map.put("list",list);
        JsonGet.backString(map,response);
    }
    @PostMapping("getTypeHot")
    public void getTypeHot(@RequestBody Area area, HttpServletResponse response) throws IOException{
        PostServiceImpl psi=new PostServiceImpl();
        Map map = new HashMap();
        List<Post> list=psi.getTypeHot(area.getId());
        map.put("list",list);
        JsonGet.backString(map,response);
    }
}
