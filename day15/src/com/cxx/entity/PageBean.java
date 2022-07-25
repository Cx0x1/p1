package com.cxx.entity;

import java.util.List;

/*
 *  分页中要返回给页面的所有数据
 * */
public class PageBean {
    private List<Student> list;//用户想看的信息   通过搜索条件和分页参数查询数据得到的
    private int currentPage;//当前页  页面传递
    private int pageSize;//每页显示条数  页面传递
    private int totalCount;//总条数   通过搜索条件 查询数据库得到
    private int totalPage;//总页数   通过总条数与每页显示条件技术

    public PageBean() {
    }

    public PageBean(List<Student> list, int currentPage, int pageSize, int totalCount, int totalPage) {
        this.list = list;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
