package housit.housit_backend.controller;

import housit.housit_backend.dto.reponse.EventDto;
import housit.housit_backend.dto.request.EventSaveDto;
import housit.housit_backend.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping("/room/{roomId}/events")
    public List<EventDto> getEvents(@PathVariable Long roomId) {
        log.info("Get events from room {}", roomId);
        return eventService.getEvents(roomId);
    }

    @PostMapping("/room/{roomId}/events")
    public EventDto createEvents(@PathVariable Long roomId,
                                       @RequestBody EventSaveDto eventSaveDto) {
        return eventService.createEvent(roomId, eventSaveDto);
    }

    @PutMapping("/room/{roomId}/events/{eventId}")
    public EventDto updateEvents(@PathVariable Long roomId,
                                       @PathVariable Long eventId,
                                       @RequestBody EventSaveDto eventSaveDto) {
        return eventService.updateEvent(roomId, eventId, eventSaveDto);
    }

    @DeleteMapping("/room/{roomId}/events/{eventId}")
    public void deleteEvents(@PathVariable Long roomId,
                                 @PathVariable Long eventId) {
        eventService.deleteEvent(roomId, eventId);
    }
}
