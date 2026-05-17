package com.weddingplanner.service;

import com.weddingplanner.model.Catering;
import com.weddingplanner.model.Decoration;
import com.weddingplanner.model.MusicBand;
import com.weddingplanner.model.Photographer;
import com.weddingplanner.model.Vendor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendorService {
    private static final String FILE = "vendors.txt";
    private final FileStorageService storage;

    public VendorService(FileStorageService storage) {
        this.storage = storage;
    }

    public Vendor add(Vendor vendor) {
        vendor.setId(storage.nextId("VEN"));
        List<Vendor> vendors = findAll();
        vendors.add(vendor);
        save(vendors);
        return vendor;
    }

    public List<Vendor> findAll() {
        return storage.readRecords(FILE).stream().map(this::toVendor).collect(Collectors.toList());
    }

    public List<Vendor> search(String category, String keyword) {
        return findAll().stream()
                .filter(v -> category == null || category.isEmpty() || v.getCategory().equalsIgnoreCase(category))
                .filter(v -> keyword == null || keyword.isEmpty() || v.getName().toLowerCase().contains(keyword.toLowerCase()) || v.getLocation().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Optional<Vendor> findById(String id) {
        return findAll().stream().filter(vendor -> vendor.getId().equals(id)).findFirst();
    }

    public void update(Vendor updated) {
        save(findAll().stream().map(vendor -> vendor.getId().equals(updated.getId()) ? updated : vendor).collect(Collectors.toList()));
    }

    public void delete(String id) {
        save(findAll().stream().filter(vendor -> !vendor.getId().equals(id)).collect(Collectors.toList()));
    }

    private void save(List<Vendor> vendors) {
        storage.writeRecords(FILE, vendors.stream().map(this::fromVendor).collect(Collectors.toList()));
    }

    public Vendor createByCategory(String id, String category, String name, String phone, String location, double packagePrice, boolean available) {
        Vendor vendor;
        if ("Catering".equalsIgnoreCase(category)) {
            vendor = new Catering(id, name, phone, location, packagePrice, available);
        } else if ("Decoration".equalsIgnoreCase(category)) {
            vendor = new Decoration(id, name, phone, location, packagePrice, available);
        } else if ("MusicBand".equalsIgnoreCase(category)) {
            vendor = new MusicBand(id, name, phone, location, packagePrice, available);
        } else {
            vendor = new Photographer(id, name, phone, location, packagePrice, available);
        }
        return vendor;
    }

    private Vendor toVendor(String[] parts) {
        return createByCategory(value(parts, 0), value(parts, 2), value(parts, 1), value(parts, 3), value(parts, 4), parseDouble(value(parts, 5)), Boolean.parseBoolean(value(parts, 6)));
    }

    private String fromVendor(Vendor vendor) {
        return String.join("|", vendor.getId(), vendor.getName(), vendor.getCategory(), vendor.getPhone(), vendor.getLocation(), String.valueOf(vendor.getPackagePrice()), String.valueOf(vendor.isAvailable()));
    }

    private double parseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    private String value(String[] parts, int index) {
        return index < parts.length ? parts[index] : "";
    }
}
