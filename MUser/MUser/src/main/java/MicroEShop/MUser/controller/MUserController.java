package MicroEShop.MUser.controller;

import MicroEShop.MUser.dto.MUserDto;
import MicroEShop.MUser.entity.MUser;
import MicroEShop.MUser.service.MUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/musers")
public class MUserController {

    private final MUserService mUserService;


    public MUserController(MUserService mUserService) {
        this.mUserService = mUserService;
    }

    @GetMapping
    public List<MUserDto> getAllUser(){
        return this.mUserService.getAllUser();
    }

    @GetMapping(path = "/{id}")
    public MUserDto getOneUser(@PathVariable int id){
        return this.mUserService.getOneUser(id);
    }

    @PostMapping
    public void insertUser(@RequestBody MUser user){
        this.mUserService.insert(user);
    }

}
