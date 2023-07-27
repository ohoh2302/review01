package com.example.space.Service;

import com.example.space.dto.SignUpRequestDto;
import com.example.space.entity.User;
import com.example.space.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signup(SignUpRequestDto requestDto) {
        String nickname = requestDto.getNickname();
        String password = requestDto.getPassword();
        String checkPassword = requestDto.getCheckPassword();

        if(userRepository.findByNickname(nickname).isPresent()) {
            throw new IllegalArgumentException("중복된 닉네임 입니다.");
        }

        if(!password.equals(checkPassword)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        else if(password.contains(nickname)) {
            throw new IllegalArgumentException("비밀번호에 닉네임과 같은 값이 포함되있습니다.");
        }
        User user = new User(nickname, password);
        userRepository.save(user);
    }
}
