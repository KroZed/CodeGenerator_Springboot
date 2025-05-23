package com.prj.util;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.ArrayList;
public class PagedData {
    private long pageSize;
    private long pageNo;
    private long pageIndex;
    private long pageCount;
    private long filtered;
    private long recordsFiltered;
    private long total;
    private long recordsTotal;
    private long recordCount;
    private Object data = new ArrayList<>();
    public PagedData() {}
    public <T> PagedData(IPage<T> data)
    {
        this(data.getRecords(),data.getTotal(),data.getRecords().size(),data.getCurrent(),data.getPages(),data.getSize());
    }
    public PagedData(Object data,long recordCount,long recordsFiltered,long pageNo, long pageCount, long pageSize)
    {
        setRecordsFiltered(recordsFiltered);
        setRecordCount(recordCount);
        setPageNo(pageNo);
        setPageCount(pageCount);
        setPageSize(pageSize);
        this.data = data;
    }
    public long getPageSize() { return pageSize; }
    public void setPageSize(long pageSize) { this.pageSize = pageSize;}
    public long getPageNo() { return pageNo; }
    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
        this.pageIndex = pageNo;
    }
    public long getPageIndex() { return pageIndex;}
    public void setPageIndex(long pageIndex) {
        this.pageIndex = pageIndex;
        this.pageNo = pageIndex;
    }
    public long getPageCount() { return pageCount;}
    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }
    public long getRecordCount() { return recordCount; }
    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
        this.total = recordCount;
        this.recordsTotal = recordCount;
    }
    public long getTotal() {
        return this.total;
    }
    public void setTotal(long total) {
        this.total = total;
        this.recordCount = total;
        this.recordsTotal = total;
    }
    public long getRecordsTotal() {
        return recordsTotal;
    }
    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
        this.total = recordsTotal;
        this.recordCount = recordsTotal;
    }
    public long getFiltered() {
        return this.getRecordsFiltered();
    }
    public void setFiltered(long filtered) {
        this.filtered = filtered;
        this.recordsFiltered = filtered;
    }
    public long getRecordsFiltered() {
        return recordsFiltered;
    }
    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
        this.filtered = recordsFiltered;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
}
