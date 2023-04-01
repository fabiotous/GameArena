import java.util.ArrayList;
public class User {
    private String name;
    private String email;
    private int phone;
    private int age;
    private int secondsPlayed;
    private String id;
    private String status;
    private boolean online;
    ArrayList<User> friendsList;

    public User(String id, String email, String name) //To be executed for user registration, involves essential data about a user
    {
        this.id = id; //Can be a unique username or id number
        this.name = name;
        this.email = email;
        this.secondsPlayed = 0;
        this.status = "idle";
        ArrayList<User> friendsList = new ArrayList<User>(); //Initialize a new empty list for friends
    }

    public String getID()
    {
        return id;
    }

    public void setID(String id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public void setPhone(int phone)
    {
        this.phone = phone;
    }

    public int getPhone()
    {
        return phone;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public void setOnline()
    {
        this.online = true;
    }

    public void setOffline()
    {
        this.online = false;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public void playGame() //skeleton placeholder to use for other things
    {
        setStatus("playing a game");
    }
    public void ExitGame()
    {
        setStatus("idle");
    }
    public void recordSecond()
    {
        try
        {
            while(this.status == "playing a game"){
                Thread.sleep(1000);
                this.secondsPlayed++; //Increment by one every second
            }
        } catch (InterruptedException e) {

        }
    }
    public int getMinutesPlayed()
    {
        return this.secondsPlayed / 60;
    }
    public int getHoursPlayed()
    {
        return getMinutesPlayed() / 60;
    }
    public void addFriend(User user)
    {
        this.friendsList.add(user);
    }
    public void getFriendsList()
    {
        for (User u : friendsList)
        {
            u.print();
        }
    }
    public String print()
    {
        return ("\n Name: " + name + " Username: " + id + " Status: " + status);
    }


}
