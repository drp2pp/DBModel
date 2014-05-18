package service;

import java.util.List;
import java.util.Map;

import service.domain.Beacon;
import service.domain.Data;
import service.domain.Local;

public interface TourService {
	
	public List<Local> getLocalInfo() throws Exception;		
	
	public List<Data> getDataByLocal(int localNo) throws Exception;	
	public List<Data> getDataByBeacon(int regionNo) throws Exception;	
	
	public Beacon findBeacon(Beacon beacon) throws Exception;	
	//public void updateRegionInfo(String managerId) throws Exception;
	
}
