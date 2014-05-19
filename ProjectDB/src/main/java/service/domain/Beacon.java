package service.domain;

public class Beacon {
	
	private String uuid;
	private int major;
	private int minor;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public int getMajor() {
		return major;
	}
	public void setMajor(int major) {
		this.major = major;
	}
	public int getMinor() {
		return minor;
	}
	public void setMinor(int minor) {
		this.minor = minor;
	}
	
	@Override
	public String toString() {
		return "Beacon [uuid =" + uuid + ", major=" + major + ", minor=" + minor + "]";
	}
	
	
}
