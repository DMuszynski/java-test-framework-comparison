package javatestframeworkcomparison.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javatestframeworkcomparison.payload.SeriesDTO;
import javatestframeworkcomparison.service.SeriesService;

import java.util.Set;

@RestController
@RequestMapping(value = "app/series")
@CrossOrigin(origins = "http://localhost:4200")
public class SeriesController {

    private final SeriesService seriesService;

    @Autowired
    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createSeries(@RequestBody SeriesDTO seriesDetails) {
        this.seriesService.createSeries(seriesDetails);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{seriesId}")
    public ResponseEntity<HttpStatus> updateSeries(@RequestBody SeriesDTO seriesDetails, @PathVariable Long seriesId) {
        this.seriesService.updateSeries(seriesDetails, seriesId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{seriesId}")
    public ResponseEntity<SeriesDTO> findSeriesById(@PathVariable Long seriesId) {
        final SeriesDTO foundSeriesDTO = this.seriesService.findSeriesById(seriesId);
        return new ResponseEntity<>(foundSeriesDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Set<SeriesDTO>> findAllSeriesById() {
        final Set<SeriesDTO> foundAllSeriesDTO = this.seriesService.findAllSeries();
        return new ResponseEntity<>(foundAllSeriesDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{seriesId}")
    public ResponseEntity<HttpStatus> deleteSeriesById(@PathVariable Long seriesId) {
        this.seriesService.deleteSeriesById(seriesId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
