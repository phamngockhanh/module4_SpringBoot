package com.kainmvc.webapp.repository;

import com.kainmvc.webapp.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepo extends JpaRepository<Song,Integer> {
    Song findSongById(Long id);
}
