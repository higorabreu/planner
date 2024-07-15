package com.rocketseat.planner.Link;

import com.rocketseat.planner.Trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LinkService {

    @Autowired
    private LinkRepository repository;

    public LinkResponse registerLink(LinkRequestPayload payload, Trip trip) {
        Link newLink = new Link(payload.url(), payload.title(), trip);

        this.repository.save(newLink);

        return new LinkResponse(newLink.getId());
    }

    public List<LinkData> getAllLinksFromEvent(UUID tripId) {
        return this.repository.findByTripId(tripId).stream().map(activity -> new LinkData(activity.getId(), activity.getUrl(), activity.getTitle())).toList();
    }
}
