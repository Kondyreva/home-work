package com.sbrf.reboot.atm.cassettes;

import java.util.ArrayList;
import java.util.List;

public class Cassette<T extends Banknote> {
    List<T> someBanknote = new ArrayList<>();

    public Cassette(List<T> inputBanknote) {
        if (!inputBanknote.isEmpty()) {
            this.someBanknote.addAll(inputBanknote);
        }
    }

    public int getCountBanknotes() {
        return someBanknote.size();
    }
}
