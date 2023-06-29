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
        String authkey = args[0].substring(15);
        String api = String.format("https://v6.exchangerate-api.com/v6/%s/latest/MXN",authkey);
        JsonMapper jsonMapper = new JsonMapper(new Consumer(api), divisas);
        jsonMapper.convertJsonToMap();

        DivisasGUI gui = new DivisasGUI(divisas,true);
        gui.setDropToConvert(divisas.getMapOfDivisas().keySet());
    }
}
