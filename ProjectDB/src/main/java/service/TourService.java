package service;

import java.util.List;

import service.domain.Beacon;

public interface TourService {
	
	public List<Object> getLocalInfo() throws Exception;		
	
	public List<Object> getDataByLocal(int localNo) throws Exception;	
	public List<Object> getDataByBeacon(int regionNo) throws Exception;	
	
	public Beacon findBeacon(Beacon beacon) throws Exception;	
	//public void updateRegionInfo(String managerId) throws Exception;
	
}
