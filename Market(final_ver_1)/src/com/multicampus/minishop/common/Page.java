package com.multicampus.minishop.common;

public class Page {
	//Field
	private int pageSize;		//한 페이지에 표시되는 게시물수
	private int pageUnit;		//창 아래 표시되는 페이지 수
	private int startUnitPage;	//창 아래 표시되는 페이지 수의 첫번째
	private int endUnitPage;	//창 아래 표시되는 페이지 수의 마지막
	private int currentPage;	//현재 페이지
	private int totalPage;		//총 페이지 수
	private int totalCount;		//총 게시물 수
	
	///Constructor
	public Page() {
	}
	public Page( int currentPage, int totalCount,	int pageUnit, int pageSize ) {
		this.totalCount = totalCount;
		this.pageUnit = pageUnit;
		this.pageSize = pageSize;
		
		this.totalPage = (totalCount%pageSize == 0) ? totalCount/pageSize :  totalCount/pageSize +1;
		this.currentPage = ( currentPage > totalPage) ? totalPage : currentPage;
		
		this.startUnitPage = ( (currentPage-1) / pageUnit ) * pageUnit +1 ;
		
		if( totalPage <= pageUnit ){
			this.endUnitPage = totalPage;
		}else{
			this.endUnitPage = startUnitPage + (pageUnit -1);
			if( totalPage <= endUnitPage){
				this.endUnitPage = totalPage;
			}
		}
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageUnit() {
		return pageUnit;
	}
	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}
	public int getStartUnitPage() {
		return startUnitPage;
	}
	public void setStartUnitPage(int startUnitPage) {
		this.startUnitPage = startUnitPage;
	}
	public int getEndUnitPage() {
		return endUnitPage;
	}
	public void setEndUnitPage(int endUnitPage) {
		this.endUnitPage = endUnitPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", totalCount="
		+ totalCount + ", pageUnit=" + pageUnit + ", pageSize="
		+ pageSize + ", totalPage=" + totalPage + ", startUnitPage="
		+ startUnitPage + ", endUnitPage=" + endUnitPage + "]";
	}
	
}
