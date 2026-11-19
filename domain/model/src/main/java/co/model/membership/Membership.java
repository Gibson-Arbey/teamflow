package co.model.membership;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Membership {

    private final UUID id;
    private final UUID userId;
    private final UUID communityId;
    private final CommunityRole role;
    private final MembershipStatus status;
    private final LocalDateTime joinedAt;

    private Membership(UUID id, UUID userId, UUID communityId, CommunityRole role, MembershipStatus status, LocalDateTime joinedAt) {
        this.id = id;
        this.userId = userId;
        this.communityId = communityId;
        this.role = role;
        this.status = status;
        this.joinedAt = joinedAt;
    }

    public static Membership create(UUID userId, UUID communityId, CommunityRole role, MembershipStatus status) {
        return new Membership(UUID.randomUUID(), userId, communityId, role, status, LocalDateTime.now());
    }

    public static Membership restore(UUID id, UUID userId, UUID communityId, CommunityRole role, MembershipStatus status, LocalDateTime joinedAt) {
        return new Membership(id, userId, communityId, role, status, joinedAt);
    }
}
