package MicroEShop.MSecurite.services;

import MicroEShop.MSecurite.mapper.Mapper;
import MicroEShop.MSecurite.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository repository;

    private final Mapper mapper;

    public UserService(UserRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return this.repository.findByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
