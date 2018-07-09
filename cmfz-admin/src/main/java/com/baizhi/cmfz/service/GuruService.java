package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Guru;

import java.util.List;

/**
 * Created by Lee on 2018/7/6.
 */
public interface GuruService {
    /**
     * 添加一个上师
     * @param guru
     * @return
     */
    public Integer addGuru(Guru guru);

    /**
     * 修改上师的信息
     * @param guru
     * @return
     */
    public Integer modifyGuru(Guru guru);

    /**
     * 查询法师的数量
     * @return
     */
    public Integer queryCount();

    /**
     * 分页查询上师
     * @param begin
     * @param end
     * @return
     */
    public List<Guru> queryGurusOnPage(Integer begin, Integer end);

    /**
     * 条件查询法师的数量
     * @param guru
     * @return
     */
    public Integer queryCountByTrim(Guru guru);

    /**
     * 条件分页查询法师的数量
     * @param begin
     * @param end
     * @param guru
     * @return
     */
    public List<Guru> queryGurusByTrim(Integer begin, Integer end,Guru guru);

    /**
     * 通过id进行查询法师
     * @param id
     * @return
     */
    public Guru queryGuruById(String id);

    /**
     * 查询所有的上师用于POI导出
     * @return
     */
    public List<Guru> queryAll();

    /**
     * 批量插入POI导入的数据
     * @param gurus
     * @return
     */
    public Integer batchAdd(List<Guru> gurus);
}
