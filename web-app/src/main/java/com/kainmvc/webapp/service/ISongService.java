package com.kainmvc.webapp.service;

import com.kainmvc.webapp.entity.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void add(Song song);
    void update(Song song);
}
