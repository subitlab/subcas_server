package org.subit.subcas.service.Impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.subit.subcas.data.Account;
import org.subit.subcas.data.Client;
import org.subit.subcas.data.repositories.AccountRepository;
import org.subit.subcas.data.repositories.ClientRepository;
import org.subit.subcas.dto.UserDTO;
import org.subit.subcas.exception.ClientNotRegisterException;
import org.subit.subcas.exception.UserForbiddenException;
import org.subit.subcas.exception.UsernamePasswordNotMatchException;
import org.subit.subcas.service.AuthorizationService;
import org.subit.subcas.utils.UserJwtUtils;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Resource
    AccountRepository accountRepository;

    @Resource
    PasswordEncoder passwordEncoder;

    @Resource
    ClientRepository clientRepository;

    @Resource
    UserJwtUtils userJwtUtils;

    @Override
    public String login(UserDTO user) throws UsernamePasswordNotMatchException, UserForbiddenException {
        Optional<Account> targetOpt = accountRepository.findByUsernameAndDeletedIsFalse(user.getUsername());
        targetOpt.orElseThrow(UsernamePasswordNotMatchException::new);
        Account target = targetOpt.get();
        if (!passwordEncoder.matches(user.getPassword(), target.getPassword()))
            throw new UsernamePasswordNotMatchException();

        if (target.getBlocked()) throw new UserForbiddenException();
        return userJwtUtils.generateToken(target);
    }

    @Override
    public String redirect(String ClientID) throws ClientNotRegisterException {
        Optional<Client> ClientOpt = clientRepository.findByClientID(ClientID);
        ClientOpt.orElseThrow(ClientNotRegisterException::new);
        return ClientOpt.get().getRedirectUrl();
    }
}
