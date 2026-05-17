package com.weddingplanner.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class FileStorageService {
    private final Path dataDirectory;

    public FileStorageService(@Value("${wedding.data.dir:data}") String dataDirectory) {
        this.dataDirectory = Paths.get(dataDirectory);
    }

    @PostConstruct
    public void initialize() throws IOException {
        Files.createDirectories(dataDirectory);
        for (String file : Arrays.asList("users.txt", "admins.txt", "vendors.txt", "events.txt", "bookings.txt", "payments.txt", "feedbacks.txt")) {
            Path path = resolve(file);
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        }
    }

    public List<String[]> readRecords(String fileName) {
        List<String[]> records = new ArrayList<>();
        Path path = resolve(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    records.add(line.split("\\|", -1));
                }
            }
        } catch (IOException ex) {
            throw new IllegalStateException("Unable to read " + fileName, ex);
        }
        return records;
    }

    public void writeRecords(String fileName, List<String> lines) {
        Path path = resolve(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException ex) {
            throw new IllegalStateException("Unable to write " + fileName, ex);
        }
    }

    public String nextId(String prefix) {
        return prefix + "-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public Path resolve(String fileName) {
        return dataDirectory.resolve(fileName);
    }
}
