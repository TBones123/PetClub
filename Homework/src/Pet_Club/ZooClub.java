package Pet_Club;

import java.util.*;

public class ZooClub {
    Map<Person, List<PetClub>> personListMap = new HashMap<>();
//    List<PetClub> petClubList = new ArrayList<>();

    public void addPetToPerson(String namePerson, String namePet) {
        Set<Map.Entry<Person, List<PetClub>>> entries = personListMap.entrySet();
        Iterator<Map.Entry<Person, List<PetClub>>> entryIterator = entries.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<Person, List<PetClub>> listEntry = entryIterator.next();
            Person key = listEntry.getKey();
            if (key.getName().equals(namePerson)) {
                List<PetClub> value = listEntry.getValue();
                value.add(new PetClub(namePet));
            }
        }
    }

    public void remove_pet(String namePet, String name) {
        Set<Map.Entry<Person, List<PetClub>>> entries = personListMap.entrySet();
        Iterator<Map.Entry<Person, List<PetClub>>> entryIterator = entries.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<Person, List<PetClub>> listEntry = entryIterator.next();
            Person key = listEntry.getKey();
            if (key.getName().equals(name)) {
                List<PetClub> value = listEntry.getValue();
                Iterator<PetClub> clubIterator = value.iterator();
                while (clubIterator.hasNext()) {
                    PetClub petClub = clubIterator.next();
                    if (petClub.getNamePet().equals(namePet)) {
                        clubIterator.remove();
                    }

                }
            }
        }
    }

    public void removeAllPet(String namePet) {
        Set<Map.Entry<Person, List<PetClub>>> entries = personListMap.entrySet();
        Iterator<Map.Entry<Person, List<PetClub>>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Person, List<PetClub>> personListEntry = iterator.next();
            List<PetClub> value = personListEntry.getValue();
            Iterator<PetClub> petClubIterator = value.iterator();
            while (petClubIterator.hasNext()) {
                PetClub petClub = petClubIterator.next();
                if (petClub.getNamePet().equals(namePet)) {
                    petClubIterator.remove();
                }
            }
        }
    }

    public void removePerson(String namePerson) {
        Set<Map.Entry<Person, List<PetClub>>> entrySet = personListMap.entrySet();
        Iterator<Map.Entry<Person, List<PetClub>>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Person, List<PetClub>> next = iterator.next();
            Person key = next.getKey();
            if (key.getName().equals(namePerson)) {
                iterator.remove();
            }
        }
    }

    public Person createPerson(String name) {
        Person person = new Person(name);
        List<PetClub> petClubList = new ArrayList<>();
        personListMap.put(person, petClubList);
        return person;
    }

    public Map<Person, List<PetClub>> showList() {
        return personListMap;
    }
}
