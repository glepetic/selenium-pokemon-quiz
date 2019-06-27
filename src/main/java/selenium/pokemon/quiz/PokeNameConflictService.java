package selenium.pokemon.quiz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PokeNameConflictService {

    public List<String> sortPokemonNamesToAvoidConflicts(List<String> pokeNames) {
        List<String> pokemonSorted = new ArrayList<>();
        List<String> pokemonWithConflict = getPokeNamesWithConflict(pokeNames);
        List<String> pokemonWithoutConflict = new ArrayList<>(pokeNames);
        pokemonWithoutConflict.removeAll(pokemonWithConflict);
        pokemonSorted.addAll(pokemonWithoutConflict);
        pokemonSorted.addAll(pokemonWithConflict);
        return pokemonSorted;
    }

    private List<String> getPokeNamesWithConflict(List<String> pokeNames) {
        return pokeNames
                .stream()
                .flatMap(pokeName1 -> {
                    List<String> pokeNamesAux = new ArrayList<>(pokeNames);
                    pokeNamesAux.remove(pokeName1);
                    return pokeNamesAux
                            .stream()
                            .filter(pokeName2 -> pokeName2.startsWith(pokeName1));
                })
                .collect(Collectors.toList());
    }

}
