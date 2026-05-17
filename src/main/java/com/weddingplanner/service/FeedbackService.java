package com.weddingplanner.service;

import com.weddingplanner.model.Feedback;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FeedbackService {
    private static final String FILE = "feedbacks.txt";
    private final FileStorageService storage;

    public FeedbackService(FileStorageService storage) {
        this.storage = storage;
    }

    public Feedback add(Feedback feedback) {
        feedback.setId(storage.nextId("FDB"));
        if (feedback.getSubmittedDate() == null || feedback.getSubmittedDate().isEmpty()) {
            feedback.setSubmittedDate(LocalDate.now().toString());
        }
        if (feedback.getStatus() == null || feedback.getStatus().isEmpty()) {
            feedback.setStatus("New");
        }
        List<Feedback> feedbacks = findAll();
        feedbacks.add(feedback);
        save(feedbacks);
        return feedback;
    }

    public List<Feedback> findAll() {
        return storage.readRecords(FILE).stream().map(this::toFeedback).collect(Collectors.toList());
    }

    public List<Feedback> findByCustomer(String customerId) {
        return findAll().stream().filter(feedback -> feedback.getCustomerId().equals(customerId)).collect(Collectors.toList());
    }

    public Optional<Feedback> findById(String id) {
        return findAll().stream().filter(feedback -> feedback.getId().equals(id)).findFirst();
    }

    public void update(Feedback updated) {
        save(findAll().stream().map(feedback -> feedback.getId().equals(updated.getId()) ? updated : feedback).collect(Collectors.toList()));
    }

    public void updateStatus(String id, String status) {
        save(findAll().stream().map(feedback -> {
            if (feedback.getId().equals(id)) {
                feedback.setStatus(status);
            }
            return feedback;
        }).collect(Collectors.toList()));
    }

    public void delete(String id) {
        save(findAll().stream().filter(feedback -> !feedback.getId().equals(id)).collect(Collectors.toList()));
    }

    private void save(List<Feedback> feedbacks) {
        storage.writeRecords(FILE, feedbacks.stream().map(this::fromFeedback).collect(Collectors.toList()));
    }

    private Feedback toFeedback(String[] parts) {
        return new Feedback(value(parts, 0), value(parts, 1), value(parts, 2), value(parts, 3), parseInt(value(parts, 4)), value(parts, 5), value(parts, 6), value(parts, 7));
    }

    private String fromFeedback(Feedback feedback) {
        return String.join("|", feedback.getId(), feedback.getCustomerId(), feedback.getName(), feedback.getEmail(), String.valueOf(feedback.getRating()), feedback.getMessage(), feedback.getStatus(), feedback.getSubmittedDate());
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
