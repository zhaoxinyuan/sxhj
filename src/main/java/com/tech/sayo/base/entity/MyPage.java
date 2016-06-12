package com.tech.sayo.base.entity;

import java.util.List;

import com.github.pagehelper.PageInfo;

public class MyPage<T> {

	private Integer current;
	private Integer rowCount;
	private List<T> rows;
	private long total;

	public Integer getCurrent() {
		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MyPage init(List<T> list) {
		PageInfo page = new PageInfo(list);
		MyPage mypage = new MyPage();
		mypage.setTotal(page.getTotal());
		mypage.setRowCount(page.getPageSize());
		mypage.setCurrent(page.getPageNum());
		mypage.setRows(list);
		return mypage;
	}

}
