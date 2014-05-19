package service.domain;

public class Data {
	
	private int dataNo;
	private String dataFileAdd;
	private int dataType;
	private int localNo;
	private int regoinNo;
	
	public int getDataNo() {
		return dataNo;
	}
	public void setDataNo(int dataNo) {
		this.dataNo = dataNo;
	}
	public String getDataFileAdd() {
		return dataFileAdd;
	}
	public void setDataFileAdd(String dataFileAdd) {
		this.dataFileAdd = dataFileAdd;
	}
	public int getDataType() {
		return dataType;
	}
	public void setDataType(int dataType) {
		this.dataType = dataType;
	}
	public int getLocalNo() {
		return localNo;
	}
	public void setLocalNo(int localNo) {
		this.localNo = localNo;
	}
	public int getRegoinNo() {
		return regoinNo;
	}
	public void setRegoinNo(int regoinNo) {
		this.regoinNo = regoinNo;
	}
	
	@Override
	public String toString() {
		return "Data [dataNo =" + dataNo + ", dataFileAdd=" + dataFileAdd + ", dataType=" + dataType 
				+ ", localNo=" + localNo + ", regoinNo=" + regoinNo + "]";
	}
	
	
}
