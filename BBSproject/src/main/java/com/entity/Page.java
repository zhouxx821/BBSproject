package com.entity;

public class Page {
    private int id;
    private int pageSize;
    private int CurrentPage;
    private int totalRecord;
    private int totalPage;
    private int startIndex;
    public Page(int ps,int cp,int tr){
        this.pageSize=ps;
        this.CurrentPage=cp;
        this.totalRecord=tr;
        this.totalPage=(tr+ps-1)/ps;
        if(tr%ps!=0)
            this.totalPage++;
        this.startIndex = (cp-1)*ps;
    }

    public int getId() {
        return id;
    }

    public int getCurrentPage() {
        return CurrentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setCurrentPage(int currentPage) {
        CurrentPage = currentPage;
    }

    public void setPageSize(int pageSize) {
        pageSize = pageSize;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }
}
