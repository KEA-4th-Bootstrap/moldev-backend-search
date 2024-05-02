package org.bootstrap.search.dto.support;

import lombok.Builder;
import org.bootstrap.search.document.Post;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record PostDto(
        String post_state,
        String similarity_key_type,
        String important_key_type,
        String last_modified_date,
        String title,
        String content,
        String dormitory_type,
        String post_id,
        String user_id,
        String id,
        String create_date,
        String end_date,
        String room_type
) {
    public static PostDto of(Post post) {
        return PostDto.builder()
                .post_state(post.post_state())
                .similarity_key_type(post.similarity_key_type())
                .important_key_type(post.important_key_type())
                .last_modified_date(post.last_modified_date())
                .title(post.title())
                .content(post.content())
                .dormitory_type(post.dormitory_type())
                .post_id(post.post_id())
                .user_id(post.user_id())
                .id(post.id())
                .create_date(post.create_date())
                .end_date(post.end_date())
                .room_type(post.room_type())
                .build();
    }
}
