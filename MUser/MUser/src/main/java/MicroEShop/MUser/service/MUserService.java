package MicroEShop.MUser.service;

import MicroEShop.MUser.dto.MUserDto;
import MicroEShop.MUser.entity.MUser;
import MicroEShop.MUser.mapper.Mapper;
import MicroEShop.MUser.repository.MUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MUserService {

    private final MUserRepository repository;

    private final Mapper mapper;

    public MUserService(MUserRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<MUserDto> getAllUser(){
        return this.repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public MUserDto getOneUser(int id){
        Optional<MUser> user = this.repository.findById(id);

        return user.map(mapper::toDto).orElse(null);
    }

    public void insert(MUser user){
        if(user != null){
            this.repository.save(user);
        }
    }
}
