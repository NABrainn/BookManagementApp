package app.bookmanagement.validationResultList;

import java.util.*;

public class CommandResultList {

    private Set<Boolean> results;

    public CommandResultList() {
        this.results = new HashSet<>();
    }

    public void add(boolean result) {
        results.add(result);
    }

    public Set<Boolean> getResults() {
        return results;
    }

}
