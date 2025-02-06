package com.wildlighttech.barsync_events_api.venue;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VenueService {
    private final List<Venue> venues = new ArrayList<>();

    public List<Venue> getVenues() {
        return this.venues;
    }

    public Venue getVenueById(Long venueId) {
        return this.venues
                .stream()
                .filter(venue -> venue.id().equals(venueId))
                .findAny()
                .orElse(null);
    }

    public void createVenue(Venue venue) {
        this.venues.add(venue);
    }

    public void updateVenue(Venue venue, Long venueId) {
        for(int i = 0; i < this.venues.size(); i++) {
            if(this.venues.get(i).id().equals(venueId)) {
                this.venues.set(i, venue);
                // break; <- Will not update every value with the associated id
            }
        }
    }

    public void deleteVenue(Long id) {
        this.venues.removeIf(venue -> venue.id().equals(id));
    }
}
