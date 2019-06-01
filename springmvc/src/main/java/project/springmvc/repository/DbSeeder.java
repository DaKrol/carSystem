package project.springmvc.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import project.springmvc.model.Car;
import project.springmvc.model.Repair;
import project.springmvc.model.User;

import java.util.Date;
import java.util.UUID;

@Component
@ConditionalOnProperty(name = "product.db.recreate", havingValue = "true")
public class DbSeeder implements CommandLineRunner {
    private UserRepository userRepository;
    private CarRepository carRepository;
    private RepairRepository repairRepository;

    public DbSeeder(UserRepository userRepository, CarRepository carRepository, RepairRepository repairRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.repairRepository = repairRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(UUID.randomUUID(), "a", "a", "a", "a", null, UUID.randomUUID());
        this.userRepository.save(user1);
        User user2 = new User(UUID.randomUUID(), "b", "b", "b", "b", UUID.randomUUID(), null);
        this.userRepository.save(user2);
        User user3 = new User(UUID.randomUUID(), "c", "c", "c", "c", UUID.randomUUID(), null);
        this.userRepository.save(user3);
        Car car1 = new Car(UUID.randomUUID(), "Volkswagen", "Golf", "KR01442", "2010", "Diesel", user2.getId());
        this.carRepository.save(car1);
        Car car2 = new Car(UUID.randomUUID(), "Audi", "A3", "KR01222", "2011", "Diesel", user2.getId());
        this.carRepository.save(car2);
        Car car3 = new Car(UUID.randomUUID(), "Opel", "Astra", "KR02522", "2014", "Benzyna", user3.getId());
        this.carRepository.save(car3);
        Repair r1 = new Repair(UUID.randomUUID(), car1.getId(), new Date());
        this.repairRepository.save(r1);
        Repair r2 = new Repair(UUID.randomUUID(), car2.getId(), new Date());
        this.repairRepository.save(r2);
    }
}
