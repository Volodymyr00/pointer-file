import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Zooclub implements Serializable {
    private List<Pet> list;
    private Map<Person, List<Pet>> map;


    public Zooclub() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }

    void addPerson(Person person) {
        map.putIfAbsent(person, new ArrayList<>());
    }

    void addPetToPerson(Person personName, Pet pet) {
        map.computeIfPresent(personName, (person, petList) -> {
            petList.add(pet);
            return petList;
        });
    }

    void removePetFromPerson(Person personName, Pet pet) {
        map.computeIfPresent(personName, (person, petList) -> {
            petList.remove(pet);
            return petList;
        });
    }

    void deletePerson(Person personName) {
        map.remove(personName);
    }

    void deletePetFromAllPersons(Pet pet) {
        for (Person person : map.keySet()) {
            list = map.get(person);
            list.remove(pet);
            map.replace(person, list);
        }

    }

    void printZooClub() {
        map.forEach((person, petList) -> System.out.println(person.toString() + petList));
    }

    @Override
    public String toString() {
        return "Zooclub{" +
                "list=" + list +
                ", map=" + map +
                '}';
    }

}