package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    AuthService authService;

    @Transactional
    public ReviewDTO insert(ReviewDTO dto) {
        Review entity = new Review();

        // Busca o filme pelo ID
        Movie movie = movieRepository.findById(dto.getMovieId())
            .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado"));

        // Obtém o usuário logado
        User user = authService.authenticated();

        // Preenche a entidade
        entity.setText(dto.getText());
        entity.setMovie(movie);
        entity.setUser(user);

        // Salva no banco
        entity = reviewRepository.save(entity);

        return new ReviewDTO(entity);
    }
}
