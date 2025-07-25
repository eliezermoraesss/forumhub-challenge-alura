package com.forumhub.respository;

import com.forumhub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRespository extends JpaRepository<Topico, Long> {
}
