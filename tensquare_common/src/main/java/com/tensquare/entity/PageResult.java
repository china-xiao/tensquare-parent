package com.tensquare.entity;

import java.util.List;

/**
 * @Description： TODO PageResult ，用于返回分页结果
 * @Author: xiaoxinghua
 * @Date: Created in 2019/12/10 16:56
 * @Version: 0.0.1
 **/
public class PageResult<T> {
    private Long total;
    private List<T> rows;

    public PageResult(Long  total,  List<T>  rows)  {
        super();
        this.total  =  total;
        this.rows  =  rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
