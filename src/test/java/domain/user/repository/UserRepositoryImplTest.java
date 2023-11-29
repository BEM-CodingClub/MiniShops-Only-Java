package domain.user.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.user.User;
import java.util.NoSuchElementException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserRepositoryImplTest {

    UserRepository userRepository;

    @Test
    @DisplayName("회원가입 테스트")
    void signup_test() {

        // given
        User user = new User("test@test.com", "123123", "테스터");
        userRepository = UserRepositoryImpl.getUserRepository();

        // when
        int savedId = userRepository.save(user);

        // then
        assertEquals(userRepository.findById(savedId), user);
        assertEquals(userRepository.findByEmail("test@test.com"), user);
        assertEquals(userRepository.findAll().size(), 1);

        userRepository.deleteById(savedId);
        assertEquals(userRepository.findAll().size(), 0);

    }

    @Test
    @DisplayName("회원 여러개 저장 후 확인")
    void 다중_회원가입() {

        User user1 = new User("test1@test.com", "123123", "테스터1");
        UserRepository userRepository1 = UserRepositoryImpl.getUserRepository();
        userRepository1.save(user1);

        User user2 = new User("test2@test.com", "123123", "테스터2");
        UserRepository userRepository2 = UserRepositoryImpl.getUserRepository();
        userRepository2.save(user2);

        User user3 = new User("test3@test.com", "123123", "테스터3");
        UserRepository userRepository3 = UserRepositoryImpl.getUserRepository();
        userRepository3.save(user3);

        User user4 = new User("test4@test.com", "123123", "테스터4");
        UserRepository userRepository4 = UserRepositoryImpl.getUserRepository();
        userRepository4.save(user4);

        User user5 = new User("test5@test.com", "123123", "테스터5");
        UserRepository userRepository5 = UserRepositoryImpl.getUserRepository();
        userRepository5.save(user5);

        userRepository = UserRepositoryImpl.getUserRepository();
        assertEquals(userRepository.findAll().size(), 5);

    }


    @Test
    @DisplayName("회원조회")
    public void 없는_아이디의_회원조회() throws Exception {

        // given
        User user = new User("test@test.com", "123123", "테스터");
        userRepository = UserRepositoryImpl.getUserRepository();

        // then
        Assertions.assertThatThrownBy(() -> {
            userRepository.findById(5);
        }).isInstanceOf(NoSuchElementException.class);

    }

}