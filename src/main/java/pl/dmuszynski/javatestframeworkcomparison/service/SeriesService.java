package pl.dmuszynski.javatestframeworkcomparison.service;

import pl.dmuszynski.javatestframeworkcomparison.payload.SeriesDTO;

import java.util.Set;

public interface SeriesService {
    void createSeries(SeriesDTO seriesDetails);
    void updateSeries(SeriesDTO seriesDetails, Long seriesId);
    void deleteSeriesById(Long seriesId);
    Set<SeriesDTO> findAllSeries();
    SeriesDTO findSeriesById(Long seriesId);
}
