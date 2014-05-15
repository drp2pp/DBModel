package com.multicampus.minishop.services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class abstractDAO {
	//Field
	//Method
	protected void close(Connection con,PreparedStatement pStmt){
		try {
			if(con!=null){
				con.close();
			}
			if(pStmt!=null){
				pStmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void close(Connection con,PreparedStatement pStmt,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(con,pStmt);
	}
	
	
	/*
	protected String getCurrentPageSql(String sql,Search search){
		sql="select * from ( select i.*,rownum rn from ("+sql+") i where rownum<= "
				+search.getPage()*search.getPageSize()+") where rn between "
				+((search.getPage()-1)*search.getPageSize()+1)+" and "+search.getPage()*search.getPageSize();
		
		return sql;
	}
	*/
}
