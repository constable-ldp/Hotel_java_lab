import java.util.ArrayList;

public class GuestGroup {

    private ArrayList<Guest> group;

    public ArrayList<Guest> getGroup() {
        return group;
    }

    public GuestGroup(){
        this.group = new ArrayList<>();
    }

    public void addToGroup(Guest guest){
        this.group.add(guest);
    }

    public int sizeOfGroup() {
        return this.group.size();
    }
}
