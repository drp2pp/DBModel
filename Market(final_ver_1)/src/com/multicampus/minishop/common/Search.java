package com.multicampus.minishop.common;

public class Search {
	
	private int page;
	private String searchCondition;
	private String searchKeyword;
	private int pageSize;
	private int startRowNum;
	private int endRowNum;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * 0 - Search by Product Number.<p>
	 * 1 - Search by Product Name.<p>
	 * 2 - Search by Price.
	 */
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public int getStartRowNum() {
		return (page-1)*pageSize+1;
	}
	public int getEndRowNum() {
		return page*pageSize;
	}
}
