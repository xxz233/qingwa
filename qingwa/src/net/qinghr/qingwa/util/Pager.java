package net.qinghr.qingwa.util;

public class Pager {
	private int pageSize;//一页显示条数
	private int dataCount;//数据总条数
	private int pageNo;//第几页
	public int getPageCount()
	{
		return (dataCount-1)/getPageSize()+1;
	}
	public int getPageSize() {
		if(pageSize<=0){
			pageSize=10;
		}			
		return pageSize;		
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getDataCount() {
		return dataCount;
	}
	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}
	public int getPageNo() {
		if(pageNo<1) pageNo=1;
		if(pageNo>this.getPageCount()) pageNo=this.getPageCount();
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
}
