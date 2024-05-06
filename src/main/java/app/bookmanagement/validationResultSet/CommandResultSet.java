package app.bookmanagement.validationResultSet;

import java.util.*;

public class CommandResultSet {

    private Set<Boolean> results;

    public CommandResultSet() {
        this.results = new HashSet<>();
    }

    public void add(boolean result) {
        results.add(result);
    }

    public Set<Boolean> getResults() {
        return results;
    }

}
