package org.bootstrap.search.document;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Post (
        String Table,
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
        String _timestamp,
        String room_type
){

}
