package domain.user.repository;

import domain.user.User;
import java.util.List;

public interface UserRepository {

    // 사용자를 저장하고, 작업의 성공 여부에 따라 id 값을 반환.
    int save(User user);

    // 주어진 id 값으로 사용자를 찾아 반환. 사용자가 없는 경우 예외를 던짐.
    User findById(int userId);

    // 모든 사용자를 찾아 리스트로 반환.
    List<User> findAll();

    // 주어진 id 의 사용자를 삭제하고, 작업의 성공 여부에 따라 id 값을 반환.
    int deleteById(int userId);

    // 주어진 이메일로 사용자를 찾아 반환. 사용자가 없는 경우 null 반환.
    User findByEmail(String email);
}
