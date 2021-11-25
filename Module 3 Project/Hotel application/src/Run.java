import People.Staff;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Run
{

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String cmd;
    private Staff staff = new Staff();

    private String[] command;

    public void run() throws IOException
    {
        staff.setTitle("cleaner");
        startMessage();
        while(command[0].compareToIgnoreCase("quit") != 0)
        {
                if(command[0].equalsIgnoreCase("staff")
                        && staff.getTitle().equalsIgnoreCase("manager"))
                {
                    for(Staff personel : Database.getStaff())
                    {
                        System.out.println(personel);
                    }
                }
                else if(command[0].equalsIgnoreCase("help"))
                {
                    helpMessage();
                }
                else if(command[0].equalsIgnoreCase("dirty"))
                {
                    dirty();
                }
                else if(command[0].equalsIgnoreCase("clean"))
                {
                    clean();
                }
                else
                {
                    System.out.println("Unknown command, please check 'help ' for list of commands");
                    cmd = reader.readLine();
                    command = cmd.split(" ", 2);
                    break;
                }
            }
        System.out.println("Thank you for using Kaizen's hotel app!");
    }

    private void startMessage() throws IOException
    {
        loadDatabase();
        System.out.println("Welcome to Kaizen's hotel app! " + "\n" +
                "For more information please, type in 'help'!");
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }


    private void clean() throws IOException
    {
        int roomNumber;
        try
        {
            roomNumber = Integer.parseInt(command[1]);
                for(Room room : Database.getRooms())
                {
                    if(roomNumber == room.getRoomNumber())
                    {
                        if(room.isClean() == false)
                        {
                            room.cleanRoom(true);
                            System.out.println("Room is now clean, thank you for doing such an amazing job!");
                        }
                    }
                }
        }
        catch (NumberFormatException e)
        {
            System.out.println("You have added a letter to the room number, please try using the command again");
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    private void helpMessage() throws IOException
    {
        if(staff.getTitle().equalsIgnoreCase("manager"))
        {
            System.out.println("Staff - displays all of the staff working in the hotel");
            System.out.println("Add - displays a message asking if you would like to add a room or staff");
            System.out.println("Remove - displays a message asking if you would like to remove a room or staff");
            System.out.println("Change - displays a message asking if you would like to change a room or staff");
            System.out.println("Payroll - checks staff's salaries");
            System.out.println("Dirty - displays all of the dirty rooms in the hotel");
            System.out.println("Bookings - displays all booked rooms");
            System.out.println("Password - gives you the opportunity to change password");
        }

        if(staff.getTitle().equalsIgnoreCase("cleaner"))
        {
            System.out.println("Clean - marks room as no longer dirty");
            System.out.println("Dirty - displays all of the dirty rooms in the hotel");
            System.out.println("Password - gives you the opportunity to change password");
        }

        if(staff.getTitle().equalsIgnoreCase("receptionist"))
        {
            System.out.println("Book - books a room for a customer");
            System.out.println("Change - changes a booking for a customer");
            System.out.println("Remove - removes a booking for a customer");
            System.out.println("Bookings - displays all booked rooms");
            System.out.println("Password - gives you the opportunity to change password");
        }

        if(staff.getTitle().equalsIgnoreCase("accountant"))
        {
            System.out.println("Income - checks income of hotel");
            System.out.println("Tax - checks taxes that the hotel has to pay");
            System.out.println("Payroll - checks staff's salaries");
            System.out.println("Budget - checks budget for hotel needs");
            System.out.println("Password - gives you the opportunity to change password");
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }


    private void loadDatabase()
    {
        try
        {
            Database.loadRooms();
        }
        catch(Exception e)
        {
            System.out.println("Error loading from database!");
        }

        try
        {
            Database.loadStaff();
        }
        catch (Exception e)
        {
            System.out.println("Error loading from database!");
        }
    }
    
    private void dirty() throws IOException
    {
        if(staff.getTitle().equalsIgnoreCase("cleaner"))
        {
            try
            {
                boolean noDirtyRooms = true;
                for (Room room : Database.getRooms())
                {
                    if (room.isClean())
                    {
                        System.out.println("Room " + room.getRoomNumber() + " is clean!" );
                    }
                    else
                    {
                        System.out.println("Room " + room.getRoomNumber() + " needs cleaning!");
                        noDirtyRooms = false;
                    }
                }
                if(noDirtyRooms)
                {
                    System.out.println("No rooms need cleaning at the moment.");
                }
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Invalid command");
            }
        }
        else
        {
            System.out.println("This command is only usable by the cleaner staff");
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }
}
