package com.kainmvc.webapp.service;

import com.kainmvc.webapp.entity.Song;
import com.kainmvc.webapp.repository.ISongRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{
    private final ISongRepo iSongRepo;

    public SongService(ISongRepo iSongRepo) {
        this.iSongRepo = iSongRepo;
    }

    @Override
    public List<Song> findAll() {
        return iSongRepo.findAll();
    }

    @Override
    public void add(Song song) {
        iSongRepo.save(song);
    }

    @Override
    public void update(Song song) {
        iSongRepo.save(song);
    }
}
