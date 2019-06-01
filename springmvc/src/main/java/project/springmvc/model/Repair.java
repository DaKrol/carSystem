package project.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
public class Repair {
    @Id
    public UUID id;
    public UUID carId;
    public Date date;

    public Repair() {
        this.id = UUID.randomUUID();
    }

    public Repair(UUID id, UUID carId, Date date) {
        this.id = id;
        this.carId = carId;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCarId() {
        return carId;
    }

    public void setCarId(UUID carId) {
        this.carId = carId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
