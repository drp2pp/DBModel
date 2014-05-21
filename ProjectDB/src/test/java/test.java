import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.TourDao;
import service.TourService;
import service.domain.Beacon;
import service.domain.Data;
import service.domain.Local;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/commonservice.xml"})
public class test {
	
	@Autowired
	@Qualifier("tourServiceImpl")
	private TourService tourService;
	
	@Autowired
	@Qualifier("tourDaoImpl")
	private TourDao tourDao;
	
	@Value("#{dataProperties}") Map map;	//data.properties 파일의 모든값을 Map으로 저장
		
	//@Test
	public void testGetLocal() throws Exception{
		System.out.println(tourService.getLocalInfo());
	}
	
	@Test
	public void testGetDataByLocal() throws Exception{
				
		//광화문 클릭
		int localNo = tourService.getLocalInfo().get(0).getLocalNo(); //화면에서 지역클릭시 그 지역의 localNo 전송
		System.out.println("localNo : "+localNo);
		System.out.println("=================================");
		
		for (Data data : tourService.getDataByLocal(localNo)) {	//local에 해당되는 모든 데이터
			int dataNo = data.getDataNo();
			int dataType = data.getDataType();
			String dataPath = data.getDataPath();
			
			System.out.println("dataNo : " + dataNo);
			System.out.println("dataPath : " + dataPath);
			System.out.print("dataType : " + dataType );
			
			switch (dataType) {
			case 1:	//DataType : Text
				System.out.println(" Text");
				System.out.println(dataPath + " : " + map.get(dataPath));
				break;
			case 2:	//DataType : Image
				System.out.println(" Image");
				dataPath = "upfolder/image/"+dataPath;
				System.out.println(dataPath);
				break;
			case 3:	//DataType : Voice
				System.out.println(" Voice");
				dataPath = "upfolder/voice/"+dataPath;
				System.out.println(dataPath);
				break;
			case 4:	//DataType : VOD
				System.out.println(" VOD");
				dataPath = "upfolder/vod/"+dataPath;
				System.out.println(dataPath);
				break;
			default:
				break;
			}
		}
	}
	
	//@Test
	public void testGetBeacon() throws Exception{
		Beacon beacon = new Beacon();
		beacon.setUuid("8492e75f-4fd6-469d-b132-043-fe94921d8");
		beacon.setMajor(11305);
		beacon.setMinor(19481);
		System.out.println(tourService.findBeacon(beacon));
	}
	
	//@Test
	public void testGetDataByRegion() throws Exception{
		Beacon beacon = new Beacon();
		beacon.setUuid("8492e75f-4fd6-469d-b132-043-fe94921d8");
		beacon.setMajor(11305);
		beacon.setMinor(19481);
		System.out.println(tourService.getDataByBeacon(beacon));
	}
		
}
