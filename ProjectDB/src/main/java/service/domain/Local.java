package service.domain;

public class Local {
	
	private int localNo;
	private String localName; 
	private String gpsX;
	private String gpsY;
	
	public int getLocalNo() {
		return localNo;
	}
	public void setLocalNo(int localNo) {
		this.localNo = localNo;
	}
	public String getLocalName() {
		return localName;
	}
	public void setLocalName(String localName) {
		this.localName = localName;
	}
	public String getGpsX() {
		return gpsX;
	}
	public void setGpsX(String gpsX) {
		this.gpsX = gpsX;
	}
	public String getGpsY() {
		return gpsY;
	}
	public void setGpsY(String gpsY) {
		this.gpsY = gpsY;
	}
	@Override
	public String toString() {
		return "Local [localNo =" + localNo + ", localName=" + localName + ", gpsX=" + gpsX + ", gpsY=" + gpsY + "]";
	}
	
	
	
}
