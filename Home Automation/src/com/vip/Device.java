package com.vip;

import java.util.Date;

public class Device {
	String devicename;
	String deviceid;
	boolean isON;
	long totaltime;
    Date lastStateTime;
	
	public Device() {
		// TODO Auto-generated constructor stub
	}

	public Device(String devicename,String deviceid) {
		super();
		this.devicename = devicename;
		this.deviceid = deviceid;
		this.isON = false;
		this.totaltime = 0;
		this.lastStateTime = new Date();
	}
	
	public String getDevicename() {
		return devicename;
	}

	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}
	
	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public boolean isON() {
		return isON;
	}

	public void setON(boolean isON) {
		this.isON = isON;
	}

	public long getTotaltime() {
		long currentTime = System.currentTimeMillis();
		
		if(isON)
		{
			return totaltime + (currentTime - lastStateTime.getTime()); 
		}
		else
		{
			return totaltime;
		}

	}
	
	public void setTotaltime(long totaltime) {
		this.totaltime = totaltime;
	}

	public Date getLastStateTime() {
		return lastStateTime;
	}

	public void setLastStateTime(Date lastStateTime) {
		this.lastStateTime = lastStateTime;
	}

	public void turnon() {
		if(!isON)
		{
			isON = true;
			
			long currentTime = System.currentTimeMillis();
			
            this.totaltime += (currentTime - lastStateTime.getTime());
            this.lastStateTime = new Date(currentTime);
            System.out.println(this.devicename + " is turned ON");
		}
		else
		{
			System.out.println(this.devicename + " is already ON");
		}
	}
	
	public void turnoff() {
		
		if(!isON)
		{
			isON = false;
			
			long currentTime = System.currentTimeMillis();
			
            this.totaltime += (currentTime - lastStateTime.getTime());
            this.lastStateTime = new Date(currentTime);
            System.out.println(this.devicename + " is turned Off");
		}
		else
		{
			System.out.println(this.devicename + " is already Off");
		}
	}
	}
//public void turnon() {
//		if(!isON) {
//			isON=true;
//			System.out.println(devicename+"is turn on");
//		}
//		else {
//		    System.out.println(devicename+"is already turn on");
//		}
//	}
//public void turnoff() {
//	if(!isON) {
//		isON=false;
//		System.out.println(devicename+"is turn off");
//	}
//	else {
//	    System.out.println(devicename+"is already turn o");
//	}
//}
//}
	