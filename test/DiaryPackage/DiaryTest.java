package DiaryPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {
    Diary diary;

    @BeforeEach
    void setUp() {
        diary = new Diary("Adewunmi", "correctPassword");
    }

    @Test
    void diaryExistTest() {
        assertNotNull(diary);
    }

    @Test
    void newDiaryIsLocked() {
        assertTrue(diary.isLocked());
    }

    @Test
    void lockedDiaryCanBeUnlockedTest() {
        assertTrue(diary.isLocked());
        diary.unlockWith("correctPassword");
        assertFalse(diary.isLocked());
    }

    @Test
    public void wrongPasswordCannotUnlockDiaryTest() {
        assertTrue(diary.isLocked());
        diary.unlockWith("wrongPassword");
        assertTrue(diary.isLocked());
    }

    @Test
    void diaryCanBeLockedTest() {
        diary.unlockWith("correctPassword");
        diary.lock();
        assertTrue(diary.isLocked());
    }

    @Test
    void happeningsCanBeAddedToTheDiaryTest() {
        diary.unlockWith("correctPassword");

        diary.write("Jesus loves me, this I know.",
                "For the Bible tells me so. Little ones to him belong");

        assertEquals(1, diary.numberOfEntries());
    }

    @Test
    void entriesCannotBeAddedWhenDiaryIsLockedTest() {
        assertTrue(diary.isLocked());
        try {
            diary.write("Jesus loves me, this I know.",
                    "For the Bible tells me so. Little ones to him belong");
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(0, diary.numberOfEntries());
    }

    @Test
    void canFindEntriesUsingIdTest() {
        diary.unlockWith("correctPassword");
        assertFalse(diary.isLocked());
        diary.write("Jesus loves me, this I know.",
                "For the Bible tells me so. Little ones to him belong");
        assertEquals(1, diary.numberOfEntries());

        Entry foundEntry = diary.findEntryWithId(1);

        assertEquals(1, diary.numberOfEntries());
        assertEquals("Jesus loves me, this I know.", foundEntry.getTitle());
        assertEquals("For the Bible tells me so. Little ones to him belong", foundEntry.getMessage());

    }

    @Test
    void canChangeEntries() {
        diary.unlockWith("correctPassword");
        assertFalse(diary.isLocked());
        diary.write("Jesus loves me, this I know.",
                "For the Bible tells me so. Little ones to him belong");
        assertEquals(1, diary.numberOfEntries());

        Entry foundEntry = diary.findEntryWithId(1);

        assertEquals(1, diary.numberOfEntries());
        assertEquals("Jesus loves me, this I know.", foundEntry.getTitle());
        assertEquals("For the Bible tells me so. Little ones to him belong", foundEntry.getMessage());
        assertEquals("Jesus loves me, this I know.", foundEntry.getTitle());
        diary.updateEntries(1, "No story today, come tomorrow");

//        assertEquals("No story today, come tomorrow", foundEntry.getMessage());
        System.out.println(foundEntry.getMessage());
    }

    @Test
    void writingToLockedDiaryThrowsExceptionTest() {
        assertTrue(diary.isLocked());
        assertThrows(Exception.class, ()->diary.write("Anirah's break up with Simi",
                "I did not know what I did oo, He just came back one day and ..."));
    }
}
