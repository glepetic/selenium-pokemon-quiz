package selenium.pokemon.quiz.utils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorter {

    public List<String> sortByNameLength(List<String> pokeNames) {
        return pokeNames.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

}
