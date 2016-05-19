package com.ftc.base.dao;

import java.util.List;
import java.util.Map;
 
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

/** 
* @ClassName: BaseDao 
* @Description: 通用DAO
* @author Zo 
* @date 2016-4-1 下午3:31:50 
*  
*/
@Repository("baseDao")
public class BaseDaoImpl extends SqlSessionDaoSupport implements BaseDao {
    private Logger log4j = Logger.getLogger(BaseDaoImpl.class);
     
    //从spring注入原有的sqlSessionTemplate
    private SqlSessionTemplate sqlSessionTemplate;
    
    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }
 
    public <T> T getMapper(Class<T> clazz) {
        return getSqlSession().getMapper(clazz);
    }
 
    @SuppressWarnings("unchecked")
    public <T> List<T> selectList(String sqlid, Object paramObj) {
        return (List<T>) this.getSqlSession().selectList(sqlid, paramObj);
    }
 
    @SuppressWarnings("unchecked")
    public <T> List<T> selectList(String sqlid) {
        return (List<T>) this.getSqlSession().selectList(sqlid);
    }
    @SuppressWarnings("unchecked")
    public <T> List<T> selectList(String sqlid,Object paramObj,RowBounds arg3) {
        return (List<T>) this.getSqlSession().selectList(sqlid, paramObj, arg3);
    }
    @SuppressWarnings("unchecked")
    public <T> T selectOne(String sqlid) {
        return (T) this.getSqlSession().selectOne(sqlid);
    }
    @SuppressWarnings("unchecked")
    public <T> T selectOne(String sqlid, Object paramObj) {
        return (T) this.getSqlSession().selectOne(sqlid, paramObj);
    }
    @SuppressWarnings("rawtypes")
	public Map selectMap(String arg0,String arg1) {
        return this.getSqlSession().selectMap(arg0, arg1);
    }
    @SuppressWarnings("rawtypes")
	public Map selectMap(String arg0,Object arg1,String arg2) {
        return this.getSqlSession().selectMap(arg0, arg1, arg2);
    }
    @SuppressWarnings("rawtypes")
	public Map selectMap(String arg0,Object arg1,String arg2,RowBounds arg3) {
        return this.getSqlSession().selectMap(arg0, arg1, arg2, arg3);
    }
    public int remove(String sqlid) {
        return this.getSqlSession().delete(sqlid);
    }
     
    public int remove(String sqlid,Object paramObj) {
        return this.getSqlSession().delete(sqlid, paramObj);
    }
     
    public int insert(String sqlid,Object paramObj) {
        return this.getSqlSession().insert(sqlid, paramObj);
    }
    public int insert(String sqlid) {
        return this.getSqlSession().insert(sqlid);
    }
    public void select(String sqlid,ResultHandler arg1) {
        this.getSqlSession().select(sqlid, arg1);
    }
    public void select(String sqlid,Object paramObj,ResultHandler arg1) {
        this.getSqlSession().select(sqlid, paramObj,arg1);
    }
    public void select(String sqlid,Object paramObj,RowBounds arg3,ResultHandler arg1) {
        this.getSqlSession().select(sqlid,paramObj,arg3, arg1);
    }
     
    public int modify(String sqlid,Object paramObj) {
        return this.getSqlSession().update(sqlid, paramObj);
    }
    public int modify(String sqlid) {
        return this.getSqlSession().update(sqlid);
    }
 
    @SuppressWarnings({ "rawtypes", "null" })
	public void batchmodify(final String statementName, final List list)  throws DataAccessException{
        SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        try{
            if(null != list || list.size() > 0){
                int size = 10000;
             
                for (int i = 0, n = list.size(); i < n; i++) {
                    this.modify(statementName, list.get(i));
                    if (i % 1000 == 0 || i == size - 1) {
                        //手动每1000个一提交，提交后无法回滚
                        session.commit();
                        //清理缓存，防止溢出
                        session.clearCache();
                    }
                }
            }
        }catch (Exception e){
            session.rollback();
            if (log4j.isDebugEnabled()) {
                e.printStackTrace();
                log4j.debug("batchmodify error: id [" + statementName + "], parameterObject [" + list + "].  Cause: " + e.getMessage());
            }
        } finally {
            session.close();
        }
    }
    
    @SuppressWarnings({ "rawtypes", "null" })
    public void batchInsert(final String statementName, final List list)  throws DataAccessException{
 
        SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
         
        int size = 10000;
        try{
            if(null != list || list.size() > 0){
                for (int i = 0, n = list.size(); i < n; i++) {
                    this.insert(statementName, list.get(i));
                    if (i % 1000 == 0 || i == size - 1) {
                        //手动每1000个一提交，提交后无法回滚
                        session.commit();
                        //清理缓存，防止溢出
                        session.clearCache();
                    }
                }
            }
        }catch (Exception e){
            session.rollback();
            if (log4j.isDebugEnabled()) {
                e.printStackTrace();
                log4j.debug("batchInsert error: id [" + statementName + "], parameterObject [" + list + "].  Cause: " + e.getMessage());
            }
        } finally {
            session.close();
        }
    }
 
    @SuppressWarnings({ "rawtypes", "null" })
    public void batchremove(final String statementName, final List list)  throws DataAccessException{
        SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
         
        int size = 10000;
        try{
            if(null != list || list.size() > 0){
                for (int i = 0, n = list.size(); i < n; i++) {
                    this.remove(statementName, list.get(i));
                    if (i % 1000 == 0 || i == size - 1) {
                        //手动每1000个一提交，提交后无法回滚
                        session.commit();
                        //清理缓存，防止溢出
                        session.clearCache();
                    }
                }
            }
        }catch (Exception e){
            session.rollback();
            if (log4j.isDebugEnabled()) {
                e.printStackTrace();
                log4j.debug("batchremove error: id [" + statementName + "], parameterObject [" + list + "].  Cause: " + e.getMessage());
            }
        } finally {
            session.close();
        }
    }
}