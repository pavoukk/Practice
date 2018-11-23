package it.sevenbits;

import org.junit.*;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.*;

public class UserManagerTest {
    private ICollection collection;
    private UserManager manager;
    @Before
    public void initialize() throws IOException {
        collection = Mockito.mock(ICollection.class);
        manager = new UserManager(collection);
    }

    @Test
    public void collectionGetTest() throws IOException {
        User userSimple = new User("Simple User", "developer");
        Mockito.when(collection.get(0)).thenReturn(userSimple);
        assertEquals(collection.get(0), userSimple);
    }

    @Test(expected = IOException.class)
    public void collectionGetTestExceptions() throws IOException {
        Mockito.when(collection.get(4)).thenThrow(new IOException());
        collection.get(4);
        fail();
    }

    @Test
    public void getUserByIndex() throws UserManagerException, IOException {
        User simpleUser = new User("Simple User", "developer");
        User anotherUser = new User("Another User", "project manager");
        User userCorgi = new User("Fairy Corgi", "dog");
        Mockito.when(collection.get(0)).thenReturn(simpleUser);
        Mockito.when(collection.get(1)).thenReturn(anotherUser);
        Mockito.when(collection.get(2)).thenReturn(userCorgi);
        User[] users = new User[] {simpleUser, anotherUser, userCorgi};
        for (int i = 0; i < users.length; i++) {
            assertEquals(manager.getUserByIndex(i), users[i]);
        }
    }

    @Test
    public void createDefaultTest() throws UserManagerException, IOException {
        manager.createDefault("Steve Jobs");
        Mockito.when(collection.get(3)).thenReturn(new User("Steve Jobs", "default"));
        assertEquals(manager.getUserByIndex(3).getName(), "Steve Jobs");
    }
    @Test(expected = UserManagerException.class)
    public void testErrors() throws UserManagerException, IOException {
        Mockito.when(collection.get(4)).thenThrow(new IOException());
        manager.getUserByIndex(4);
        fail();
    }

    @Test(expected = UserManagerException.class)
    public void createDefault() throws IOException, UserManagerException {
        Mockito.doThrow(new IOException()).when(collection).add(Mockito.argThat(user -> user.getName().equals("")));
        manager.createDefault("");
        fail();
    }
}