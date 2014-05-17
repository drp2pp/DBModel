package service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import service.TourDao;
import service.TourService;
import service.domain.Beacon;

@Repository("tourServiceImpl")
public class TourServiceImpl implements TourService {
	
	///Field
	@Autowired
	@Qualifier("tourDaoImpl")
	TourDao tourDao;
	public void setTourDao (TourDao tourDao){
		this.tourDao = tourDao;
	}
	
	///Constructor
	public TourServiceImpl(TourDao tourDao) {
		super();
		this.tourDao = tourDao;
	}

	///Method
	@Override
	public List<Object> getLocalInfo() throws Exception {
		return tourDao.getLocalInfo();
	}
	@Override
	public List<Object> getDataByLocal(int localNo) throws Exception {
		return tourDao.getDataByLocal(localNo);
	}

	@Override
	public List<Object> getDataByBeacon(int regionNo) throws Exception {
		return tourDao.getDataByBeacon(regionNo);
	}

	@Override
	public Beacon findBeacon(Beacon beacon) throws Exception {
		return tourDao.findBeacon(beacon);
	}

}
