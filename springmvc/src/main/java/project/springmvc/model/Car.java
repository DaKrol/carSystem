package project.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Car {
    @Id
    private UUID id;
    private String marka;
    private String model;
    private String nrRejestracyjny;
    private String rok;
    private String paliwo;
    private UUID userId;
    public Car() {
        this.id= UUID.randomUUID();
    }

    public Car(UUID id, String marka, String model, String nrRejestracyjny, String rok, String paliwo, UUID clientId) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.nrRejestracyjny = nrRejestracyjny;
        this.rok = rok;
        this.paliwo = paliwo;
        this.userId = clientId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNrRejestracyjny() {
        return nrRejestracyjny;
    }

    public void setNrRejestracyjny(String nrRejestracyjny) {
        this.nrRejestracyjny = nrRejestracyjny;
    }

    public String getRok() {
        return rok;
    }

    public void setRok(String rok) {
        this.rok = rok;
    }

    public String getPaliwo() {
        return paliwo;
    }

    public void setPaliwo(String paliwo) {
        this.paliwo = paliwo;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
