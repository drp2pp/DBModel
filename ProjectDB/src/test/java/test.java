import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.TourDao;
import service.TourService;
import service.domain.Beacon;
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
	
	@Test
	public void testGetLocal() throws Exception{
		System.out.println(tourService.getLocalInfo());
	}
	
	@Test
	public void testGetDataByLocal() throws Exception{
		System.out.println("localNo : "+tourService.getLocalInfo().get(0).getLocalNo());
		System.out.println(tourService.getDataByLocal(tourService.getLocalInfo().get(1).getLocalNo()));
	}
	
	@Test
	public void testGetBeacon() throws Exception{
		Beacon beacon = new Beacon();
		beacon.setUuid("8492e75f-4fd6-469d-b132-043-fe94921d8");
		beacon.setMajor(11305);
		beacon.setMinor(19481);
		System.out.println(tourService.findBeacon(beacon));
	}
	
	@Test
	public void testGetDataByRegion() throws Exception{
		Beacon beacon = new Beacon();
		beacon.setUuid("8492e75f-4fd6-469d-b132-043-fe94921d8");
		beacon.setMajor(11305);
		beacon.setMinor(19481);
		System.out.println(tourService.getDataByBeacon(beacon));
	}
		
}
