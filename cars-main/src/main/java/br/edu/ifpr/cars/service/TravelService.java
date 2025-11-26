package br.edu.ifpr.cars.service;

import br.edu.ifpr.cars.domain.travel.TravelRepository;
import br.edu.ifpr.cars.domain.travel.Travel;
import br.edu.ifpr.cars.domain.travel.dto.TravelRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TravelService {

    private final TravelRepository repository;

    public TravelService(TravelRepository repository) {
        this.repository = repository;
    }

    public Travel create(TravelRequestDTO dto) {
        Travel travel = new Travel(
                dto.passengerId(),
                dto.origin(),
                dto.destination()
        );
        return repository.save(travel);
    }

    public Travel accept(Long id) {
        Travel travel = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (travel.getStatus() == TravelRequestStatus.ACCEPTED
                || travel.getStatus() == TravelRequestStatus.FINISHED) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Viagem já aceita ou finalizada");
        }

        if (travel.getStatus() != TravelRequestStatus.CREATED) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Só pode aceitar viagens com status CREATED");
        }

        travel.setStatus(TravelRequestStatus.ACCEPTED);
        return repository.save(travel);
    }
}
