package org.ssm.model;

public class DashBoardDataOne {

	private String hour;
	
	private Integer inSum;
	
	private Integer outSum;
	
	public DashBoardDataOne() {
		
	}

	public DashBoardDataOne(String hour, Integer inSum, Integer outSum) {
		super();
		this.hour = hour;
		this.inSum = inSum;
		this.outSum = outSum;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public Integer getInSum() {
		return inSum;
	}

	public void setInSum(Integer inSum) {
		this.inSum = inSum;
	}

	public Integer getOutSum() {
		return outSum;
	}

	public void setOutSum(Integer outSum) {
		this.outSum = outSum;
	}

	@Override
	public String toString() {
		return "DashBoardDataOne [hour=" + hour + ", inSum=" + inSum + ", outSum=" + outSum + "]";
	}

}
