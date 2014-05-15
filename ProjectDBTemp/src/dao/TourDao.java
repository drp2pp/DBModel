package dao;

import java.util.List;

import domain.Beacon;
import domain.Local;

public interface TourDao {

	public List<Object> getLocalInfo() throws Exception;
	public void insertLocalInfo(Local local) throws Exception;
	public void updateLocalInfo(Local local) throws Exception;
	public void deleteLocalInfo(int localNo) throws Exception;
	
	public List<Object> getDataByLocal(int localNo) throws Exception;
	public List<Object> getDataByBeacon(int regionNo) throws Exception;
	
	public Boolean findRegionInfo(Beacon beacon) throws Exception;	//가져온 Beacon의 정보와 동일하면 true? Beacon?

}
