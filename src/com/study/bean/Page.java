package com.study.bean;

import java.util.List;

import org.junit.Test;

public class Page<T> {
	//��ǰ�ǵڼ�ҳ   ͨ����������
	private int pageNo;
	
	//ÿҳ��ʾ������Ϣ
	private static final int PAGESIZE = 4;
	
	//��ҳ��     ����ó�
	private int totalPage;
	
	//�ܼ�¼��    ��ѯ�õ�
	private int totalRecord;
	
	//��װ�˷�ҳ��Ϣ
	private List<T> pageData;
	
	//���ĸ�������ʼ��ѯ   ����ó�
	private int index;
	
	//�ж��Ƿ�����һҳ
	private boolean hasNext;
	
	//�ж��Ƿ�����һҳ
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
