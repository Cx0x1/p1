package com.cxx.entity;

import java.util.List;

/*
 *  ��ҳ��Ҫ���ظ�ҳ�����������
 * */
public class PageBean {
    private List<Student> list;//�û��뿴����Ϣ   ͨ�����������ͷ�ҳ������ѯ���ݵõ���
    private int currentPage;//��ǰҳ  ҳ�洫��
    private int pageSize;//ÿҳ��ʾ����  ҳ�洫��
    private int totalCount;//������   ͨ���������� ��ѯ���ݿ�õ�
    private int totalPage;//��ҳ��   ͨ����������ÿҳ��ʾ��������

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
