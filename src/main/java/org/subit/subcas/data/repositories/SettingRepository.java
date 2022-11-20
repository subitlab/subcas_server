package org.subit.subcas.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.subit.subcas.data.Setting;

import java.util.Optional;

public interface SettingRepository extends JpaRepository<Setting, Long> {
    Optional<Setting> findByName(String name);
}
