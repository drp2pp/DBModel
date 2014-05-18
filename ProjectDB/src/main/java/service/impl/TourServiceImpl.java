package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import service.TourDao;
import service.TourService;
import service.domain.Beacon;
import service.domain.Data;
import service.domain.Local;

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
	public TourServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	///Method
	@Override
	public List<Local> getLocalInfo() throws Exception {
		List<Local> list = tourDao.getLocalInfo();
		return list;
	}
	
	@Override
	public List<Data> getDataByLocal(int localNo) throws Exception {
		return tourDao.getDataByLocal(localNo);
	}

	@Override
	public List<Data> getDataByBeacon(int regionNo) throws Exception {
		return tourDao.getDataByBeacon(regionNo);
	}

	@Override
	public Beacon findBeacon(Beacon beacon) throws Exception {
		return tourDao.findBeacon(beacon);
	}

}
