package ci.digitalacademy.monetab.services.impl;


import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.repositories.UserRepository;
import ci.digitalacademy.monetab.services.UserService;
import ci.digitalacademy.monetab.services.dto.UserDTO;
import ci.digitalacademy.monetab.services.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private  final UserMapper userMapper;

    //private final Logger log = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public UserDTO save(UserDTO userDTO) {
        log.debug("Resquest to save : {}",userDTO);
        User user = userMapper.toEntity(userDTO);
        user= userRepository.save(user);

        return  userMapper.toDto(user);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {

        log.debug("Request to update {}",userDTO);

       // return userRepository.findById(user.getId())
//        //        .map(existingUser->{
//           //         existingUser.setPassword(user.getPassword());
//              //      return existingUser;
//             //   }).map(existingUser->{
//               //     return save(existingUser);
//             //   }).orElseThrow(()->new IllegalArgumentException());
//
//        Optional<User>optionalUser=findOne(user.getId());//recupertion d'un Optional<User>
//        if(optionalUser.isPresent()){ //verification de l'existance d'un contenu dans le optimal
//            User userToUpdate = optionalUser.get(); //declaration + affection d'u user à partir du optimal
//            userToUpdate.setPassword(user.getPassword()); //mise à jour du pseud
//            userToUpdate.setSpeudo(user.getSpeudo());//mise à jour du pseud
//
//            log.info("Request to update user in progress");
//
//            return save(userToUpdate); //enregistrement de l'utilisateur
//        }else {
//            throw new IllegalArgumentException();
//        }

        User user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public Optional<UserDTO> findOne(Long id) {
        return userRepository.findById(id).map(user -> {
            return userMapper.toDto(user);
        });
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(user -> {
            return userMapper.toDto(user);
        }).toList();
    }

    @Override
    public void delecte(Long id) {
        log.debug("Request to delete user {}",id);
        userRepository.deleteById(id);
    }


}
