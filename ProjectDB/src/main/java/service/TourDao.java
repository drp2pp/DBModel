package service;

import java.util.List;

import service.domain.Beacon;
import service.domain.Data;
import service.domain.Local;

public interface TourDao {

	public List<Local> getLocalInfo() throws Exception;		//�������� ��������
	
	public List<Data> getDataByLocal(int localNo) throws Exception;	//���������� ���� ������ ��������
	public List<Data> getDataByBeacon(int regionNo) throws Exception;	//���������� ���� ������ ��������
	
	public Beacon findBeacon(Beacon beacon) throws Exception;	//������ Beacon�� ������ ������ Beacon������ �״�� ����, �������� Null�̰���
	//public void updateRegionInfo(String managerId) throws Exception;
	
}
