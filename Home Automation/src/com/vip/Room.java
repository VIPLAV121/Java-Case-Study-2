package com.vip;

import java.util.List;

public class Room {
	String roomtype;
	List<Device>devices;
	
	public Room() {
		// TODO Auto-generated constructor stub
	}

	public Room(String roomtype, List<Device> devices) {
		super();
		this.roomtype = roomtype;
		this.devices = devices;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public void addDevice(Device device) {
		devices.add(device);
	}
}
