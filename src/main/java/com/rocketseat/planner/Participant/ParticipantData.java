package com.rocketseat.planner.Participant;

import java.util.UUID;

public record ParticipantData(UUID id, String name, String email, Boolean isConfirmed) {
}
