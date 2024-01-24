package com.vip;

import java.util.List;


public class Homeautomation {
	 List<Room>rooms;
	
	public Homeautomation() {
		// TODO Auto-generated constructor stub
	}
	public Homeautomation(List<Room> room) {
		super();
		this.rooms = room;
	}
	
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	public void addRoom(Room room) {
		rooms.add(room);
	}
	
	public void displayStatus() {
        for (Room room : rooms) {
            System.out.println("\nRoom: " + room.getRoomtype());
            List<Device> devices = room.getDevices();
            for (Device device : devices) {
            	System.out.println("- Device: " + device.getDevicename());
                System.out.println("  Status: " + (device.isON() ? "ON" : "OFF"));
                System.out.println("  Total Time In State (ms): " + device.getTotaltime());  
                System.out.println("  Last State Change Time: " + device.getLastStateTime());
            }
        }
    }
}
