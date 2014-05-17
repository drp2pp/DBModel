package service.dao;

import java.util.List;

import service.domain.Beacon;


public interface TourDao {

	public List<Object> getLocalInfo() throws Exception;		//지역정보 가져오기
	
	public List<Object> getDataByLocal(int localNo) throws Exception;	//지역정보로 관련 데이터 가져오기
	public List<Object> getDataByBeacon(int regionNo) throws Exception;	//비콘정보로 관련 데이터 가져오기
	
	public Beacon findBeacon(Beacon beacon) throws Exception;	//가져온 Beacon의 정보와 동일한 Beacon정보를 그대로 리턴, 없을때는 Null이겠지
	//public void updateRegionInfo(String managerId) throws Exception;
	
}
