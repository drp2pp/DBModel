package service;

import java.util.List;

import service.domain.Beacon;


public interface TourDao {

	public List<Object> getLocalInfo() throws Exception;
	
	public List<Object> getDataByLocal(int localNo) throws Exception;
	public List<Object> getDataByBeacon(int regionNo) throws Exception;
	
	public Beacon findBeacon(Beacon beacon) throws Exception;	//가져온 Beacon의 정보와 동일하면 true? Beacon?
	//public void updateRegionInfo(String managerId) throws Exception;
	
}
