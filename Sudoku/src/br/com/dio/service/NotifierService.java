package br.com.dio.service;

import static br.com.dio.service.EventEnum.CLEAR_SPACE;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.dio.ui.custom.input.NumberText;

public class NotifierService {


    private final Map<EventEnum, List<EventListener>> listeners = new HashMap<>(){{
        put(CLEAR_SPACE, new ArrayList<>());
    }};


    public void subscribe(final EventEnum eventType, NumberText t){
        var selectedListeners = listeners.get(eventType);
        selectedListeners.add(t);
    }


    public void notify (final EventEnum eventType ){
        listeners.get(eventType).forEach(l -> l.update(eventType));
    }
}
