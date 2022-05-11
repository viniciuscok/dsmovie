package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable) {
        Page<Movie> result = repository.findAll(pageable);
        Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
        return page;
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {
        Movie result = repository.findById(id).get();
        MovieDTO dto = new MovieDTO(result);
        return dto;
    }
}
