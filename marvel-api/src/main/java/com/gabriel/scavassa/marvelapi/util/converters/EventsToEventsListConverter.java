package com.gabriel.scavassa.marvelapi.util.converters;

import com.gabriel.scavassa.marvelapi.domain.Event;
import com.gabriel.scavassa.marvelapi.dtos.lists.EventList;

import java.util.ArrayList;
import java.util.List;

public class EventsToEventsListConverter {

    static public List<EventList> eventToEventList(List<Event> events) {
        List<EventList> listOfStorieList = new ArrayList<>();
        for (Event event : events) {
            EventList eventList = new EventList();
            eventList.setAvaliable(events.size());
            if (events.size() > 20)
                eventList.setReturned(20);
            eventList.setReturned(events.size());
            eventList.setCollectionURI("Http://" + event.getTitle() + "comicCollectionURI");
            eventList.addEventSumary(event.getNext(), events.size());

            listOfStorieList.add(eventList);
        }
        return listOfStorieList;
    }
}
