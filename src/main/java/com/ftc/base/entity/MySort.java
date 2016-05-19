package com.ftc.base.entity;

import java.util.Map;

public class MySort {

	private Map<String, Object> sort;

	public Map<String, Object> getSort() {
		return sort;
	}

	public void setSort(Map<String, Object> sort) {
		this.sort = sort;
	}
	
	public String getSortSql(Map<String,String> sqlmap){
		if(this.sort == null) return "";
		StringBuffer sql = new StringBuffer();
		Object[] keys = this.sort.keySet().toArray();
		for (int i = 0; i < keys.length; i++) {
			for (Map.Entry<String,String> entry : sqlmap.entrySet()) {
				if(keys[i].equals(entry.getKey())){
					sql.append(entry.getValue() + " " + this.sort.get(keys[i]));
					if(i != keys.length -1 ){
						sql.append(",");
					}
				}
			}  
		}
		return sql.toString();
	}
	
	public static void main(String[] args) {
		
	}

}
