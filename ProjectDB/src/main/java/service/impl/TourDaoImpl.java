package service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import service.TourDao;
import service.domain.Beacon;
import service.domain.Data;
import service.domain.Local;

@Repository("tourDaoImpl")
public class TourDaoImpl implements TourDao {
	
	///Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
		
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession = sqlSession;
	}
	
	///Constructor
	public TourDaoImpl() {
		super();
	}
	
	///Method
	@Override
	public List<Local> getLocalInfo() throws Exception {
		return sqlSession.selectList("Mapper.getLocalInfo");
	}

	@Override
	public List<Data> getDataByLocal(int localNo) throws Exception {
		return sqlSession.selectList("Mapper.getDataByLocal", localNo);
	}

	@Override
	public List<Data> getDataByBeacon(Beacon beacon) throws Exception {
		return sqlSession.selectList("Mapper.getDataByBeacon", beacon);
	}

	@Override
	public Beacon findBeacon(Beacon beacon) throws Exception {
		return sqlSession.selectOne("Mapper.findBeacon", beacon);
	}

	@Override
	public void addData(Data data) throws Exception {	
		sqlSession.insert("Mapper.insertData", data);
	}
	
	

}
