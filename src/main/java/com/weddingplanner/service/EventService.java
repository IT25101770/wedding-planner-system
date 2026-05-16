package com.weddingplanner.service;

import com.weddingplanner.model.WeddingEvent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {
    private static final String FILE = "events.txt";
    private final FileStorageService storage;

    public EventService(FileStorageService storage) {
        this.storage = storage;
    }

    public WeddingEvent add(WeddingEvent event) {
        event.setId(storage.nextId("EVT"));
        List<WeddingEvent> events = findAll();
        events.add(event);
        save(events);
        return event;
    }

    public List<WeddingEvent> findAll() {
        return storage.readRecords(FILE).stream().map(this::toEvent).collect(Collectors.toList());
    }

    public List<WeddingEvent> findByCustomer(String customerId) {
        return findAll().stream().filter(event -> event.getCustomerId().equals(customerId)).collect(Collectors.toList());
    }

    public Optional<WeddingEvent> findById(String id) {
        return findAll().stream().filter(event -> event.getId().equals(id)).findFirst();
    }

    public void update(WeddingEvent updated) {
        save(findAll().stream().map(event -> event.getId().equals(updated.getId()) ? updated : event).collect(Collectors.toList()));
    }

    public void delete(String id) {
        save(findAll().stream().filter(event -> !event.getId().equals(id)).collect(Collectors.toList()));
    }

    private void save(List<WeddingEvent> events) {
        storage.writeRecords(FILE, events.stream().map(this::fromEvent).collect(Collectors.toList()));
    }

    private WeddingEvent toEvent(String[] parts) {
        return new WeddingEvent(value(parts, 0), value(parts, 1), value(parts, 2), value(parts, 3), parseInt(value(parts, 4)), value(parts, 5));
    }

    private String fromEvent(WeddingEvent event) {
        return String.join("|", event.getId(), event.getCustomerId(), event.getDate(), event.getVenue(), String.valueOf(event.getGuestCount()), event.getTheme());
    }

    private int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    private String value(String[] parts, int index) {
        return index < parts.length ? parts[index] : "";
    }
}
