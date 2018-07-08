package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Guru;

import java.util.List;

/**
 * Created by Lee on 2018/7/6.
 */
public interface GuruService {
    public Integer addGuru(Guru guru);

    public Integer modifyGuru(Guru guru);

    public Integer queryCount();

    public List<Guru> queryGurusOnPage(Integer begin, Integer end);

    public Integer queryCountByTrim(Guru guru);

    public List<Guru> queryGurusByTrim(Integer begin, Integer end,Guru guru);

    public Guru queryGuruById(String id);

    public List<Guru> queryAll();

    public Integer batchAdd(List<Guru> gurus);
}
