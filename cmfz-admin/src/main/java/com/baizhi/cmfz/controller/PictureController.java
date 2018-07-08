package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Lee on 2018/7/5.
 */
@Controller
@RequestMapping("/pic")
public class PictureController {
    @Autowired
    private PictureService ps;

    @RequestMapping("/showAllPicture")
    public @ResponseBody Map<String, Object> showAllPicture(Integer page,Integer rows){
        return ps.queryAll(page, rows);
    }

    @RequestMapping("/removepicture")
    public @ResponseBody String removePicture(String pictureId){
        String message = "";
        Integer integer = ps.removePictureById(pictureId);
        if(integer>0){
            message = "successful";
        }else{
            message = "filed";
        }
        return message;
    }

    @RequestMapping("/update")
    public @ResponseBody String update(MultipartFile myFile,Picture picture,HttpSession session){
        String message = "";
        if(myFile == null){
            return message;
        }
        ServletContext sc =  session.getServletContext();
        String path1 = sc.getRealPath("");
        int i = path1.lastIndexOf("\\");
        String path3 = path1.substring(0,i);
        String path = path3+"\\upload";
        String fileName = myFile.getOriginalFilename();
        String suffix = fileName.substring( fileName.lastIndexOf(".") );
        String newName = UUID.randomUUID().toString().replace("-", "");
        System.out.println("newName-----"+newName);
        picture.setPicturePath(newName+suffix);
        //picture.setPictureName(newName);
        picture.setPictureDate(new Date());
        Integer integer = ps.modifyPicture(picture);
        if(integer>0){
            message = "successful";
        }else{
            message = "filed";
        }
        return message;
    }

    @RequestMapping("/upload")
    public @ResponseBody String upload(MultipartFile myFile, HttpSession session,Picture picture) throws IOException {
        String message = "";
        ServletContext sc =  session.getServletContext();
        String path1 = sc.getRealPath("");
        int i = path1.lastIndexOf("\\");
        String path3 = path1.substring(0,i);
        String path = path3+"\\upload";
        String fileName = myFile.getOriginalFilename();
        String suffix = fileName.substring( fileName.lastIndexOf(".") );
        String newName = UUID.randomUUID().toString().replace("-", "");
        picture.setPictureId(newName);
        picture.setPicturePath(fileName);
        //picture.setPictureName(newName);
        picture.setPictureDate(new Date());
        System.out.println("要插入的数据为："+picture);
        Integer integer = ps.addPicture(picture);
        System.out.println("受影响的行数为：  "+integer);
        if(integer>0){
            myFile.transferTo(new File(path+"/"+newName+suffix));
            message = "successful";
        }else{
            message = "filed";
        }
        return message;
    }
}
