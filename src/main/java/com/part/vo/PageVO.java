package com.part.vo;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

import net.minidev.json.JSONUtil;

public class PageVO implements Serializable{

    private static final long serialVersionUID = 262351852171364750L;

    public static final Integer DEFAULT_PAGE_SIZE = 10;
    public static final Integer DEFAULT_PAGE_NUM = 1;
    
    private Integer pageNum = DEFAULT_PAGE_NUM;
    
    private Integer pageSize = DEFAULT_PAGE_SIZE;
    
    private Long startNum = 0l;
    
    private Long totalCount = 0l;
    
    private Long totalPage = 0l;
    
    private String orderByClause;
    
    private Object data;
    
    public PageVO() {
        super();
    }

    public PageVO(Integer pageNum, Integer pageSize, Long startNum) {
        super();
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.startNum = startNum;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getStartNum() {
        this.startNum = (pageNum - 1l) * pageSize;
        return this.startNum;
    }

    public void setStartNum(Long startNum) {
        this.startNum = startNum;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getTotalPage() {
        long totalPage = (long)Math.ceil((double)totalCount/(double)pageSize);
        this.totalPage = totalPage;
        return this.totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
