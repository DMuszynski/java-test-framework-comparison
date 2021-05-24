package pl.dmuszynski.javatestframeworkcomparison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmuszynski.javatestframeworkcomparison.payload.SeriesDTO;
import pl.dmuszynski.javatestframeworkcomparison.repository.SeriesRepository;
import pl.dmuszynski.javatestframeworkcomparison.service.SeriesService;

import javax.persistence.EntityManager;
import java.util.Set;

@Service(value = "seriesService")
public class SeriesServiceImpl implements SeriesService {

    private final SeriesRepository seriesRepository;
    private final EntityManager entityManager;

    @Autowired
    public SeriesServiceImpl(SeriesRepository seriesRepository, EntityManager entityManager) {
        this.seriesRepository = seriesRepository;
        this.entityManager = entityManager;
    }

    @Override
    public void createSeries(SeriesDTO seriesDetails) {

    }

    @Override
    public void updateSeries(SeriesDTO seriesDetails, Long seriesId) {

    }

    @Override
    public void deleteSeriesById(Long seriesId) {

    }

    @Override
    public Set<SeriesDTO> findAllSeries() {
        return null;
    }

    @Override
    public SeriesDTO findSeriesById(Long seriesId) {
        return null;
    }
}
