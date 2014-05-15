package com.multicampus.minishop.common;

public class Page {
	//Field
	private int pageSize;		//�� �������� ǥ�õǴ� �Խù���
	private int pageUnit;		//â �Ʒ� ǥ�õǴ� ������ ��
	private int startUnitPage;	//â �Ʒ� ǥ�õǴ� ������ ���� ù��°
	private int endUnitPage;	//â �Ʒ� ǥ�õǴ� ������ ���� ������
	private int currentPage;	//���� ������
	private int totalPage;		//�� ������ ��
	private int totalCount;		//�� �Խù� ��
	
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
