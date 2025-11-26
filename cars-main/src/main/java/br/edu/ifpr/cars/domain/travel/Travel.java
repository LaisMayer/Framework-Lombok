package br.edu.ifpr.cars.domain.travel;

import jakarta.persistence.*;

@Entity
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long passengerId;
    private String origin;
    private String destination;

    @Enumerated(EnumType.STRING)
    private TravelRequestStatus status;

    public Travel() {
    }

    public Travel(Long passengerId, String origin, String destination) {
        this.passengerId = passengerId;
        this.origin = origin;
        this.destination = destination;
        this.status = TravelRequestStatus.CREATED;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public TravelRequestStatus getStatus() {
        return status;
    }

    public void setStatus(TravelRequestStatus status) {
        this.status = status;
    }

}
