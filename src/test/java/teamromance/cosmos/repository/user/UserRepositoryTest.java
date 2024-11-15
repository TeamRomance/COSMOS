package teamromance.cosmos.repository.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import teamromance.cosmos.domain.user.User;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("유저 이름으로 조회 테스트")
    void findByUsername() {
        // given
        User user = User.builder()
                .username("testUser")
                .password("test1234")
                .role("ADMIN")
                .build();

        // when
        userRepository.save(user);

        // then
        assertThat(userRepository.findByUsername("testUser")).isPresent();
    }
}