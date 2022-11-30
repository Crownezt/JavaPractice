package DiaryPackage;

import java.util.ArrayList;
import java.util.List;

public class Diary {

    private boolean isLocked;
    private String password;
//    int numberOfHappenings = 0;

    private List<Entry> entries;
    Diary(String ownersName, String password) {
        this.password = password;
        isLocked = true;
        entries = new ArrayList<>();
    }
    public boolean isLocked() {
        return isLocked;
    }

    public void unlockWith(String password) {
        boolean passwordMatches = password.equals(this.password);
        if(passwordMatches) isLocked = false;
    }

    public void lock() {
        this.isLocked = true;
    }

    public int numberOfEntries() {
        return entries.size();
    }


    public void write(String title, String message) {
        if (!isLocked) writeIntoDiary(title, message);
    }

    public void writeIntoDiary(String title, String message) {
            int id = numberOfEntries() + 1;
            Entry newEntry = new Entry(id, title, message);
            entries.add(newEntry);

    }

    public Entry findEntryWithId(int id) {
        if (!isLocked) return findId(id);
        else return null;
    }
    public Entry findId(int id) {
        for (Entry entry : entries){
            if (entry.getId() == id) return entry;
        }
        return null;
    }


}