package com.pocmh.ketrika;

import javax.annotation.Nullable;

public class Result {
   @Nullable
    private String resultat;

    public Result(@Nullable String resultat) {
        this.resultat = resultat;
    }

    @Nullable
    public String getResultat() {
        return resultat;
    }

    public void setResultat(@Nullable String resultat) {
        this.resultat = resultat;
    }
}
