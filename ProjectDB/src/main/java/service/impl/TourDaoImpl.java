package service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import service.TourDao;
import service.domain.Beacon;

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
	public List<Object> getLocalInfo() throws Exception {
		return sqlSession.selectList("Mapper.getLocalInfo");
	}

	@Override
	public List<Object> getDataByLocal(int localNo) throws Exception {
		return sqlSession.selectList("Mapper.getDataByLocal", localNo);
	}

	@Override
	public List<Object> getDataByBeacon(int regionNo) throws Exception {
		return sqlSession.selectList("Mapper.getDataByBeacon", regionNo);
	}

	@Override
	public Beacon findBeacon(Beacon beacon) throws Exception {
		return sqlSession.selectOne("Mapper.findBeacon", beacon);
	}

}
