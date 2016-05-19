package com.ftc.base.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;

public interface BaseDao {

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate);
	
	public <T> T getMapper(Class<T> clazz);
	
	public <T> List<T> selectList(String sqlid, Object paramObj);
	
	public <T> List<T> selectList(String sqlid);
	
	public <T> List<T> selectList(String sqlid,Object paramObj,RowBounds arg3);
	
	public <T> T selectOne(String sqlid);
	
	public <T> T selectOne(String sqlid, Object paramObj);
	
	@SuppressWarnings("rawtypes")
	public Map selectMap(String arg0,String arg1);
	
	@SuppressWarnings("rawtypes")
	public Map selectMap(String arg0,Object arg1,String arg2);
	
	@SuppressWarnings("rawtypes")
	public Map selectMap(String arg0,Object arg1,String arg2,RowBounds arg3);
	
	public int remove(String sqlid);
	
    public int remove(String sqlid,Object paramObj);
    
    public int insert(String sqlid,Object paramObj);
    
    public int insert(String sqlid);
    
    public void select(String sqlid,ResultHandler arg1);
    
    public void select(String sqlid,Object paramObj,ResultHandler arg1);
    
    public void select(String sqlid,Object paramObj,RowBounds arg3,ResultHandler arg1);
    
    public int modify(String sqlid,Object paramObj);
    
    public int modify(String sqlid);
    
    @SuppressWarnings("rawtypes")
	public void batchmodify(final String statementName, final List list)  throws DataAccessException;
    
    @SuppressWarnings("rawtypes")
	public void batchInsert(final String statementName, final List list)  throws DataAccessException;
    
    @SuppressWarnings("rawtypes")
	public void batchremove(final String statementName, final List list)  throws DataAccessException;
}
