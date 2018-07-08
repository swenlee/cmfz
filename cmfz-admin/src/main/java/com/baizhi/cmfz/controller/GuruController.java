package com.baizhi.cmfz.controller;

/*
import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
*/
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;

import com.alibaba.fastjson.JSON;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Lee on 2018/7/6.
 */
@Controller
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService gs;

    @RequestMapping("/getallgurus")
    public @ResponseBody Map<String,Object> getAllGurus(Integer page, Integer rows){
        List<Guru> gurus = gs.queryGurusOnPage((page - 1) * rows, rows);
        int size = gs.queryCount();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",size);
        map.put("rows",gurus);
        return map;
    }

    @RequestMapping(value = "/queryguru",method = RequestMethod.POST)
    public @ResponseBody Guru queryGuru(String guruId){
        Guru guru = gs.queryGuruById(guruId);
        return guru;
    }

    @RequestMapping("/addguru")
    public @ResponseBody String addGuru(MultipartFile myFile, HttpSession session,Guru guru) throws IOException {
        String message = "";
        String newName = UUID.randomUUID().toString().replace("-", "");
        guru.setGuruId(newName);
        if(myFile.isEmpty()){
            message = "successful";
            return message;
        }
        ServletContext sc =  session.getServletContext();
        String path1 = sc.getRealPath("");
        int i = path1.lastIndexOf("\\");
        String path3 = path1.substring(0,i);
        String path = path3+"\\upload";

        String fileName = myFile.getOriginalFilename();
        String suffix = fileName.substring( fileName.lastIndexOf(".") );

        guru.setGuruPic(path);
        guru.setGuruPicName(newName+suffix);

        Integer integer = gs.addGuru(guru);
        if(integer>0){
            myFile.transferTo(new File(path+"/"+newName+suffix));
            message = "successful";
        }else{
            message = "filed";
        }
        return message;
    }

    @RequestMapping("/updateguru")
    public @ResponseBody String updateGuru(Guru guru,MultipartFile myFile)throws IOException{
        String message = "";
        if(!myFile.isEmpty()){
            myFile.transferTo(new File(guru.getGuruPic()+"/"+guru.getGuruPicName()));
        }
        Integer integer = gs.modifyGuru(guru);
        if(integer>0){
            message = "successful";
        }else{
            message = "filed";
        }
        return message;
    }

    @RequestMapping("/querytrim")
    public @ResponseBody Map<String,Object> queryGurusByTrim(Integer page, Integer rows, String trim, HttpServletRequest request) throws UnsupportedEncodingException {
        Guru guru = new Guru();
        String value = new String(request.getParameter("value").getBytes("ISO-8859-1"),"utf-8");
        if(trim.equals("guruName")){
            guru.setGuruName("%"+value+"%");
        }else if(trim.equals("guruSummary")){
            guru.setGuruSummary("%"+value+"%");
        }
        System.out.println(guru);
        List<Guru> gurus = gs.queryGurusByTrim((page - 1) * rows, rows,guru);
        int size = gs.queryCountByTrim(guru);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",size);
        map.put("rows",gurus);
        return map;
    }
    @RequestMapping("/export")
    public String exportExcel(ModelMap map){
        System.out.println("========================");
        //查询要导出的数据
        List<Guru> gurus = gs.queryAll();
        //定义要导出的类的类对象
        map.put(NormalExcelConstants.CLASS, Guru.class);
        //定义导出后的Excel文件名
        map.put(NormalExcelConstants.FILE_NAME,"上师表");
        //定义导出参数(包含表头和sheet名)
        ExportParams ep = new ExportParams("上师表", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        //push导出参数
        map.put(NormalExcelConstants.PARAMS, ep);
        //定义要导出的数据
        map.put(NormalExcelConstants.DATA_LIST,gurus);
        //提供固定的返回值
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
    }
    @RequestMapping(value="/importExcel",method = RequestMethod.POST)
    public @ResponseBody String importExcel(MultipartFile file,HttpServletRequest request) throws Exception{
        String message = "";
        if(file.isEmpty()){
            message = "field";
            return message;
        }
        ImportParams params = new ImportParams();
        //表格标题（默认为0） 但是如果设置标题，九设为一
        params.setTitleRows(1);
        //设置表头
        params.setHeadRows(1);
        //是否保存上传的Excel
        params.setNeedSave(true);
        String path1 = request.getSession().getServletContext().getRealPath("");
        int i = path1.lastIndexOf("\\");
        String path3 = path1.substring(0,i);
        String path = path3+"\\upload";

        File f = new File(path+"/excel"+file.getOriginalFilename());
        file.transferTo(f);
        List<Guru> gurus  = ExcelImportUtil.importExcel(f, Guru.class, params);
        /*for (Guru guru : gurus) {
            gs.addGuru(guru);
        }*/
        System.out.println(JSON.toJSONString(gurus));
        gs.batchAdd(gurus);
        message = "successful";
        return message;
    }
}