package org.example.likelionkwu.repository;

import org.example.likelionkwu.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
