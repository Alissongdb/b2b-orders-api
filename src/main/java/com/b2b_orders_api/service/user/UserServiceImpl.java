package com.b2b_orders_api.service.user;

import com.b2b_orders_api.dto.UserDTO;
import com.b2b_orders_api.mapper.UserMapper;
import com.b2b_orders_api.model.User;
import com.b2b_orders_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO criar(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);

        user.setSenha(passwordEncoder.encode(user.getSenha()));

        User userSalvo = userRepository.save(user);
        return userMapper.toDTO(userSalvo);
    }
    
    @Override
    public List<UserDTO> listarTodos() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toDTO)
                .toList();
    }

    @Override
    public UserDTO listarPorId(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado com o id" + id));
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO atualizarPorId(Long id, UserDTO userDTO) {
        User userExistente = getUser(id);

        userExistente.setEmail(userDTO.email());

        userExistente.setSenha(passwordEncoder.encode(userDTO.senha()));

        User userAtualizado = userRepository.save(userExistente);
        return userMapper.toDTO(userAtualizado);
    }

    @Override
    public void deletarPorId(Long id) {
        User user = getUser(id);
        userRepository.delete(user);
    }

    private User getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado com o id" + id));
        return user;
    }
}
