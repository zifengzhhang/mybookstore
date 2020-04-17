package com.study.bean;

import java.util.List;

import org.junit.Test;

public class Page<T> {
	//当前是第几页   通过参数传递
	private int pageNo;
	
	//每页显示几条信息
	private static final int PAGESIZE = 4;
	
	//总页数     计算得出
	private int totalPage;
	
	//总记录数    查询得到
	private int totalRecord;
	
	//封装了分页信息
	private List<T> pageData;
	
	//从哪个索引开始查询   计算得出
	private int index;
	
	//判断是否有下一页
	private boolean hasNext;
	
	//判断是否有上一页
	private boolean hasPrev;
	
	private String url;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		pageNo = pageNo>0?pageNo:1;
		pageNo = pageNo>getTotalPage()?getTotalPage():pageNo;
		this.pageNo = pageNo;
	}

	public int getTotalPage() {
		int pageCount = getTotalRecord()/PAGESIZE;
		if ( !(getTotalRecord()%PAGESIZE == 0 )) {
			pageCount++;
		}
		return pageCount;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<T> getPageData() {
		return pageData;
	}

	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}

	public int getIndex() {
		int i = (getPageNo()-1) * PAGESIZE;
		if ( i<0 ) i=0;
		return i;
	}

	public boolean isHasNext() {
		return getPageNo() < getTotalPage();
	}

	public boolean isHasPrev() {
		return getPageNo() > 1 ;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static int getPagesize() {
		return PAGESIZE;
	}

	public Page(int pageNo, int totalPage, int totalRecord, List<T> pageData, int index, boolean hasNext,
			boolean hasPrev, String url) {
		super();
		this.pageNo = pageNo;
		this.totalPage = totalPage;
		this.totalRecord = totalRecord;
		this.pageData = pageData;
		this.index = index;
		this.hasNext = hasNext;
		this.hasPrev = hasPrev;
		this.url = url;
	}

	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
