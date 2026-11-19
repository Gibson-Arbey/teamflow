package co.model.community;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Community {

    private final UUID id;
    private final String name;
    private final String description;
    private final CommunityVisibility visibility;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    private Community(UUID id, String name, String description, CommunityVisibility visibility, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.visibility = visibility;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Community create(String name, String description, CommunityVisibility visibility) {
        LocalDateTime now = LocalDateTime.now();
        return new Community(UUID.randomUUID(), name, description, visibility, now, now);
    }

    public static Community restore(UUID id, String name, String description, CommunityVisibility visibility, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new Community(id, name, description, visibility, createdAt, updatedAt);
    }
}
