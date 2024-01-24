package com.vip;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Mainapp {
	Homeautomation automation=new Homeautomation();
	Scanner scanner=new Scanner(System.in);

	public static void main(String[] args) {
		
		Mainapp app = new Mainapp();
		app.Homeautomation();
	}
		
	public void Homeautomation() {
			
		while(true) {
			System.out.println("\nHome Automation System Menu:");
			System.out.println("1.Add New Room");
			System.out.println("2.Add New Device to Room");
			System.out.println("3.Turn On Device");
			System.out.println("4.Turn Off Device");
			System.out.println("5.Check Room and Device Status");
			System.out.println("6.Display");
			System.out.println("7.Exit");
			
			System.out.println("Enter Your Choice:  ");
			int choice=scanner.nextInt();
			
			switch(choice) {
			case 1:
			{
				int input=-1;
			
				do {
					
					String roomName;
				
					System.out.println("\n@Add New Room==>");
					System.out.print("\nEnter Type Of Room : ");
					roomName = scanner.next();
					
					Room newRoom = new Room();
				    automation.addRoom(newRoom);
				    System.out.println("\nNew Room '" + roomName + "' added.\n");
				    
	
				    try {
						System.out.print("Press 0 For Exit --->\n");
						input = scanner.nextInt();
					} 
				    catch (InputMismatchException e) 
				    {
						System.out.println("\nInput is wrong!!!");
					}
				    scanner.nextLine();
				}while(input!=7);

		}
				break;
			case 2:
			{
				int roomIndex = 1;
				System.out.println("\nSelect Room To Add Device : \n");

                System.out.println("========================");
				 for (Room room : automation.rooms) {
					 	System.out.println(roomIndex + ". " + room.getRoomtype());
                        roomIndex++;
                    }
				System.out.println("========================");
				System.out.print("\nSelect The Room Number : ");
				int roomNum = scanner.nextInt();
				scanner.nextLine();
				
				if(roomNum >= 1 && roomNum <= automation.rooms.size())
				{
					int newDevice;
					do {
							System.out.println("===============================");
							System.out.println("Add Device You Want");
							System.out.println("===============================");
							System.out.println("\t1.Electronic Device");
							System.out.println("\t2.Air Conditioner");
							System.out.println("\t3.Television");
							System.out.println("\t4.Shower");
							System.out.println("\t5.Light");
							System.out.println("\t0.Back To Menu");
							System.out.println("===============================");
							
							System.out.print("Enter Your Choice : ");
							newDevice = scanner.nextInt();
							
							if(newDevice >=1 && newDevice <=5)
							{
								System.out.print("Enter Device Name : ");
								String name = scanner.next();
								
								System.out.print("Enter Device Id   : ");
								String id = scanner.next();
								switch(newDevice)
								{
									
									case 1 :
									{
										ElectronicDevice eDevice = new ElectronicDevice(name,id);
										
										automation.rooms.get(roomNum - 1).addDevice(eDevice);
						
										System.out.println(name+" Device added");
									}
									break;
									
									case 2 :
									{
										Airconditioner airConditioner = new Airconditioner(name,id);
										
										automation.rooms.get(roomNum - 1).addDevice(airConditioner);
										
										System.out.println(name+" Device added");
									}
									break;
									
									case 3 :
									{
										Television telVision = new Television(name,id);
										
										automation.rooms.get(roomNum - 1).addDevice(telVision);
										
										System.out.println(name+" Device added");
									}
									break;
									
									case 4 :
									{
										Shower shower = new Shower(name,id);
										
										automation.rooms.get(roomNum - 1).addDevice(shower);
										
										System.out.println(name+" Device added");
									}
									break;
									
									case 5 :
									{
										Light light = new Light(name,id);
										
										automation.rooms.get(roomNum - 1).addDevice(light);
										
										System.out.println(name+" Device added");
									}
									break;
									
								
								}

							}
							else if(newDevice==0)
							{
								System.out.println("\nBack to main menu <--\n");
							}
							else
							{
								System.out.println("\nRoom Number Is Wrong!!\n");
							}
					
					}while(newDevice!=7);
					
				}

			}
				break;
			case 3:
			{
				{
					System.out.println("Select Room To Control Device :");
					int roomIndex = 1;

                    System.out.println("========================");
					 for (Room room : automation.rooms) {
	                        System.out.println(roomIndex + ". " + room.getRoomtype());
	                        roomIndex++;
	                    }
					 System.out.println("========================");
					 System.out.println("Enter Room Type : ");
					 int roomNum = scanner.nextInt();
					 scanner.nextLine();
					 
				
					 if(roomNum >= 1 && roomNum <= automation.rooms.size())
						{
							//Room room = house.rooms.get(roomNum - 1);
						 int deviceNum=-1;
						 
						 do {
							 	System.out.println("============================");
							 	System.out.println("Please select the Device To Turn ON ");
							 	System.out.println("============================");
								System.out.println("1.Electronic Device");
								System.out.println("2.Air Conditioner");
								System.out.println("3.Television");
								System.out.println("4.Showers");
								System.out.println("5.Lights");
								System.out.println("0.Back To Menu");
								System.out.println("============================");
							 	
								System.out.print("Enter Your choice : ");
								deviceNum = scanner.nextInt();
								
							 
								if(deviceNum>=0 && deviceNum<=5)
								{
									
									
									switch(deviceNum)
									{
										
										default :
										{
											int flag=0;
											System.out.println();
											System.out.print("Enter Device Id : ");
											String deviceId = scanner.next();
											
											for(int ctr=0;ctr<automation.rooms.get(roomNum-1).devices.size();ctr++)
											{
											
												if(automation.rooms.get(roomNum-1).devices.get(ctr).getDeviceid().equals(deviceId))
												{
													
													automation.rooms.get(roomNum-1).devices.get(ctr).turnon();
													flag++;
													break;
													
												}
											}
											if(flag==0)
											{
												System.out.println("\nDevice Not Found !\n");
											}
											
											
										}
										break;
										
										case 0 :
										{
											System.out.println("\nBack to main menu <--\n");
										}
										break;
								}
								
									
								}
								else
								{
									System.out.println("\nDevice Number is Wrong..\n");
								}
								
								
							 
						 }while(deviceNum!=7);
						 
						}
					 
					
				}
			}
				break;
			case 4:
			{
				System.out.println("Select Room To Control Device :");
				int roomIndex = 1;

                System.out.println("========================");
				 for (Room room : automation.rooms) {
                        System.out.println(roomIndex + ". " + room.getRoomtype());
                        roomIndex++;
                    }

                 System.out.println("========================");
				 System.out.println("Enter Room Type : ");
				 int roomNum = scanner.nextInt();
				 scanner.nextLine();
				 
			
				 if(roomNum >= 1 && roomNum <= automation.rooms.size())
					{
						//Room room = house.rooms.get(roomNum - 1);
					 int deviceNum;
					 
					 do {
						 	System.out.println("============================");
						 	System.out.println("Please Select the Device To Turn OFF ");
						 	System.out.println("============================");
							System.out.println("1.Electronic Device");
							System.out.println("2.Air Conditioner");
							System.out.println("3.Television");
							System.out.println("4.Showers");
							System.out.println("5.Lights");
							System.out.println("0.Back To Menu\n");
							System.out.println("============================");
							
							System.out.print("Enter Your choice : ");
							deviceNum = scanner.nextInt();
						 
							if(deviceNum>=0 && deviceNum<=5)
							{
								switch(deviceNum)
								{
									
									default :
									{
										int flag=0;
										System.out.println();
										System.out.print("Enter Device Id : ");
										String deviceId = scanner.next();
										
										for(int ctr=0;ctr<automation.rooms.get(roomNum-1).devices.size();ctr++)
										{
										
											if(automation.rooms.get(roomNum-1).devices.get(ctr).getDeviceid().equals(deviceId))
											{
												
												automation.rooms.get(roomNum-1).devices.get(ctr).turnoff();
												flag++;
												break;
												
											}
										}
										if(flag==0)
										{
											System.out.println("\nDevice Not Found !\n");
										}
										
										
									}
									break;
									
									case 0 :
									{
										System.out.println("\nBack to main menu <--\n");
									}
									break;
								}
								
							}
							else
							{
								System.out.println("\nDevice Number is Wrong..\n");
							}
						 
					 }while(deviceNum!=7);
					 
					}
		
			}
				break;
			case 5:
			{
                System.out.println("========================");
				for(int ctr=0;ctr<automation.rooms.size();ctr++)
				{
					System.out.println("\nRoom Name : "+automation.rooms.get(ctr).roomtype);
					
					for(int ctr2=0;ctr2<automation.rooms.get(ctr).devices.size();ctr2++)
					{
						System.out.println("\nDevice Name : "+automation.rooms.get(ctr).devices.get(ctr2).devicename);
						System.out.println();
						
					}
				}
				System.out.println("========================");
			}
				break;
			case 6:
			{
                System.out.println("========================");
				for(int ctr=0;ctr<automation.rooms.size();ctr++)
				{
					System.out.println("\nRoom Name : "+automation.rooms.get(ctr).roomtype);
					
					for(int ctr2=0;ctr2<automation.rooms.get(ctr).devices.size();ctr2++)
					{
						System.out.println("\nDevice Name : "+automation.rooms.get(ctr).devices.get(ctr2).devicename);
						System.out.println();
						
					}
				}
				System.out.println("========================");
			}
			break;
			
			case 7 :
			{
				System.out.println("\nThank You!!");
			}
			break;
			
			default :
			{
				System.out.println("\nInvalid Choice!!Please enter a valid Option\n");
			}
			break;
			}
		}
				
	}
		
}
