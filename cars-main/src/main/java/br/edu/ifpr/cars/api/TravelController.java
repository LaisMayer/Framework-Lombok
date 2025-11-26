package br.edu.ifpr.cars.api;

import br.edu.ifpr.cars.domain.travel.Travel;
import br.edu.ifpr.cars.domain.travel.dto.TravelRequestDTO;

import br.edu.ifpr.cars.service.TravelService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/travels")
public class TravelController {

    private final TravelService service;

    public TravelController(TravelService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Travel> create(@RequestBody TravelRequestDTO dto) {
        Travel travel = service.create(dto);
        return ResponseEntity.ok(travel);
    }

    @PatchMapping("/{id}/accept")
    public ResponseEntity<Travel> accept(@PathVariable Long id) {
        return ResponseEntity.ok(service.accept(id));
    }
}
