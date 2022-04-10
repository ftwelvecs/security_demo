package kz.f12.school.securitydemo.security;

import kz.f12.school.securitydemo.model.entity.User;
import kz.f12.school.securitydemo.model.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Сервис предоставляющий пользователей
@Service("myCustomBean")
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    // метод который возвращает пользователей
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with login: " + username + " not found"));
        // метод конвертирует объект User(наш юзер) в UserDetails(юзер спринга)
        return UserDetailsImpl.fromUser(user);
    }
}
