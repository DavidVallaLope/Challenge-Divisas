package com.davidval;

import com.davidval.business.Divisas;
import com.davidval.gui.DivisasGUI;
import com.davidval.http.Consumer;
import com.davidval.http.JsonMapper;

import java.net.URISyntaxException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        Divisas divisas = new Divisas(new HashMap<>());
        JsonMapper jsonMapper = new JsonMapper(new Consumer("https://v6.exchangerate-api.com/v6/<authkey>/latest/MXN"), divisas);
        jsonMapper.convertJsonToMap();

        DivisasGUI gui = new DivisasGUI(divisas,true);
        gui.setDropToConvert(divisas.getMapOfDivisas().keySet());
    }
}
