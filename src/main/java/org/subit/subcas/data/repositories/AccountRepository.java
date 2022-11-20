package org.subit.subcas.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.subit.subcas.data.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsernameAndDeletedIsFalse(String username);
}
