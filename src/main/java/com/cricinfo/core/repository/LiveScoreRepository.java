package com.cricinfo.core.repository;

import com.cricinfo.core.domain.LiveScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LiveScoreRepository extends JpaRepository<LiveScore, String> {

    Optional<LiveScore> findByTitle(String title);
}
