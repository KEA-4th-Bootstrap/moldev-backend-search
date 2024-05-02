package org.bootstrap.search.document;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Post (
        String Table,
        String post_state,
        String similarity_key_type,
        String important_key_type,
        LocalDateTime last_modified_date,
        String title,
        String content,
        String dormitory_type,
        Long post_id,
        Long user_id,
        Long id,
        LocalDateTime create_date,
        LocalDate end_date,
        LocalDateTime _timestamp,
        String room_type
){

}
