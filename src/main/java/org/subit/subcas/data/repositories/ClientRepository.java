package org.subit.subcas.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.subit.subcas.data.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByClientID(String clientID);
}
