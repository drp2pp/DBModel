package service;

import java.util.List;

import service.domain.Beacon;
import service.domain.Data;
import service.domain.Local;

public interface TourDao {

	public List<Local> getLocalInfo() throws Exception;		//지역정보 가져오기
	
	public List<Data> getDataByLocal(int localNo) throws Exception;	//지역정보로 관련 데이터 가져오기
	public List<Data> getDataByBeacon(Beacon beacon) throws Exception;	//비콘정보로 관련 데이터 가져오기
	
	public Beacon findBeacon(Beacon beacon) throws Exception;	//가져온 Beacon의 정보와 동일한 Beacon정보를 그대로 리턴, 없을때는 Null이겠지
	//public void updateRegionInfo(String managerId) throws Exception;
	
	public void addData(Data data) throws Exception;
	
}
