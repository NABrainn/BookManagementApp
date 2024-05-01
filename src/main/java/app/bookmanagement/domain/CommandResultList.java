package app.bookmanagement.domain;

import java.util.ArrayList;
import java.util.List;

public class CommandResultList {

    private List<Boolean> results;

    public CommandResultList() {
        this.results = new ArrayList<>();
    }

    public void add(boolean result) {
        this.results.add(result);
    }

    public List<Boolean> getResults() {
        return this.results;
    }

}
