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
	public void testGetData() throws Exception{
		System.out.println("localNo : "+tourService.getLocalInfo().get(0).getLocalNo());
		System.out.println(tourService.getDataByLocal(tourService.getLocalInfo().get(0).getLocalNo()));
	}
		
}
