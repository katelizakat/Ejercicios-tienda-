package com.prueba.automationtest.abilities;

import com.prueba.automationtest.util.dbconection.DataBaseUtils;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

import java.util.Map;

public class DataBaseInteraction implements Ability{

    private final DataBaseUtils dataBaseUtils;

    public DataBaseUtils getDBUtils() {
        return dataBaseUtils;
    }
    public DataBaseInteraction(Map<String, Object> config) {
        this.dataBaseUtils =
                new DataBaseUtils(config);
    }

    public static DataBaseInteraction using(Map<String, Object> config) {
        return new DataBaseInteraction(config);
    }

    public static DataBaseInteraction as(Actor actor) {
        return actor.abilityTo(DataBaseInteraction.class);
    }
}