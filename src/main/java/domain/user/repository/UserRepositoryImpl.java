package domain.user.repository;

import domain.user.User;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    // Singleton 패턴을 사용하여 단일 인스턴스 생성
    private UserRepositoryImpl() {}

    // 클래스의 단일 인스턴스
    private static final UserRepository userRepository = new UserRepositoryImpl();

    // Singleton 인스턴스 반환 메서드
    public static UserRepository getUserRepository() {
        return userRepository;
    }

    // 사용자 데이터를 저장할 HashMap
    private HashMap<Integer, User> store = new HashMap<>();

    // 사용자 id 값을 생성하기 위한 시퀀스
    private int sequence = 0;

    // 새 사용자를 저장하고, 사용자 ID를 반환하는 메서드
    @Override
    public int save(User user) {
        store.put(++sequence, user); // 시퀀스 증가 및 사용자 저장
        user.setUserId(sequence); // 사용자 객체에 ID 설정
        return user.getUserId(); // 저장된 사용자의 ID 반환
    }

    // 주어진 id 값으로 사용자를 찾아 반환하는 메서드. 없으면 NoSuchElementException 예외 발생
    @Override
    public User findById(int userId) {
        return Optional.ofNullable(store.get(userId))
            .orElseThrow(() -> new NoSuchElementException("존재하지 않는 회원입니다."));
    }

    // 모든 사용자를 리스트로 반환하는 메서드
    @Override
    public List<User> findAll() {
        return store.values().stream().toList();
    }

    // 주어진 id 값의 사용자를 삭제하고, 해당 ID를 반환하는 메서드
    @Override
    public int deleteById(int userId) {
        store.remove(userId); // 사용자 삭제
        return userId; // 삭제된 사용자의 ID 반환
    }

    // 주어진 이메일로 사용자를 찾아 반환하는 메서드.
    @Override
    public User findByEmail(String email) {
        for (User user : store.values()) {
            if (user.getEmail().equals(email)) {
                return user; // 해당 이메일을 가진 사용자 반환
            }
        }
        return null; // 일치하는 사용자 없을 시 null 반환
    }
}
