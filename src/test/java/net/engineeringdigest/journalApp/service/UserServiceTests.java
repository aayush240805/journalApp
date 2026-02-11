package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;



//    @BeforeAll
//    @BeforeEach
//    @AfterAll
//    @AfterEach



    @Disabled
    @Test
    public void checkNow1() {
        assertEquals(5, 2+3);
        User user = userRepository.findByUserName("A");
        assertNotNull(user);
        assertTrue(user.getJournalEntries().isEmpty());
    }


    @Disabled
    @ParameterizedTest

//    @EnumSource
//    @ArgumentsSource() <- custom source
    @ValueSource(strings = {
            "A",
            "B",
            "C",
            "Z"
    })
    public void checkNow2(String userName) {
        assertNotNull(userRepository.findByUserName(userName), "failed for: " + userName);
    }


    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "5, 3, 8",
            "2, 5, 8"
    })
    public void checkNow3(int a, int b, int expected) {
        assertEquals(expected, a + b);
    }


    @Disabled
    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testFindByUserName(User user) {
        assertTrue(userService.saveNewUser(user));
    }
}
